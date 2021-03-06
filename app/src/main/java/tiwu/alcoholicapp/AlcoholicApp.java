package tiwu.alcoholicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class AlcoholicApp extends AppCompatActivity {
    protected CounterUnit management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcoholic_app);

        management = new CounterUnit(this);

        AddCounter.main = management;
        management.startUp();

        Button addCounter = (Button) findViewById(R.id.addCounter);
        addCounter.setOnClickListener(new AddCounterListener());
    }

    @Override
    protected void onDestroy(){
        management.shutdown();
        super.onDestroy();

    }

    private class AddCounterListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(AlcoholicApp.this,AddCounter.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alcoholic_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

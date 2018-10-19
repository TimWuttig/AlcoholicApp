package tiwu.alcoholicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddCounter extends AppCompatActivity {

    protected static CounterUnit main;
    protected EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_counter);

        input = (EditText) findViewById(R.id.getName);
        Button btn = (Button) findViewById(R.id.enter);

        btn.setOnClickListener(new Listener(this));
    }

    private class Listener implements View.OnClickListener{

        AddCounter addCounter;
        public Listener(AddCounter addCounter) {
            this.addCounter = addCounter;
        }

        @Override
        public void onClick(View view) {
            main.addCounter(input.getText().toString());
            addCounter.finish();
        }
    }
}

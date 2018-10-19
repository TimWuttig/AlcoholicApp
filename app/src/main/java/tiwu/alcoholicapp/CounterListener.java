package tiwu.alcoholicapp;

import android.view.View;

/**
 * Created by tim on 19.10.18.
 * On Click the counter will be incremented
 */

public class CounterListener implements View.OnClickListener{
    private Counter counter;

    public CounterListener(Counter counter){
        this.counter = counter;
    }

    @Override
    public void onClick(View view) {
        counter.increment();
        counter.represent.setText(counter.name + "                     " + counter.count);
        counter.management.setDirtyFlag(true);
    }
}

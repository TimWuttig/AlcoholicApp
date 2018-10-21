package tiwu.alcoholicapp;

import android.widget.Button;
import android.widget.LinearLayout;

import java.util.LinkedList;

/**
 * Created by tim on 19.10.18.
 * Represents on Counter
 */

class Counter {
    protected int count;
    protected String name;
    protected Button represent;
    protected CounterUnit management;

    //Important for restoring the app status
    public Counter(String name, int count, CounterUnit management){
        this.name = name;
        this.count = count;
        this.management = management;
        setRepresent();
    }

    //Important for adding a new Counter
    public Counter(String name, CounterUnit management){
        this.name = name;
        this.count = 0;
        this.management = management;
        setRepresent();
    }

    private void setRepresent(){
        //set Listener and name
        represent = new Button(management.alcoholicApp);
        represent.setOnClickListener(new CounterListener(this));
        represent.setOnLongClickListener(new CountPopupListener(this));
        represent.setText(name + "                     " + count);
        represent.setTextSize(24);

        //add Button to Screen
        LinearLayout layout = (LinearLayout) management.alcoholicApp.findViewById(R.id.counters);
        layout.addView(represent);

        //set Size of Button
        represent.setWidth(layout.getWidth());
        represent.setHeight(200);
    }

    public void increment(){
        count++;
        management.setDirtyFlag(true);
    }

    public void delete() {
        LinearLayout layout = (LinearLayout) management.alcoholicApp.findViewById(R.id.counters);
        layout.removeView(represent);
        management.deleteCounter(this);
    }
}

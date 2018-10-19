package tiwu.alcoholicapp;

import java.util.LinkedList;

/**
 * Created by tim on 19.10.18.
 * Manage the Counters
 */

public class CounterUnit {
    private LinkedList<Counter> counters;
    protected AlcoholicApp alcoholicApp;
    private volatile boolean dirtyFlag = false;

    public CounterUnit(AlcoholicApp alcoholicApp){
        this.alcoholicApp = alcoholicApp;
        counters = new LinkedList<Counter>();
    }

    public void addCounter(String name){
        Counter c = new Counter(name, this);
        counters.add(c);
        setDirtyFlag(true);
    }

    public synchronized void setDirtyFlag(boolean status){
        dirtyFlag = status;
    }
}

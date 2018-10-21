package tiwu.alcoholicapp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tim on 19.10.18.
 * Manage the Counters
 */

public class CounterUnit {
    private LinkedList<Counter> counters;
    private HashMap<String,Integer> data;
    private Safer safer;
    protected AlcoholicApp alcoholicApp;
    private volatile boolean dirtyFlag = false; //False: Nothing changed True: Appstate must be saved

    public CounterUnit(AlcoholicApp alcoholicApp){
        this.alcoholicApp = alcoholicApp;
        safer = new Safer(alcoholicApp);
        counters = new LinkedList<Counter>();
        data = new HashMap<String,Integer>();
    }

    public void addCounter(String name){
        Counter c = new Counter(name, this);
        counters.add(c);
        data.put(name, 0);
        setDirtyFlag(true);
    }

    public synchronized void setDirtyFlag(boolean status){
        dirtyFlag = status;
    }

    public void shutdown(){
        //test if something was changed
        if(dirtyFlag == false) return;

        data.clear();
        for(Counter c: counters) {
            data.put(c.name, c.count);
        }

        safer.safe(data);
        setDirtyFlag(false);
    }

    public void startUp(){
        data = safer.restore();
        for(Map.Entry<String,Integer> e: data.entrySet()){
            Counter c = new Counter(e.getKey(),e.getValue().intValue(),this);
            counters.add(c);
        }
        setDirtyFlag(false);
    }

    public void deleteCounter(Counter counter) {
        counters.remove(counter);
        setDirtyFlag(true);
    }
}

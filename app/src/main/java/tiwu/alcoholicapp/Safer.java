package tiwu.alcoholicapp;

import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tim on 19.10.18.
 * This modul safes and restores Appstate
 */

public class Safer{
    private AlcoholicApp alcoholicApp;
    private BufferedWriter writer;
    private BufferedReader reader;

    /*
    Set connection to MainActivity and open writer and reader
     */
    public Safer(AlcoholicApp alcoholicApp){
        this.alcoholicApp = alcoholicApp;
    }

    /*
    Saves the App state
     */
    public void safe(HashMap<String, Integer> data){
       try {
           BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(alcoholicApp.openFileOutput("data.txt", alcoholicApp.MODE_PRIVATE)));
           for(Map.Entry<String, Integer> e: data.entrySet()) {
               writer.write(e.getKey() + ";" + e.getValue().toString() + "\n");
               writer.flush();
           }
           writer.close();
       } catch (IOException e1) {
               e1.printStackTrace();
       }
    }

    /*
    Restore the last App state
     */
    public HashMap<String,Integer> restore(){
        HashMap<String,Integer> erg = new HashMap<String, Integer>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(alcoholicApp.openFileInput("data.txt")));
            String line = reader.readLine();
            while(line != null){
                String key = line.substring(0,line.indexOf(";"));
                Integer value = new Integer(line.substring(line.indexOf(";")+1));
                erg.put(key,value);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            //return null;
        }
        return erg;
    }
}

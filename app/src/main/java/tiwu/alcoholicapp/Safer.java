package tiwu.alcoholicapp;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by tim on 19.10.18.
 * This modul safes and restores Appstate
 */

public class Safer{
    private AlcoholicApp alcoholicApp;
    private BufferedWriter writer;
    private BufferedReader reader;
    private volatile boolean dirtyFlag = false; //False: Nothing changed True: Appstate must be saved

    /*
    Set connection to MainActivity and open writer and reader
     */
    public Safer(AlcoholicApp alcoholicApp){
        this.alcoholicApp = alcoholicApp;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(alcoholicApp.openFileOutput("data.txt", alcoholicApp.MODE_PRIVATE)));
            reader = new BufferedReader(new InputStreamReader(alcoholicApp.openFileInput("data.txt")));

        }catch(FileNotFoundException notFound){
            Toast.makeText(alcoholicApp,"Error by reading App Data: Savefile was not found",Toast.LENGTH_LONG).show();
        }
    }


    public synchronized void setFlag(boolean status){
        dirtyFlag = status;
    }

    /*
    Saves the App state
     */
    public void safe(){

    }

    /*
    Restore the last App state
     */
    public void restore(){

    }
}

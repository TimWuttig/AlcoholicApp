package tiwu.alcoholicapp;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test_safer() throws Exception {
        Safer safer= new Safer(new AlcoholicApp());
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("Bier",5);
        map.put("Wasser",3);
        map.put("BC",0);
        safer.safe(map);
        assertEquals(map, safer.restore());
    }
}
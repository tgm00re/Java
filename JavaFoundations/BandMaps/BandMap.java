import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BandMap {
    public static void main(String[] args) {

        //Create hashmap
        Map<String, String> songMap = new HashMap<String, String>();

        //add 4 songs
        songMap.put("Carry On My Wayward Son", "There will be peace when you are done");
        songMap.put("Smells Like Teen Spirit", "Hello, hello, hello...");
        songMap.put("It's All About the Pentiums", "Wanna be hackers? Code crackers? Slackers");
        songMap.put("Fear Not This Night", "Auroras make circumstances in the solitude of our life");


        System.out.println(songMap.get("Carry On My Wayward Son"));

        Set<String> keySet = songMap.keySet();
        for(String key : keySet){
            System.out.println(key + ": " + songMap.get(key));
        }

    }
}

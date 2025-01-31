package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Synonyms {

    private final static ArrayList<String> areaSynonyms = new ArrayList<>(Arrays.asList("Area", "Surroundings", "Main.Room"));

    public static boolean isAreaSyn(String word){
        for(String Synonym : areaSynonyms){
            if(word.equalsIgnoreCase(Synonym)){
                return true;
            }
        }
        return false;
    }

}

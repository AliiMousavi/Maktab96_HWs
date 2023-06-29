package Q1;

import java.util.ArrayList;
import java.util.Collections;

public class samecharacters {

    public static String compareCharacterLists(ArrayList<Character> list1,
                                         ArrayList<Character> list2) {
        if (list1.size() != list2.size()) {
            return "Fail";
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return "Fail";
            }
        }

        return "Pass";
    }
    public static ArrayList<Character> getCharacterList(String name) {

        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            characters.add(c);
        }
        return characters;
    }


    public static void main(String[] args) {
        String name1 = "naser";
        String name2 = "naserr";

        System.out.println(compareCharacterLists(getCharacterList(name1), getCharacterList(name2)));
    }
}

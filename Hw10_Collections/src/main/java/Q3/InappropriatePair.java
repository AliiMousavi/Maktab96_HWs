package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InappropriatePair {

    public static ArrayList<Integer> deleteInappropriatePair(ArrayList<Integer> arrayList) {
        if (arrayList == null)
            return arrayList;
        if (arrayList.size() % 2 != 0) {
            arrayList.remove(arrayList.size() - 1);
        }
        for (int i = arrayList.size()-1 ; i >= 0 ; i-=2) {
            if(arrayList.get(i) > arrayList.get(i-1)) {
                arrayList.remove(i);
                arrayList.remove(i-1);
            }
        }
        return arrayList;
        }

    public static ArrayList<Integer> addingArrayToArraylist(Integer[] numbers) {
        return new ArrayList<>(Arrays.asList(numbers));
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 3, 7, 4, 3, 6, 5, 8, 5, 5, 2, 9, 7, 3};
        ArrayList<Integer> listOfNumbers = addingArrayToArraylist(numbers);

        System.out.println(deleteInappropriatePair(new ArrayList<>()));

    }
    }

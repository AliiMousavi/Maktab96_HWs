package Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationByHashMap {
    public static List<String> getPermutation(String word) {
        List<String> result = new ArrayList<>();
        if (word == null || word.length() == 0){
            return result;
        }
        Map<Character, Integer> countOfPermutation = new HashMap<>();
        for (char c : word.toCharArray()) {
            countOfPermutation.put(c, countOfPermutation.getOrDefault(c, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(countOfPermutation, stringBuilder, word.length(), result);
        return result;
    }

    private static void backtrack(Map<Character, Integer> countOfPermutation, StringBuilder stringBuilder, int remaining, List<String> result) {
        if (remaining == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        for (char c : countOfPermutation.keySet()) {
            int count = countOfPermutation.get(c);
            if (count > 0) {
                countOfPermutation.put(c, count - 1);
                stringBuilder.append(c);
                backtrack(countOfPermutation, stringBuilder, remaining - 1, result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                countOfPermutation.put(c, count);
            }
        }
    }

    public static void main(String[] args) {
        String str = "cat";
        List<String> result = getPermutation(str);
        for (String s : result) {
            System.out.println(s);
        }
    }

}

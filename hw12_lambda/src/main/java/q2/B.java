package main.java.q2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B {

    public static String[] getStrings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some words: ");
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> wordsByLength = Arrays.stream(getStrings())
                .collect(Collectors.groupingBy(String::length));
        System.out.println(wordsByLength);
    }
}

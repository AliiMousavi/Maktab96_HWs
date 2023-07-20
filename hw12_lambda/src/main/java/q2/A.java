package main.java.q2;

import java.util.*;
import java.util.stream.Collectors;

public class A {
    public static String[] getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some words: ");
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> listMap = Arrays.stream(getString())
                .collect(Collectors.groupingBy(String::length));

        System.out.println(listMap.values());
    }
}

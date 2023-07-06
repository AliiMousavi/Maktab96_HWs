package main.java.q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class NumberGenerator {
    private List<Integer> evennumbers = new LinkedList<>();
    private List<Integer> oddnumbers = new LinkedList<>();
    protected List<Integer> finalnumbers = new LinkedList<>();
    private final int inputNumber;


    public NumberGenerator(int maxNumber) {
        this.inputNumber = maxNumber;
    }
    public List<Integer> getFinalnumbers() {
        return finalnumbers;
    }

    public List<Integer> getEvennumbers() {
        return evennumbers;
    }

    public List<Integer> getOddnumbers() {
        return oddnumbers;
    }

    public void setOddnumbers(List<Integer> oddnumbers) {
        this.oddnumbers = oddnumbers;
    }

    public void generateEvenNumbers() {

        for (int i =0; i <= inputNumber; i++) {
            if (i % 2 == 0)
                evennumbers.add(i);
        }
    }

    public void generateOddNumbers() {

        for (int i =0; i <= inputNumber; i++) {
            if (i % 2 != 0)
                oddnumbers.add(i);
        }
    }

    public synchronized void generatefinalNumbers(){

    }
}
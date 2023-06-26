package Q2;

import java.util.TreeSet;

public class TreeSetImpl {

    public static TreeSet<Character> union(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
        TreeSet<Character> unionSet = new TreeSet<>();
        unionSet.addAll(treeSet1);
        unionSet.addAll(treeSet2);
        return unionSet;
    }

    public static TreeSet<Character> subscription(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
        TreeSet<Character> subscriptionSet = new TreeSet<>();
        subscriptionSet.addAll(treeSet1);
        subscriptionSet.retainAll(treeSet2);
        return subscriptionSet;
    }
    public static void main(String[] args) {
        TreeSet<Character> letters1 = new TreeSet<>();
        letters1.add('a');
        letters1.add('s');
        letters1.add('d');
        letters1.add('f');
        letters1.add('g');
        letters1.add('h');
        letters1.add('q');
        letters1.add('w');
        letters1.add('e');
        letters1.add('r');
        System.out.println(letters1);




        TreeSet<Character> letters2 = new TreeSet<>();
        letters2.add('q');
        letters2.add('w');
        letters2.add('e');
        letters2.add('r');
        letters2.add('t');
        letters2.add('y');
        letters2.add('u');
        letters2.add('i');
        letters2.add('o');
        letters2.add('p');
        System.out.println(letters2);

        System.out.println(union(letters1, letters2));
        System.out.println(subscription(letters1, letters2));
    }
}

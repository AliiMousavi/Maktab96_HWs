package Q4;


import Q4.HashMap.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "ali");
        hashMap.put(2, "reza");
        System.out.println(hashMap);


        System.out.println("Hashmap has key 1 :" + hashMap.containsKey(1));
        System.out.println(hashMap.isEmpty());
        hashMap.replaceValue(1 , "naser");
        System.out.println(hashMap);




    }

}

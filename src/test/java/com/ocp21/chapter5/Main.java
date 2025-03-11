package com.ocp21.chapter5;

public class Main {

    public static void main(String[] args) {

        int x = 10;
        int y = x++;

//        System.out.println(""+y);
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            y++;
            System.out.println(y);
        }

        final String s;

        if (x==11){
            s = "x==11";
        }else {
            s = "x!=11";
        }
        System.out.println(s);

        int[] java;

        System.out.println("C");



    }
}

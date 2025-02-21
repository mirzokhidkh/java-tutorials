package com.ocp21.chapter3;

public class LoopExample {
    public static void main(String[] args) {
        OUTER_LOOP:
        for (int i = 0; i < 10; i++) {
            INNER_LOOP:
            for (int j = 0; j < 10; j++) {
                System.out.print(i + "-" + j + "\t");
            }
            System.out.println();
            if (i == 7) break;
        }


        int checkDate = 0;
        while (checkDate < 10) {
            checkDate++;
            if (checkDate > 100) {
                break;
                // DOES NOT COMPILE
            }
        }

        for (int i = 0; i < 10; i++) {
            continue;
        }

        int sing = 8, squawk = 2, notes = 0;
        while (sing > squawk) {
            sing--;
            System.out.println("sing="+sing);
            squawk += 2;
            notes += sing + squawk;
        }

        System.out.println(notes);


    }
}

package com.ocp21.chapter3;

public class SwitchExample {
    public static void main(String[] args) {


        int b = 111;
        int a = 1;

        switch (b) {
            default:
            case 1:
                a = 1;
                break;
        }

        var tailFeathers = 3;
        final var one = 1;
        switch (tailFeathers) {
            case one:
                System.out.print(3 + " ");
            case 3, 11:
            default:
                System.out.print(5 + " ");
        }
        while (tailFeathers > 1) {
            System.out.print(--tailFeathers + " ");
        }

        System.out.println();

        String instrument = "violin";
        final String CELLO = "cello";
        String viola = "viola";
        int p = -1;
        switch (instrument) {
            case "bass":
                break;
            case CELLO:
                p++;
            default:
                p++;
            case "VIOLIN":
                p++;
            case "viola":
                ++p;
                break;
        }
        System.out.print(p);

    }


}
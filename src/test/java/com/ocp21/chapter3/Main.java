package com.ocp21.chapter3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        printSeasonForMonth(1);

        printDetails(2);


        if ("aa".isEmpty())
            if ("aaa".isEmpty())
                System.out.println("kk");
            else System.out.println("kkkk");
        else System.out.println("kkkkkk");



    }
    void getFish (Object fish){
        if (!(fish instanceof String guppy))
            System.out.print("Eat!");
        else if (!(fish instanceof String gupjpy)) {
            throw new RuntimeException();
        }
        System.out.print("Swim!");
    }

    static void printSeasonForMonth(int month) {
        String value = switch (month) {
            case 1, 2, 3 -> "Winter-";
            case 4, 5, 6 -> "Spring-";
            case 7, 8, 9 -> "Summer-";
            case 10, 11, 12 -> "Fall-";
            default -> "Unknown-";
        };
        System.out.print(value);
    }

    static void printDetails(Number height) {
        String message = switch (height) {
            case Integer i -> "Rounded: " + i;
            case Double d -> "Precise: " + d;
            case Number n -> "Unknown: " + n;
        };
        System.out.print(message);
    }
}

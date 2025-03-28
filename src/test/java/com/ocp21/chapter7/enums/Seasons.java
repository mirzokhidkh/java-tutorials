package com.ocp21.chapter7.enums;

public enum Seasons {
    WINTER,
    SPRING,
    SUMMER,
    FALL;

    public static void main(String[] args) {
        for (Seasons value : Seasons.values()) {
            System.out.println(value.name() +"-"+value.ordinal());
        }

        Seasons s = Seasons.valueOf("FALLl");



    }
}

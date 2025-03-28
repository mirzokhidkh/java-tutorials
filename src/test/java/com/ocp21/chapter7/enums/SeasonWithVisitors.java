package com.ocp21.chapter7.enums;

interface Visitors {
    void printVisitors();
}

public enum SeasonWithVisitors implements Visitors {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"),
    FALL("Medium");

    private final String visitors;
    public static final String DESCRIPTION = "Weather enum";

    private SeasonWithVisitors(String visitors) {
        System.out.print("constructing,");
        this.visitors = visitors;
    }

    @Override
    public void printVisitors() {
        System.out.println(visitors);
    }

    public static void main(String[] args) {
        SeasonWithVisitors summer = SeasonWithVisitors.SUMMER;
        SeasonWithVisitors winter = SeasonWithVisitors.SUMMER;

    }
}

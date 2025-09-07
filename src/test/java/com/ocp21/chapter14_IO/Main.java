package com.ocp21.chapter14_IO;

import java.nio.file.FileSystems;

public class Main {
    public static void main(String[] args) {
        System.out.print(FileSystems.getDefault().getSeparator());

    }
}

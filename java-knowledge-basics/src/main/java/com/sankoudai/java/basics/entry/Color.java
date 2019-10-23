package com.sankoudai.java.basics.entry;

/**
 * @author xuliufeng
 */
public enum Color {
    Red("red"), Green("green");
    private String color;

    private Color(String color) {
        this.color = color;
    }
}

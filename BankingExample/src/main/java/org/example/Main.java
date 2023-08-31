package org.example;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("DBDetails", Locale.getDefault());
        System.out.println(bundle.getString("url"));
    }
}
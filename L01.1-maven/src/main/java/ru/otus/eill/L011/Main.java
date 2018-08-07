package ru.otus.eill.L011;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strlist = new ArrayList<String>();
        System.out.println("reads 5 lines and concatenates into one new line");
        for (int i=0; i<5; i++) {
            strlist.add(sc.next());
        }
        Joiner joiner = Joiner.on(" ").skipNulls();
        System.out.println(joiner.join(strlist));
    }
}

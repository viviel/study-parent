package pers.vv.study.jdk.syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Overload {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        t(c);
        t(new ArrayList<>());
    }

    public static void t(Collection<String> arg) {
        if (arg instanceof List) {
            System.out.println("array");
        }
        System.out.println("collection");
    }

    public static void t(List<String> arg) {
        System.out.println("list");
    }

}

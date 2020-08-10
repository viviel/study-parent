package pers.vv.study.jdk.syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Overload {

    public static void main(String[] args) {
        t(new ArrayList<>());
    }

    public static void t(Collection<String> arg) {
        System.out.println("collection");
    }

    public static void t(List<String> arg) {
        System.out.println("list");
    }

}

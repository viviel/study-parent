package pers.vv.study.jdk.classloader;

public class MClassLoader {

    void systemClassLoader() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println("MClassLoader.systemClassLoader");
        System.out.println("cl = " + cl);
    }

    void commonClassLoader() {
        ClassLoader cl = MClassLoader.class.getClassLoader();
        System.out.println("MClassLoader.commonClassLoader");
        System.out.println("cl = " + cl);
    }

    void extClassLoader() {
        ClassLoader cl = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("MClassLoader.extClassLoader");
        System.out.println("cl = " + cl);
    }

    void boostrapClassLoader() {
        ClassLoader cl = ClassLoader.getSystemClassLoader().getParent().getParent();
        System.out.println("MClassLoader.boostrapClassLoader");
        System.out.println("cl = " + cl);
    }

    void contextClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println("MClassLoader.contextClassLoader");
        System.out.println("cl = " + cl);
    }

    void load() {
        try {
            Class<?> c = ClassLoader.getSystemClassLoader().loadClass("pers.vv.study.jdk.classloader.T");
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package pers.vv.study.jvm.classloader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileSystemClassLoaderTest {

    private FileSystemClassLoader o;

    @BeforeEach
    void setUp() {
        String path = "/Users/vv/Develop/Code/github/study-parent/java/java-jvm/temp";
        o = new FileSystemClassLoader(path);
    }

    @Test
    void test1() throws ClassNotFoundException {
        Class<?> userClass = o.loadClass("pers.vv.study.java.jvm.classloader.User");
        System.out.println(userClass.getClassLoader());
    }
}

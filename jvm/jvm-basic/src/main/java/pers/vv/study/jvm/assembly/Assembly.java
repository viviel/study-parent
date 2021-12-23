package pers.vv.study.jvm.assembly;

/**
 * prepare: hsdis, jitwatch
 * <p>
 * vm options:
 * <p>
 * -XX:+UnlockDiagnosticVMOptions
 * <p>
 * -XX:+PrintAssembly
 * <p>
 * -Xcomp
 * <p>
 * -XX:CompileCommand=dontinline,*Assembly.m1
 * <p>
 * -XX:CompileCommand=compileonly,*Assembly.m1
 * <p>
 * -XX:+LogCompilation
 * <p>
 * -XX:LogFile=/Users/vv/Desktop/live.log
 */
public class Assembly {

    private volatile int i = 1;

    public void m1() {
        i = 1;
    }

    public static void main(String[] args) {
        Assembly a = new Assembly();
        a.m1();
    }
}

package pers.vv.study.jdk.syntax;

/**
 * final
 * <p>
 * static
 */
public class Keyword {

    /**
     * 不可继承
     */
    final static class Final {

        // 不可变
        final int x = 1;

        /**
         * 子类不可覆盖
         */
        final void method1() {
        }
    }

    /**
     * 静态内部类
     * 非静态内部类依赖于外部类的实例，也就是说需要先创建外部类实例，才能用这个实例去创建非静态内部类。而静态内部类不需要。
     * <p>
     * 初始化顺序：
     * 静态变量和静态语句块优先于实例变量和普通语句块，静态变量和静态语句块的初始化顺序取决于它们在代码中的顺序。
     * 父类（静态变量、静态语句块）
     * 子类（静态变量、静态语句块）
     * 父类（实例变量、普通语句块）
     * 父类（构造函数）
     * 子类（实例变量、普通语句块）
     * 子类（构造函数
     */
    static class Static {

        // 静态变量：又称为类变量
        private static int y;

        // 静态语句块在类初始化时运行一次。
        static {
            System.out.println("123");
        }

        // 静态方法：又称为类方法
        public static void method(String[] args) {
        }
    }
}

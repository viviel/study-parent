package pers.vv.study.netty;

import io.netty.util.Recycler;
import lombok.Data;

import java.util.Objects;

public class ObjectPool {

    private final Recycler<User> userRecycler = new Recycler<User>() {
        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

    public static void main(String[] args) {
        ObjectPool o = new ObjectPool();
        o.test();
    }

    @Data
    private static final class User {
        private String name;
        private Recycler.Handle<User> handle;

        public User(Recycler.Handle<User> handle) {
            this.handle = handle;
        }

        public void recycle() {
            handle.recycle(this);
        }
    }

    private void test() {
        // 1、从回收池获取对象
        User user1 = userRecycler.get();
        // 2、设置对象并使用
        user1.setName("hello,java");
        System.out.println(user1);
        // 3、对象恢复出厂设置
        user1.setName(null);
        // 4、回收对象到对象池
        user1.recycle();
        // 5、从回收池获取对象
        User user2 = userRecycler.get();
        System.out.println(Objects.equals(user1, user2));
    }

}

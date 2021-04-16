package inner;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daixulin
 * @version : v1.0
 * @project :LeetCode
 * @create 2021-04-12 下午2:19 周一
 */
public class Outer {

    @Getter
    @Setter
    private String name;

    public void dis() {
        System.out.println(name);

        class Inner2 {
            public void dis() {
                System.out.println("method inner class");
            }
        }

        Inner2 inner2 = new Inner2();
        inner2.dis();
    }

    public class Inner {

        @Getter
        @Setter
        private String name;

        public void dis() {
            System.out.println(name);
        }
    }

    public static class StaticInnerClass {
        private String innerName;
        public StaticInnerClass() {
            innerName = "static inner class";
        }

        public void dis() {
            System.out.println(innerName);
        }
    }

    class MyImplement1 implements MyInterface {

        @Override
        public void test() {
            System.out.println("myImp2");
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.setName("outer");
        outer.dis();

        Outer.Inner inner = outer.new Inner();
        inner.setName("inner");
        inner.dis();

        Outer.StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.dis();

        MyInterface myInterface = new MyImplement();
        myInterface.test();

        MyInterface myInterface1 = () -> {
            System.out.println("test");
            System.out.println("go");
        };
        myInterface1.test();

        MyInterface myInterface2 = outer.new MyImplement1();
        myInterface2.test();

        MyImplement1 myImplement1 = outer.new MyImplement1();
        myImplement1.test();
    }
}

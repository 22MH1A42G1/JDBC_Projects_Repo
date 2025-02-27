abstract class Parent {
    abstract void m1();//abstract method
    abstract void m2();//abstract method
    void m3() {//concrete
        System.out.println("Hello there");
    }
}
class Child1 extends Parent{
    void m1(){
        System.out.println("This is method 1");
    }
    void m2(){
        System.out.println("This is method 2");
    }
}
class Child2 extends Parent{
    void m1(){
        System.out.println("m1");
    }
    void m2(){
        System.out.println("m2");
    }
}
public class interfaceEx2 {
    public static void main(String[] args) {
        Child1 c1 = new Child1();
        c1.m1();
        c1.m2();
        c1.m3();
        Child2 c2 = new Child2();
        c2.m1();
        c2.m2();
        c2.m3();
    }
}

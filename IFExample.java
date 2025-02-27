interface MyInterFace{
    void m1();
    void m2();
}
class A implements MyInterFace{
    public void m1() {
        System.out.println("This is M1");
    }
    public void m2() {
        System.out.println("This is M2");
    }
}
public class IFExample {
    public static void main(String[] args) {
        A obj = new A();
        obj.m1();
        obj.m2();
    }
}

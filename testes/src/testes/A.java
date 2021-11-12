package testes;

class B {
    int x() { return y();}
    int y() { return 3; }
}
class C extends B {
    C() {
        super();
        z(x());
    }
    void z(int i) {
        System.out.println(i);
    }
    int y() { return 2; }
}
class A {
    public static void main(String[] args) {
        new C();
    }
}
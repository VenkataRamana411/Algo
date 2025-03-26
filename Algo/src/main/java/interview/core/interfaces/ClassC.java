package interview.core.interfaces;

public class ClassC implements InterfaceA,InterfaceB {

    public static void main(String[] args) {
        ClassC c = new ClassC();
        System.out.println(c.execute());
    }

    /**
     * Prompting to override method t compile time itself as both default methods have same name
    * */
    @Override
    public String execute() {
        return InterfaceA.super.execute();
    }
}

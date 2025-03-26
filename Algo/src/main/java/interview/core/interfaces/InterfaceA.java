package interview.core.interfaces;

public interface InterfaceA {
    default String execute(){
        System.out.println("Executed from A");
        return "A";
    }
}

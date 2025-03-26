package interview.core.interfaces;

public interface InterfaceB {
    default String execute(){
        System.out.println("Executed from B");
        return "B";
    }
}

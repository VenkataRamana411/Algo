package lld.tutor.splitwise;

public class ExpenseManager {
    public static void main(String[] args) {
        User u1 = new User("u1","Ram","abc","123");
        User u2 = new User("u2","Lakshman","asd","456");
        User u3 = new User("u3","Seetha","ghg","789");
        User u4 = new User("u4","Hanuman","gfd","142");
        SplitWiseController splitWiseController = new SplitWiseController();
        splitWiseController.recordExpense(1000,u1.getUserId(),4,"u1 u2 u3 u4",ExpenseType.EQUAL,0);
        splitWiseController.show();
        splitWiseController.recordExpense(2000,u1.getUserId(),4,"u1 u2 u3 u4",ExpenseType.EQUAL,0);
        splitWiseController.show();
    }
}

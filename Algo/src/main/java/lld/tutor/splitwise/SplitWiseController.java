package lld.tutor.splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitWiseController {

    HashMap<String,HashMap<String,Double>> recorder;

    public SplitWiseController() {
        this.recorder = new HashMap<>();
    }

    public void recordExpense(double expenseAmount, String spendor, int totalUsers, String userIds, ExpenseType expenseType, int splitAmount){
        if (expenseType.equals(ExpenseType.EQUAL)){
            double individualShare = expenseAmount / totalUsers;
            String[] splitUsers = userIds.split(" ");
            for(String user : splitUsers){
                if (!user.equals(spendor)){
                    if (recorder.get(user) == null){
                        HashMap<String,Double> splitMap = new HashMap<>();
                        splitMap.put(spendor,individualShare);
                        recorder.put(user,splitMap);
                    }else {
                        HashMap<String, Double> splitMap = recorder.get(user);
                        splitMap.merge(spendor, individualShare, Double::sum);
                        recorder.put(user,splitMap);
                    }
                }
            }
        }
    }

    public void show(){
        for (Map.Entry entry : recorder.entrySet()){
            HashMap<String, Double> entryValue = (HashMap<String, Double>) entry.getValue();
            for (Map.Entry entry1 : entryValue.entrySet()){
                System.out.println(entry.getKey()+" owes "+entry1.getKey()+" : "+entry1.getValue());
            }
        }
    }

}

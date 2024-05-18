package Assignement;

public class Assign2 {
    public static void main(String[] args) {
        System.out.println(solution("00:00","23:59"));
        System.out.println(solution("20:00","06:00"));
        System.out.println(solution("12:01","12:24"));
    }
    public static int solution(String A, String B) {
        String[] startTime = A.split(":");
        String[] endTime = B.split(":");
        int startHour = Integer.parseInt(startTime[0]);
        int startMinute = Integer.parseInt(startTime[1]);
        int endHour = Integer.parseInt(endTime[0]);
        int endMinute = Integer.parseInt(endTime[1]);

        int totalMinutes = (endHour - startHour) * 60 + (endMinute - startMinute);
        if (totalMinutes < 0) {
            totalMinutes += 24 * 60;
        }

        int fullRounds = totalMinutes / 15;
        int remainingMinutes = totalMinutes % 15;

        if (remainingMinutes > 0) {
            fullRounds--;
        }
        return fullRounds;
    }
//    public static int solution2(String A, String B) {
//        String[] startingTime = A.split(":");
//        String[] endingTime = B.split(":");
//
//        int startHour = Integer.parseInt(startingTime[0]);
//        int startMinute = Integer.parseInt(startingTime[1]);
//        int endHour = Integer.parseInt(endingTime[0]);
//        int endMinute = Integer.parseInt(endingTime[1]);
//
////        int start = Integer.parseInt(A.replace(":",""));
////        int end = Integer.parseInt(B.replace(":",""));
////        if (start > end){
////            int temp = end;
////            end = start;
////            start = temp;
////        }
////        int mod1 = start % 15;
////        start += 15 - mod1;
////        int mod2 = end % 15;
////        end -= mod2;
////        return (end-start)/15;
//    }
    /*public int solution(String A, String B) {
        // Parse the input strings to extract hours and minutes
        String[] startingTime = A.split(":");
        String[] endingTime = B.split(":");
        int startHour = Integer.parseInt(startingTime[0]);
        int startMinute = Integer.parseInt(startingTime[1]);
        int endHour = Integer.parseInt(endingTime[0]);
        int endMinute = Integer.parseInt(endingTime[1]);

        // Calculate the total number of minutes from start to end
        int totalMinutes = (endHour - startHour) * 60 + (endMinute - startMinute);

        // If B is earlier than A, John has played overnight
        if (totalMinutes < 0) {
            totalMinutes += 24 * 60; // Add 24 hours to the total minutes
        }

        // Calculate the maximum number of full rounds that can be played
        int fullRounds = totalMinutes / 15;
        return fullRounds;
    }*/
}

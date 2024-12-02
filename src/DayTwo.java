import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DayTwo {
    public static ArrayList<ArrayList<Integer>> reports;
    private static ArrayList<ArrayList<Integer>> maybeUnsafe = new ArrayList<>();
    public static void main (String args[]){
        reports = new ArrayList<>();
        //DayOne dayOne = new DayOne();
        try {
            File input = new File("assets/reports.txt");
            Scanner r = new Scanner(input);
            while(r.hasNextLine()){
                StringTokenizer tok = new StringTokenizer(r.nextLine());
                ArrayList<Integer> report = new ArrayList<>();
                while(tok.hasMoreTokens()){
                    report.add(Integer.valueOf(tok.nextToken()));
                }
                reports.add(report);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int safe = 1000;
        for(ArrayList<Integer> report : reports) {
            safe += isSafe(report, true);
        }
        System.out.println(safe);

        int safe2 = safe;
        for(ArrayList<Integer> report : maybeUnsafe){
            for(int i = 0; i < report.size(); i++){
                ArrayList<Integer> temp = new ArrayList<>(report);
                temp.remove(i);
                if(isSafe(temp, false) == 0){
                    safe2++;
                    break;
                }
            }

        }


        System.out.println(safe2);
    }

    private static boolean isSafelyIncreasing(int current, int next){
        return !(next - current < 1 || next - current > 3);
    }

    private static boolean isSafelyDecreasing(int current, int next){
        return !(current - next < 1 || current - next > 3);
    }


    private static int isSafe(ArrayList<Integer> report, boolean shouldAdd){

        boolean increasing = true;
        if(report.get(1) - report.get(0) <= 0) {
            increasing = false;
        }
        for(int i = 0; i < report.size() - 1; i++){
            if(increasing){
                if(!isSafelyIncreasing(report.get(i), report.get(i+1))){
                    if(shouldAdd) maybeUnsafe.add(report);
                    return -1;
                }
            } else {
                if(!isSafelyDecreasing(report.get(i), report.get(i+1))){
                    if(shouldAdd) maybeUnsafe.add(report);
                    return -1;
                }
            }
        }

        //if(!shouldAdd) System.out.println(report);
        return 0;
    }

}

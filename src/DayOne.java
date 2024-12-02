import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DayOne {
    public ArrayList<Integer> list;
    public ArrayList<Integer> list2;
    public int result;
    public int result2;

    public DayOne() {
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        try {
            File input = new File("assets/aoc1.txt");
            Scanner r = new Scanner(input);
            while(r.hasNextLine()){
                StringTokenizer tok = new StringTokenizer(r.nextLine());
                list.add(Integer.valueOf(tok.nextToken()));
                list2.add(Integer.valueOf(tok.nextToken()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(list);
        Collections.sort(list2);

        result = 0;

        for(int i=0; i<list.size(); i++){
           result += Math.abs(list.get(i) - list2.get(i));
        }

        System.out.println(result);

        result2 = 0;

        for(int i=0; i<list.size(); i++){
            if(list2.contains(list.get(i))){
                result2 += list.get(i) * Collections.frequency(list2, list.get(i));
            }
        }

        System.out.println(result2);

    }
}
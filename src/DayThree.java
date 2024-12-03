import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DayThree {
    public static void main(String[] args){
        int result = 0;
        try {
            File input = new File("assets/memory.txt");
            Scanner r = new Scanner(input);
            boolean should_calc = true;
            while(r.hasNextLine()){
                String line = r.nextLine();
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) == 'd'){
                        // Remove these 2 lines to get the answer to star 1
                        if("don't()".equals(line.substring(i, i+7))) should_calc = false;
                        if("do()".equals(line.substring(i, i+4))) should_calc = true;
                    }
                    if (should_calc && line.charAt(i) == 'm'){
                       if("mul(".equals(line.substring(i, i+4))){
                           StringTokenizer tok = new StringTokenizer(line.substring(i+4, i+11), ",)");
                           try {
                               String fac1str = tok.nextToken();
                               if(!tok.hasMoreTokens()) continue;
                               String fac2str = tok.nextToken();
                               int fac1 = Integer.parseInt(fac1str);
                               int fac2 = Integer.parseInt(fac2str);
                               int end_parenthesis = i + 4 + fac1str.length() + 1 + fac2str.length();
                               if(line.charAt(end_parenthesis) == ')')
                                   result += fac1*fac2;
                           } catch (NumberFormatException ignored) {

                           }
                       }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);

    }
}

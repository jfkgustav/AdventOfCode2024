import java.util.ArrayList;

public class DayFour {

    public static void main(String[] args){

        ArrayList<String> input = FileParser.parse("assets/xmas.txt");
        int strlen = input.get(0).length();

        int result = 0;

        for(int UD = 0; UD < input.size(); UD++){
           for(int LR = 0; LR < strlen; LR++){
                   if(input.get(UD).charAt(LR) == 'X'){
                       for(int i = UD - 1; i <= UD + 1; i++){
                           for(int j = LR - 1; j <= LR + 1; j++){
                               if(i == UD && LR == j){
                                   continue;
                               }
                               try {
                                   if(input.get(i).charAt(j) == 'M'){
                                       int A_X = LR - 2 * (LR - j);
                                       int A_Y = UD - 2 * (UD - i);
                                       if(input.get(A_Y).charAt(A_X) == 'A'){
                                           int S_X = LR - 3 * (LR-j);
                                           int S_Y = UD - 3 * (UD-i);
                                           if(input.get(S_Y).charAt(S_X) == 'S'){
                                               result++;
                                           }
                                       }
                                   }
                               } catch (IndexOutOfBoundsException ignored){}
                           }
                       }
                   }

           }
        }

        System.out.println(result);
        int result2 = 0;

        // Searching for MAS crosses
        for(int UD = 0; UD < input.size(); UD++){
            for(int LR = 0; LR < strlen; LR++){
                if(input.get(UD).charAt(LR) == 'A'){
                    try {
                        char leftTopCorner = input.get(UD - 1).charAt(LR - 1);
                        char rightTopCorner = input.get(UD - 1).charAt(LR + 1);
                        char leftBotCorner = input.get(UD + 1).charAt(LR - 1);
                        char rightBotCorner = input.get(UD + 1).charAt(LR + 1);
                        if (leftTopCorner == 'M' && rightBotCorner == 'S' || leftTopCorner == 'S' && rightBotCorner == 'M') {
                            if (rightTopCorner == 'M' && leftBotCorner == 'S') result2++;
                            if (rightTopCorner == 'S' && leftBotCorner == 'M') result2++;
                        }
                    } catch (IndexOutOfBoundsException ignored){}
                }

            }
        }

        System.out.println(result2);


    }

}

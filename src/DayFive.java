import java.util.ArrayList;
import java.util.StringTokenizer;

public class DayFive {
    public static void main(String[] args) {
        ArrayList<String> input = FileParser.parse("rules.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> instructions = new ArrayList<>();
        ArrayList<ArrayList<Integer>> invalidInstructions = new ArrayList<>();
        int result = 0;

        int numberOfLines = 0;
        while (!input.get(numberOfLines).isEmpty()) {
            rules.add(input.get(numberOfLines));
            numberOfLines++;
        }


        while (++numberOfLines < input.size()) {
            instructions.add(input.get(numberOfLines));
        }

        for (String instruction : instructions) {
            boolean validInstruction = true;
            StringTokenizer tok = new StringTokenizer(instruction, ",");
            ArrayList<Integer> pages = new ArrayList<>();
            while (tok.hasMoreTokens()) {
                pages.add(Integer.parseInt(tok.nextToken()));
            }
            for (int j = 0; j < pages.size() && validInstruction; j++) {
                int page = pages.get(j);
                for (int k = j + 1; k < pages.size(); k++) {
                    if (!rules.contains(page + "|" + pages.get(k))) {
                        validInstruction = false;
                        invalidInstructions.add(pages);
                        break;
                    }

                }
            }

            if (validInstruction) {
                int middlePage = pages.size() / 2;
                result += pages.get(middlePage);
            }
        }

        System.out.println(result);

        // BUBBLE SORT!

        // sort invalidInstructions with bubble sort


        result = 0;
        for (ArrayList<Integer> pages : invalidInstructions) {
            for (int i = 0; i < pages.size() - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < pages.size() - i - 1; j++) {
                    if (!rules.contains(pages.get(j) + "|" + pages.get(j + 1))) {
                        int temp = pages.get(j);
                        pages.set(j, pages.get(j + 1));
                        pages.set(j + 1, temp);
                        swapped = true;
                    }

                }

                if (!swapped) break;

            }
            int middlePage = pages.size() / 2;
            result += pages.get(middlePage);
        }

        System.out.println(result);
    }
}
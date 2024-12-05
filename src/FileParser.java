import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

    public static ArrayList<String> parse(String filename){
        ArrayList<String> parsedFile = new ArrayList<>();
        try {
            File input = new File(filename);
            Scanner r = new Scanner(input);
            while(r.hasNextLine()){
                parsedFile.add(r.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return parsedFile;
    }

}

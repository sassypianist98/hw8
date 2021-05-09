package hw8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<String> readIn(String fileName) {
        List<String> lines = new ArrayList<>();
        
        try {
            // add new key and empty list to the map
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String line;
            // get all sequences in the current file
            while ((line = r.readLine()) != null) {
                lines.add(line);
            }
            
            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return lines;
    }
    
    public static void main(String[] args) {
        Reader r = new Reader();
        List<String> lines = r.readIn("listings.csv");
        System.out.println(lines.get(lines.size() - 1));
    }
}

package src;

import java.util.ArrayList;
import java.io.BufferedReader; //creates a buffer in the memory
import java.io.FileReader; //connects the csv file and the code
import java.io.IOException; //verifys erros on the input and output

public class CSVReader {

    private String filePath;

    // The csvreader constructor saves the csv path in the filepath atributtor
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String[]> readCSV() {
        ArrayList<String[]> data = new ArrayList<>(); // dynamic list

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line; // variable that will store each line of csv file

            // this while just stops when the lines are null
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // split the lines of csv file in an array with four elements
                data.add(columns); // adds the array columns in the arraylist data
            }

            br.close(); //closes the buffer in the memory
        }

        catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return data;
    }

}
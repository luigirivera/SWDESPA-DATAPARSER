import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CSVDataParser extends DataParser{
    String readData(String source){
        FileReader fr = null;
        BufferedReader br = null;
        String data = "";

        try {
            fr = new FileReader(source);
            br = new BufferedReader(fr);

            while (br.ready()) {
                data = data + br.readLine();
                data = data + "\n";
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
    List<List<String>> processData(String data){
        List<List<String>> processed = new ArrayList<List<String>>();
        String[] rows = data.split("\n");

        for (String row : rows) {
            List<String> processedCells = new ArrayList<String>();
            String[] cells = row.split(",");
            for (String cell : cells) {
                processedCells.add(cell);
            }
            processed.add(processedCells);
        }

        return processed;
    }
}

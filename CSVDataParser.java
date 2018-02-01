import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class CSVDataParser extends DataParser{
    String readData(String source){
        FileReader fr;
        BufferedReader br;
        String data = "";

        try {
            fr = new FileReader(source);
            br = new BufferedReader(fr);

            while (br.ready())
                data = data + br.readLine();
                data = data + "\n";

            return data;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (br!=null)
                br.close();
            if (fr!=null)
                fr.close();
        }
    }
    List<List<String>> processData(String data){
        List<List<String>> processed = new ArrayList<List<String>>();
        

        return processed;
    }
}

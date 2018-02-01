import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

abstract public class DataParser{
    public void parseDataAndGenerateOutput(String[] sourceArgs, String dest)
    {
        String data;
        List<List<String>> processed;

        data = readData(sourceArgs);
        processed = processData(data);
        writeData(processed, dest);
    }
    abstract String readData(String[] sourceArgs);
    abstract List<List<String>> processData(String data);

    public void writeData(List<List<String>> processed, String dest)
    {
        FileWriter fw;
        BufferedWriter bw;
        try{
            fw = new FileWriter(dest);
            bw = new BufferedWriter(fw);

            for (List<String> row : processed){
                for (int ctr = 0 ; ctr < row.size()-1 ; ctr++) {
                    bw.write(row.get(ctr), 0, row.get(ctr).length());
                    bw.write(',');
                }
                String last = row.get(row.size()-1);
                bw.write(last, 0, last.length());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

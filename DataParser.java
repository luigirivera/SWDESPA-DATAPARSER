import java.util.List;

abstract public class DataParser{
    public void parseDataAndGenerateOutput(String source, String dest)
    {
        String data;
        List<List<String>> processed;

        data = readData(source);
        processed = processData(data);
        writeData(processed, dest);
    }
    abstract void readData(String source);
    abstract void processData(String data);

    public void writeData(List<List<String>> processed, String dest)
    {
        FileWriter fw;
        BufferedWriter bw;
        try{
            fw = new FileWriter(dest);
            bw = new BufferedWriter(fw);

            for (List<String> row : processed){
                for (String cell : row){
                    bw.write(cell, 0, cell.length);
                    bw.write(',');
                }
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println(e.message());
        }finally{
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        }
    }
}

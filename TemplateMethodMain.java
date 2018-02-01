public class TemplateMethodMain{
    public static void main(String[] args){
        /*
        CSVDataParser csvDataParser = new CSVDataParser();
        csvDataParser.parseDataAndGenerateOutput();
        System.out.println("**********************");
        DatabaseDataParser databaseDataParser = new DatabaseDataParser();
        databaseDataParser.parseDataAndGenerateOutput();
        */
        CSVDataParser csvDataParser = new CSVDataParser();
        csvDataParser.parseDataAndGenerateOutput(SamplePaths.SOURCE.toString(), SamplePaths.DEST.toString());
    }
}

//for debugging... remove this when done -L
enum SamplePaths{
    SOURCE, DEST;

    public String toString(){
        switch(this){
            case SOURCE: return "sample-csv.csv";
            case DEST: return "output-csv.csv";
            default: return "invalid";
        }
    }
}

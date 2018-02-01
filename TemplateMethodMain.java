/*
    LOPEZ, LUIS ENRICO D.
    RIVERA, LOUIE IV Y.
    SWDESPA S17
*/

public class TemplateMethodMain{
    public static void main(String[] args){
        String[] csvArgs = {SampleCSV.SOURCE.toString()};
        String[] dbArgs = {SampleDB.URL.toString(), SampleDB.USERNAME.toString(),
            SampleDB.PASSWORD.toString(), SampleDB.DATABASE.toString(),
            SampleDB.TABLE.toString()};
        CSVDataParser csvDataParser = new CSVDataParser();
        csvDataParser.parseDataAndGenerateOutput(csvArgs, SampleCSV.DEST.toString());
        DatabaseDataParser databaseDataParser = new DatabaseDataParser();
        databaseDataParser.parseDataAndGenerateOutput(dbArgs, SampleDB.DEST.toString());
    }
}

//for debug purposes
enum SampleCSV{
    SOURCE, DEST;

    public String toString(){
        switch(this){
            case SOURCE: return "sample-csv.csv";
            case DEST: return "output-csv.csv";
            default: return "invalid";
        }
    }
}

//for debug purposes
enum SampleDB{
    URL, USERNAME, PASSWORD, DATABASE, TABLE, DEST;

    public String toString(){
        switch(this){
            case URL: return "jdbc:mysql://127.0.0.1:3306";
            case USERNAME: return "root";
            case PASSWORD: return "";
            case DATABASE: return "my_db";
            case TABLE: return "USER";
            case DEST: return "output-db.csv";
            default: return "invalid";
        }
    }
}

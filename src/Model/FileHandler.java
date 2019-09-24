package Model;

import java.io.*;


public class FileHandler {

    private BufferedReader reader;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private String fileData[];

    private String fileName;

    public void fileHandler(){
        this.fileName = "/FormStorageDocument.txt";
    }

   public String[] readFile()  {

       String readData = "";
       int rowCount = 0;

       try {
                InputStream fileURL = this.getClass().getResourceAsStream(this.fileName);

                this.reader = new BufferedReader(new InputStreamReader(fileURL, "UTF-8"));

                // loop on the file to read every row

                while((readData = reader.readLine()) != null){

                    this.fileData[rowCount] = readData;

                    rowCount++;
                }

                return this.fileData;

                // exception if the file does not exist

        }catch(IOException ex){
            return null;
        }
    }

    public Boolean writeToFile(String SaveData){
       return true;
    }

}

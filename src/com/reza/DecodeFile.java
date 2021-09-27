package com.reza;

import java.io.*;

public class DecodeFile {
    private String outputFileName = null;
    private String dataString = "";
    private String lineSeparator = "%n";

    public void decode(File file) {
        try{
            //check if the provided file is a valid file or not
            if (!file.isFile()) {
                System.out.println("Provided file is not a valid file!!!");
                return;
            }
            //create reader
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //read the file
            String line = null;
            while ((line = reader.readLine()) != null) dataString += line;
            String[] dataArray = dataString.split(lineSeparator);

            for (String token : dataArray) System.out.println(token);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

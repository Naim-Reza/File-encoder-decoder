package com.reza;

import java.io.*;
import java.util.Base64;

public class DecodeFile {
    private String outputFileName = null;
    private String dataString = "";
    private String lineSeparator = " ";

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
            //close reader
            reader.close();

            //set output file name
            outputFileName = dataArray[0];
            //create new File instance with outputfilename
            File outputFile = new File(outputFileName);
            //decode string
            byte[] fileData = Base64.getDecoder().decode(dataArray[1]);

            //create writer
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile));
            //write to binary file
            writer.write(fileData);
            //close writer stream
            writer.close();

            //prompt success message
            System.out.println(file.getName() + " Decoded successfully.");
            System.out.println("Output filename: " + outputFileName);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

package com.reza;

import java.io.*;
import java.util.Base64;

public class EncodeFile {
    private String filename = null;
    private String outputFileName = null;
    private String encodedString = "";

    public void encode(File file) {
        try{
            //check if the provided filename is a valid file
            if(!file.isFile()) {System.err.println("Provided filename is not a file."); return;}
            //get the filename
            filename = file.getName();
            String[] fileNameArray = filename.split("\\.");
            outputFileName = fileNameArray[0] + "_out.txt"; //set the name of output file

            //create new instance of output file
            File outputFile = new File(outputFileName);

            //create reader
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            byte[] data = new byte[(int) file.length()];
            //read bytes and store into data array
            reader.read(data);
            //encode the file into string
            encodedString = Base64.getEncoder().encodeToString(data);
            //close reader
            reader.close();

            //create writer
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            //output string
            String outputString = filename + System.lineSeparator() + encodedString;
            //write the output to the file
            writer.write(outputString);
            //close writer
            writer.close();

            //prompt success message
            System.out.println(filename + " Encoded Successfully!!");
            System.out.println("Output Filename: " + outputFileName);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

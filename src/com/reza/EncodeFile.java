package com.reza;

import java.io.*;
import java.util.Base64;

public class EncodeFile {
    private String outputFileName = null;
    private String encodedString = "";
    private String lineSeparator = " ";
    private String charSeparator = ";";

    public void encode(File file, String destination, String encodingMethod) {
        try{
            //check if the provided filename is a valid file
            if(!file.isFile()) {System.err.println("Provided filename is not a file."); return;}
            //set outputFileName
            outputFileName = destination + ".txt"; //set the name of output file

            //create new instance of output file
            File outputFile = new File(outputFileName);

            //create reader
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            byte[] data = new byte[(int) file.length()];
            //read bytes and store into data array
            reader.read(data);
            //close reader
            reader.close();

            //encode the file with chosen method
            switch (encodingMethod){
                case "base64":
                    useBase64Encoding(data);
                    break;
                case "character":
                    useCharacterEncoding(data);
                    break;
                default:
                    System.out.println(encodingMethod + " encoding method is not available.");
                    return;
            }

            //create writer
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            //output string
            String outputString = file.getName() + lineSeparator + encodingMethod + lineSeparator + encodedString;
            //write the output to the file
            writer.write(outputString);
            //close writer
            writer.close();

            //prompt success message
            System.out.println(file.getName() + " Encoded Successfully!!");
            System.out.println("Output Filename: " + outputFileName);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void useBase64Encoding(byte[] data){
        encodedString = Base64.getEncoder().encodeToString(data);
    }

    private void useCharacterEncoding(byte[] data){
        //reset encodedString instance variable
        encodedString = "";
        //encode data bytes to string
        for (byte b : data) encodedString += (Byte.toString(b) + charSeparator);
    }
}

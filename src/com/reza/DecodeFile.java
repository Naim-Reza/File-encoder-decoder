package com.reza;

import java.io.*;
import java.util.Base64;

public class DecodeFile {
    private String outputFileName = null;
    private String dataString = "";
    private String lineSeparator = " ";
    private String charSeparator = ";";
    private String decodingMethod = null;
    private byte[] fileData;

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
            //set decoding method
            decodingMethod = dataArray[1];
            //create new File instance with outputfilename
            File outputFile = new File(outputFileName);

            //decode string
            switch (decodingMethod){
                case "base64":
                    useBase64Decoding(dataArray[2]);
                    break;
                case "character":
                    useCharacterDecoding(dataArray[2]);
                    break;
                default:
                    System.out.println(decodingMethod + " decoding method is not available.");
                    return;
            }

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

    private void useBase64Decoding(String data){
        fileData = Base64.getDecoder().decode(data);
    }

    private void useCharacterDecoding(String data){
        String[] charArray = data.split(charSeparator);
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) byteArray[i] = Byte.parseByte(charArray[i]);

        fileData = byteArray;
    }
}

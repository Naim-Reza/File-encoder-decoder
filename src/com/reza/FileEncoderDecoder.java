package com.reza;

import java.io.File;

public class FileEncoderDecoder {

    public static void main(String[] args) {
        //create instance of EncodeFile and DecodeFile class
        EncodeFile encoder = new EncodeFile();
        DecodeFile decoder = new DecodeFile();
        try{
            //get input option and filename
            String option = args[0];
            File file = new File(args[1]);


            //execute corresponding actions
            switch (option){
                case "encode":
                    String outputFileName = args[2];
                    String encodingMethod = args[3];
                    encoder.encode(file, outputFileName, encodingMethod);
                    break;
                case "decode":
                    decoder.decode(file);
                    break;
                default:
                    System.out.println("Invalid option!! Try again.");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}

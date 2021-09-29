package com.reza;

import java.io.File;

public class FileED {

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
            displayHelp();
        }
    }

    private static void displayHelp(){
        System.out.println();
        System.out.println("To encode: java FileED [option] <source-file> <destination> [encoder-method]");
        System.out.println("To encode: java FileED [option] <encoded-file>");
        System.out.println("Available Encoder: base64, character");
        System.out.println("option:");
        System.out.println("\tencode:\t\t To encode a file");
        System.out.println("\tdecode:\t\t To decode a file");
        System.out.println("encoder-method:");
        System.out.println("\tbase64:\t\t To use base64 encoding.");
        System.out.println("\tcharacter:\t\t To use character encoding.");
        System.out.println();
    }
}

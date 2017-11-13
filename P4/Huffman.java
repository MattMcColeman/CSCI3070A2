/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;
import java.io.*;

import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths;


public class Huffman {

	public static String fileToString(String file){
		String fileString = "";
		try{
    		fileString = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
			//System.out.println("Contents (Java 7 with character encoding ) : " + fileString);
    	} catch(IOException E){
    		System.out.println(E);
    	}
    	return fileString;
	}

    public static void main(String[] args) {

    	String fileString = fileToString("manifest.mf");

    	System.out.println(fileString.substring(0, 6));
    	System.out.println("Hello");
    }

}
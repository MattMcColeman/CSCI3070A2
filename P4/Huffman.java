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

	public static int characterValue(String doc, int place){
		String character = doc.substring(place, place+1);
		char c = doc.charAt(0);
		int ascii = (int) c;
		return ascii;
	}

    public static void main(String[] args) {

    	String fileString = fileToString("manifest.mf");

    	int c = characterValue(fileString, 0);
    	System.out.println(c);

    	System.out.println(fileString.substring(0, 6));
    	System.out.println("Hello");
    }

}
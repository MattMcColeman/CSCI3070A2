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

class MyNode {
    private String letter;
    private int freq;

    MyNode(String letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }

    //Getter and Setter as well as constructor(s) as needed
    public String toString() {
        return "(" + letter + ", " + freq + ")";
    }

    public String getLetter(){
    	return this.letter;
    }

	public int getFreq(){
		return this.freq;
	}
}


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
		char c = doc.charAt(place);
		int ascii = (int) c;
		return ascii;
	}

	public static void frequencyTable(String doc){
		for(int i = 0; i<doc.length(); i++){
			int c = characterValue(doc, i);
			ASCII[c]+=1;
		}
	}

	public static void initializeHeap(int[] ASCII){
		for(int i = 0; i < ASCII.length; i++){
			if(ASCII[i] > 0){
				String abc = String.valueOf((char)i);
				MyNode X = new MyNode(abc, ASCII[i]);
				obj.add(X);
			}
		}
	}

	public static void createParent(MyNode A, MyNode B){
		MyNode X = new MyNode(A.getLetter()+B.getLetter(), A.getFreq()+B.getFreq());
		obj.add(X);
	}

	public static MyNode extractMin(ArrayList<MyNode> Arr){
		MyNode minNode = Arr.get(0); //temp node to initialize min
		MyNode temp;
		int min = minNode.getFreq(); //first min freq value
		int place = 0;
		for(int i = 0; i < Arr.size(); i++){
			temp = Arr.get(i);
			if(temp.getFreq() < min){
				min = temp.getFreq();
				place = i;
			}
		}
		minNode = Arr.get(place);
		obj.remove(Arr.get(place));
		return minNode;
	}

	public static void buildHeap(ArrayList<MyNode> Arr){
		for(int i = (Arr.size()/2)-1; i >= 0; i--){

		}
	}

	public static void maxHeapify(ArrayList<MyNode> Arr, int x){

	}

	public static void heapInsert(ArrayList<MyNode> Arr, MyNode node){
		Heap.add(node);
		MyNode X = Arr.get(0);
	}

	public static void printArray(int[] Arr){
		for(int i = 0; i < Arr.length; i++){
			System.out.print(Arr[i]);
		}
		System.out.println();
	}

	static int[] ASCII = new int[128];
	static ArrayList<MyNode> obj = new ArrayList<MyNode>();
	static ArrayList<MyNode> Heap = new ArrayList<MyNode>();

    public static void main(String[] args) {

    	String fileString = fileToString("manifest.mf");

    	frequencyTable(fileString);
    	printArray(ASCII);
    	initializeHeap(ASCII);
    	System.out.println(obj);
    	createParent(obj.get(0), obj.get(1));
    	System.out.println(obj);
    	System.out.println(extractMin(obj));
    	System.out.println(obj);
    	System.out.println(fileString.substring(0, 6));
    	System.out.println("Hello");
    }

}
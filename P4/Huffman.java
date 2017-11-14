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

	//scans through string to find number of occurences for each character
	public static void frequencyTable(String doc){
		for(int i = 0; i<doc.length(); i++){
			int c = characterValue(doc, i);
			ASCII[c]+=1;
		}
	}

	//copies values from frequency table to array list eliminating any charactes with a zero value
	public static void initializeHeap(int[] ASCII){
		for(int i = 0; i < ASCII.length; i++){
			if(ASCII[i] > 0){
				String abc = String.valueOf((char)i);
				MyNode X = new MyNode(abc, ASCII[i]);
				obj.add(X);
			}
		}
	}

	//takes two nodes and joins their values to create a new node while preserving the children
	public static MyNode createParent(MyNode A, MyNode B){
		MyNode X = new MyNode(A.getLetter()+B.getLetter(), A.getFreq()+B.getFreq());
		return X;
	}

	//finds the element with the lowest freq value and returns and pops it from the arraylist
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

	//orders arraylist into heap
	public static void buildHeap(ArrayList<MyNode> Arr){
		for(int i = (Arr.size()/2)-1; i >= 0; i--){
			//System.out.println(obj + "obj");
			maxHeapify(Arr, i);
		}
	}

	//places largest freq at top of heap
	public static void maxHeapify(ArrayList<MyNode> Arr, int x){
		int largest = x;
		int l = 2*x+1;
		int r = 2*x+2;
		if(l < Arr.size() && Arr.get(x).getFreq() > Arr.get(x).getFreq()){
			largest = l;
		}else{
			largest = x;
		}
		if(r<Arr.size() && Arr.get(r).getFreq() > Arr.get(largest).getFreq()){
			largest = r;
		}
		if(largest != x){
			// MyNode temp = Arr.get(largest);
			// Arr.get(largest) = Arr.get(x);
			// Arr.get(x) = temp;
			Collections.swap(Arr, 0, Arr.size()-1);
			maxHeapify(Arr, largest);
			//System.out.println(Heap + "Heap");
		}
	}

	//takes frequency table and converts it into a heap
	//iteratively takes the two smallest freq table values
	//then joins them to make a parent node
	//children are added to Heap
	//Parent is insertedback into freq table
	public static void Huff(){
		if(obj.size() > 1){
			MyNode L = extractMin(obj);
			MyNode R = extractMin(obj);
			MyNode P = createParent(L, R);
			obj.add(P); //adds parent back to original arraylist
			//place these 2 child nodes into heap
			Heap.add(L);
			Heap.add(R);
			//Heap.add(P);
			buildHeap(Heap);
		}else{
			MyNode last = extractMin(obj);
			Heap.add(last);
			buildHeap(Heap);
		}
	}

	public static void printArray(int[] Arr){
		for(int i = 0; i < Arr.length; i++){
			System.out.print(Arr[i]);
		}
		System.out.println();
	}
/*
	public static void printAsTree(ArrayList<MyNode> Arr){
		int Q = 0;

		for(int i = 0; i<Math.sqrt(Arr.size()-1); i++){
			for(int j = (int)Math.pow(2,i); j > 0; j--){
				if(Q>=Arr.size()-1){
					System.out.println();
					return;
				}
				System.out.print("|"+Arr.get(Q)+"|");
				Q++;
			}
			System.out.println();
		}
		System.out.println(Arr.get(Q));
	}
*/
	//traverse tree to leaf node printing O or 1 whether going Left or Right
	//print leaf node char value and prefix code
	public static void prefix(ArrayList<MyNode> Arr){

	}

	//replace characters in doc with prefix codes and calc size of doc in bits
	//this can then be compares to original doc size
	public static void lengthFile(){

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
    	while(obj.size()!=0){
    		System.out.println(obj+"obj");
    		System.out.println(Heap+"Heap");
    		Huff();
    	}
    	buildHeap(Heap);
       	System.out.println(obj);
    	System.out.println(Heap);
    	prefix(Heap);
    	lengthFile();
    	//printAsTree(Heap);
    }

}
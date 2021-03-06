/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;
import java.io.*;


public class Radix {

	public static int[] countsort(int[] Z, int D){
		for(int i = 0; i < Z.length; i++){
			//System.out.print(Z[i] + "|Z");
		}
		//System.out.println();

		int A[] = new int[Z.length];

		//copy sigle digit into an array to the guide to how to rearrange Z
		for(int i = 0; i < Z.length; i++){
			A[i] = (Z[i]/(int)((Math.pow(10, D))))%10; // returns current digit to be sorted
		}

		for(int i = 0; i < A.length; i++){
			//System.out.print(A[i]);
		}
		//System.out.println();

		//final array of whole digit nums sorted by current digit
		int G[] = new int[Z.length];
		//prints original array
		for(int i = 0; i < A.length; i++){
			//System.out.print(A[i]+"|");
		}
		//System.out.println();
		//find max element of array to determine auxilary array size
		int max = A[0];

		//finds largest value in the array
		for (int i = 1; i < A.length; i++) {
		    if (A[i] > max) {
		        max = A[i];
		    }
		}
		//creat array using max value to provide proper indexing size
		int arrX[] = new int[max+1]; // ascending array
		int arrY[] = new int[A.length]; //final array

		//counts numbers noticed into index to count times appeared
		for(int i = 0; i < A.length; i++){
			arrX[A[i]]=arrX[A[i]]+1;
		}
		//prints array with number of occurences at each index
		for(int i = 0; i < arrX.length; i++){
			//System.out.print(arrX[i]+"|");
		}
		//System.out.println();
		//adds the previous array slots value to current slot looping left to right
		for(int i = 1; i < arrX.length; i++){
			arrX[i]=arrX[i]+arrX[i-1];
		}
		//prints modified array to prepare for sorting the array
		for(int i = 0; i < arrX.length; i++){
			//System.out.print(arrX[i]+"|");
		}
		//System.out.println();
		//uses original array value to go to the index in the asceding array 
		//then adds index value to final array at the slot value index of final array
		for(int i = A.length-1; i >= 0; i--){
			arrY[arrX[A[i]]-1]=A[i];
			G[arrX[A[i]]-1]=Z[i]; //allot full nums into new spots
			arrX[A[i]]=arrX[A[i]]-1;
		}

		for(int i = 0; i < arrY.length; i++){
			//System.out.print(arrY[i]+"|-");
		}
		//System.out.println();

		System.out.println("The " + Math.pow(10, D) + "\'s Digit column sorts the array with counting sort to produce the following");

		for(int i = 0; i < G.length; i++){
			System.out.print(G[i]+"|");
		}
		System.out.println();

		return G;

	}

	public static int[] radSort(int[] A, int D){

		System.out.println("The input array is: ");
		//runs counting sort for each digit
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "|");
		}
		System.out.println();

		for (int i = 0; i<D; i++) {
			//A = countsort(A[i], i);
			A = countsort(A, i);
			//System.out.print(A[i]+"|");
		}
		//System.out.println();
		return A;
	}

    public static void main(String[] args) {
    	//int arrQ[] = {1, 4, 1, 2, 7, 5, 2};
    	int arrQ[] = {123456, 123456, 654321, 444444, 939393, 393939, 111113};
    	//int arrQ[] = {100000, 200000, 300000, 700000, 600000, 500000, 400000};
    	int Final[];
    	
    	//countsort(arrQ, 6);
    	Final = radSort(arrQ, 6);

    	System.out.println();
    	System.out.println("Radix Sort produces the following array: ");

    	for(int i = 0; i < Final.length; i++){
			System.out.print(Final[i]+"|");
		}
		System.out.println();
    }

}
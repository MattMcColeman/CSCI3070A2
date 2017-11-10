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
			System.out.print(Z[i] + "|Z");
		}
		System.out.println();

		int A[] = new int[Z.length];

		//copy sigle digit into an array to the guide to how to rearrange Z
		for(int i = 0; i < Z.length; i++){
			//System.out.println(getDigit(Z[i], D));
			//A[i] = getDigit(Z[i], D);
			A[i] = (Z[i]/(10^(D)))%10;
			
			System.out.print(A[i] + "|");
		}
		System.out.println();

		for(int i = 0; i < Z.length; i++){
			//System.out.println(getDigit(Z[i], D));
			//A[i] = getDigit(Z[i], D);
			
			System.out.print(Z[i]/(10^(D))%10 + "|");
		}
		System.out.println();

		//final array of whole digit nums sorted by current digit
		int G[] = new int[Z.length];
		//prints original array
		for(int i = 0; i < A.length; i++){
			//System.out.print(A[i]+"|");
		}
		System.out.println();
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
		System.out.println();
		//adds the previous array slots value to current slot looping left to right
		for(int i = 1; i < arrX.length; i++){
			arrX[i]=arrX[i]+arrX[i-1];
		}
		//prints modified array to prepare for sorting the array
		for(int i = 0; i < arrX.length; i++){
			//System.out.print(arrX[i]+"|");
		}
		System.out.println();
		//uses original array value to go to the index in the asceding array 
		//then adds index value to final array at the slot value index of final array
		for(int i = 0; i < A.length; i++){
			arrY[arrX[A[i]]-1]=A[i];
			G[arrX[A[i]]-1]=Z[i]; //allot full nums into new spots
			arrX[A[i]]=arrX[A[i]]-1;
		}

		for(int i = 0; i < arrY.length; i++){
			System.out.print(arrY[i]+"|-");
		}
		System.out.println();

		for(int i = 0; i < G.length; i++){
			System.out.print(G[i]+"|G");
		}
		System.out.println();

		return G;

	}

	public static int[] radSort(int[] A, int D){
		for (int i = 0; i<D; i++) {
			//A = countsort(A[i], i);
			A = countsort(A, i);
			//System.out.print(A[i]+"|");
		}
		System.out.println();
		return A;
	}

	/*
	public static int[] radSort(int[] A, int D){
		//find nuber of digits
		//int length = String.valueOf(A[0]).length();
		//System.out.println(length);

		int[] T = new int[A.length];

		for(int i = 0; i < A.length; i++){
			//System.out.print(A[i]+"|");
		}
		//System.out.println();

		D = D - 1;
		
		if(D>0){	
			T = countsort(A, D);
			radSort(T, D);
		}


		for(int i = 0; i < A.length; i++){
			//System.out.print(T[i]+"|");
		}
		//System.out.println();

		return T;
	}
*/
	public static int getDigit(int num, int digit){
		int working = num / (10^(digit-1));
		//System.out.println(working % 10);
		int H = working % 10;
		return H;
	}

    public static void main(String[] args) {
    	//int arrQ[] = {1, 4, 1, 2, 7, 5, 2};
    	int arrQ[] = {123456, 123456, 654321, 444444, 939393, 393939, 111113};
    	int Final[];
    	
    	//countsort(arrQ, 6);
    	Final = radSort(arrQ, 6);

    	for(int i = 0; i < Final.length; i++){
			System.out.print(Final[i]+"|");
		}
		System.out.println();

    	System.out.println("Hello");
    }

}
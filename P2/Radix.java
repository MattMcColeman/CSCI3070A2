/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;


public class Radix {

	public static void countsort(int[] A){
		int max = A[0];
		//prints original array
		for(int i = 0; i < A.length; i++){
			System.out.print(A[i]+"|");
		}
		System.out.println();
		//finds largest value in the array
		for (int i = 1; i < A.length; i++) {
		    if (A[i] > max) {
		        max =A[i];
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
			System.out.print(arrX[i]+"|");
		}
		System.out.println();
		//adds the previous array slots value to current slot looping left to right
		for(int i = 1; i < arrX.length; i++){
			arrX[i]=arrX[i]+arrX[i-1];
		}
		//prints modified array to prepare for sorting the array
		for(int i = 0; i < arrX.length; i++){
			System.out.print(arrX[i]+"|");
		}
		System.out.println();
		//uses original array value to go to the index in the asceding array 
		//then adds index value to final array at the slot value index of final array
		for(int i = 0; i < A.length; i++){
			arrY[arrX[A[i]]-1]=A[i];
			arrX[A[i]]=arrX[A[i]]-1;
		}

		for(int i = 0; i < arrY.length; i++){
			System.out.print(arrY[i]+"|");
		}
		System.out.println();

	}

	public static void radSort(int[] A){

		for(int i = 0; i < A.length; i++){
			
		}

	}

	public static int getDigit(int num, int digit){
		int working = num / (10^(digit-1));
		return working % 10;
	}

    public static void main(String[] args) {
    	int arrA[] = {1, 4, 1, 2, 7, 5, 2};
    	int arrQ[] = {123456, 234567, 102938, 576857, 999999, 000001, 444444};
    	
    	countsort(arrA);
    	radSort(arrQ);


    	System.out.println("Hello");
    }

}
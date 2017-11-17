/**
**Author: Matt McColeman
**SID: 100525235
**Date: 10/16/2017
**/
//import java.util.*;


import java.util.*;

class MyNode {
    private double intValue;
    private double intWeight;
    private String strName;
    private double fraction;

    MyNode(double intValue, double intWeight, String strName, double fraction) {
        this.intValue = intValue;
        this.intWeight = intWeight;
        this.strName = strName;
        this.fraction = fraction;
    }

    //Getter and Setter as well as constructor(s) as needed
    public String toString() {
        return "($" + intValue + ", " + intWeight + "Kg, " + strName + ", " + fraction + "%)";
    }

    public double getIntValue(){
    	return this.intValue;
    }

	public double getIntWeight(){
		return this.intWeight;
	}

	public String getName(){
		return this.strName;
	}
}


public class Knapsack {

    public static MyNode optimalObject(MyNode[] P){
        //comparison iteration to find max ratio element
    	double V = P[0].getIntValue();
    	double W = P[0].getIntWeight();
    	double E = V/W;
    	int Opt = 0;
    	//System.out.println(P[0]);
    	//System.out.println(E);
    	for(int i = 1; i < P.length; i++){
        	//System.out.println(P[i]);
        	V = P[i].getIntValue();
        	W = P[i].getIntWeight();
        	double F = V/W;
        	if(F>E){
        		Opt = i; //assigned if ratio is better
        	}
        	E = F;
        	//System.out.println(E);
        }

        //filling and printing knapsack
        knapSack[Opt] = Arr[Opt];
        System.out.println("Knapsack now Holds the following: ");
        for(int i = 0; i < knapSack.length; i++){
      		System.out.print(knapSack[i]);
       	}
       	System.out.println();

        //popping and returning element
        MyNode Y;
        Y = P[Opt];
        Arr[Opt] = new MyNode(1, 10101010, "Empty", 1); //set to large value to avoid being selected again
        return Y;
    }

    static MyNode[] Arr = new MyNode[4];
    static MyNode[] knapSack = new MyNode[4];

    public static void main(String[] args) {
        MyNode Jade = new MyNode(30, 8, "Jade", 1);
        MyNode Gold = new MyNode(20, 6, "Gold", 1);
        MyNode Diamond = new MyNode(40, 12, "Diamond", 1);
        MyNode Bronze = new MyNode(10, 5, "Bronze", 1);
        MyNode Empty = new MyNode(0, 0, "Empty", 1);
        //creates pot to pick from
        Arr[0] = Jade;
        Arr[1] = Gold;
        Arr[2] = Diamond;
        Arr[3] = Bronze;
        //creates empty knapsack to be filled
        knapSack[0] = Empty;
        knapSack[1] = Empty;
        knapSack[2] = Empty;
        knapSack[3] = Empty;

        //temp for calculating object weight
        MyNode temp = Empty;
        //bag can hold 20lbs
        int bagCapacity = 20;
        int weight = 0;
        int lastWeight = 0;
        int count = 0;

        //selects each opject with the best value to weight ratio
        while(weight < bagCapacity){
            System.out.println("pot now contains the following: ");
        	for(int i = 0; i < Arr.length; i++){
        		System.out.print(Arr[i]);
        	}
        	System.out.println();
        	temp = optimalObject(Arr); //pops and returns element with best value ratio
        	System.out.println(temp + "<--MAX");
        	lastWeight = weight; // stored for fraction calulation
        	weight += temp.getIntWeight(); //finds bag weight
        	//System.out.println(weight + "<--weight");
        	System.out.println((count+1) + " item(s) added to knapsack");
        	count++;
        }

        //splits the last object in order to fit fraction in knapsack
        double itemFrac = (bagCapacity - lastWeight) / temp.getIntWeight();
        double itemFracVal = itemFrac * temp.getIntValue();
        knapSack[count-1] = new MyNode(itemFracVal, temp.getIntWeight(), temp.getName(), itemFrac);

        //prints final knapsack array and calculates value in bag
        double finalValue = 0;
        System.out.println("Final Knapsack now Holds the following: ");
        for(int i = 0; i < count; i++){
            finalValue += knapSack[i].getIntValue();
      		System.out.print(knapSack[i]);
       	}
       	System.out.println();

        System.out.println("KnapSack is now worth $" + finalValue);

    }

}

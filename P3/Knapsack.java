/**
**Author: Matt McColeman
**SID: 100525235
**Date: 10/16/2017
**/
//import java.util.*;


import java.util.*;

class MyValuePair {
    private int intValue;
    private int intWeight;
    private String strName;

    MyValuePair(int intValue, int intWeight, String strName) {
        this.intValue = intValue;
        this.intWeight = intWeight;
        this.strName = strName;
    }

    //Getter and Setter as well as constructor(s) as needed
    public String toString() {
        return "(" + intValue + ", " + intWeight + ", " + strName + ")";
    }

    public int getIntValue(){
    	return this.intValue;
    }

	public int getIntWeight(){
		return this.intWeight;
	}

	public String getName(){
		return this.strName;
	}
}


public class Knapsack {

    static Map<String, MyValuePair> map = new HashMap<>();

    public static MyValuePair optimalObject(MyValuePair[] P){
    	double V = P[0].getIntValue();
    	double W = P[0].getIntWeight();
    	double E = V/W;
    	int Opt = 0;
    	System.out.println(P[0]);
    	System.out.println(E);
    	for(int i = 1; i < P.length; i++){
        	System.out.println(P[i]);
        	V = P[i].getIntValue();
        	W = P[i].getIntWeight();
        	double F = V/W;
        	if(F>E){
        		Opt = i;
        	}
        	E = F;
        	System.out.println(E);
        }

        knapSack[Opt] = Arr[Opt];
        System.out.print("Knapsack now Holds the following: ");
        for(int i = 0; i < knapSack.length; i++){
      		System.out.print(knapSack[i]);
       	}
       	System.out.println();

        MyValuePair Y;
        Y = P[Opt];
        Arr[Opt] = new MyValuePair(1, 1010, "Empty");
        return Y;
    }

    static MyValuePair[] Arr = new MyValuePair[4];
    static MyValuePair[] knapSack = new MyValuePair[4];

    public static void main(String[] args) {
        MyValuePair Jade = new MyValuePair(30, 8, "Jade");
        MyValuePair Gold = new MyValuePair(20, 6, "Gold");
        MyValuePair Diamond = new MyValuePair(40, 12, "Diamond");
        MyValuePair Bronze = new MyValuePair(10, 5, "Bronze");
        //map.put("Jade", Jade);
        //map.put("Gold", Gold);
        //map.put("Diamond", Diamond);
        //map.put("Bronze", Bronze);
        MyValuePair Phil = new MyValuePair(0, 0, "Empty");

        
        Arr[0] = Jade;
        Arr[1] = Gold;
        Arr[2] = Diamond;
        Arr[3] = Bronze;
        knapSack[0] =  Phil;
        knapSack[1] =  Phil;
        knapSack[2] =  Phil;
        knapSack[3] =  Phil;

        System.out.println(Jade.getIntWeight());

        System.out.println(map);

        //temp for calculating object weight
        MyValuePair temp;
        //bag can hold 20lbs
        int bagCapacity = 20;
        int weight = 0;
        int count = 0;

        while(weight < bagCapacity){
        	for(int i = 0; i < Arr.length; i++){
        		System.out.print(Arr[i]);
        	}
        	System.out.println();
        	temp = optimalObject(Arr);
        	System.out.println(temp + "<--MAX");
        	weight += temp.getIntWeight();
        	System.out.println(weight + "<--weight");
        	System.out.println(count + "<--count");
        	count++;
        }

        System.out.print("Final Knapsack now Holds the following: ");
        for(int i = 0; i < count; i++){
      		System.out.print(knapSack[i]);
       	}
       	System.out.println();


        for(int i = 0; i < Arr.length; i++){

        }
        /*
	    Iterator it = map.entrySet().iterator();
	    while (bag > 0) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println((Map.Entry)it.next());
	        System.out.print(pair.getKey() + " = " + pair.getValue() + "| ");
	        it.remove(); // avoids a ConcurrentModificationException
		    bag -= 10;//bag - temp.getIntWeight(); //determines how full bag is
		    map.remove(pair.getKey());
	        System.out.println(map);
	    }
		System.out.println();
	*/
	    //System.out.println(map);
    }

}

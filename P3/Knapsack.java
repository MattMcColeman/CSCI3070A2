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

    MyValuePair(int intValue, int intWeight) {
        this.intValue = intValue;
        this.intWeight = intWeight;
    }

    //Getter and Setter as well as constructor(s) as needed
    public String toString() {
        return "(" + intValue + ", " + intWeight + ")";
    }

    public int getIntValue(){
    	return this.intValue;
    }

	public int getIntWeight(){
		return this.intWeight;
	}
}


public class Knapsack {

    static Map<String, MyValuePair> map = new HashMap<>();

    public static MyValuePair optimalObject(MyValuePair[] P){
    	double W = P[0].getIntWeight();
    	double V = P[0].getIntValue();
    	double E = V/W;
    	int Opt = 0;
    	System.out.println(P[0]);
    	System.out.println(E);
    	for(int i = 1; i < P.length; i++){
        	System.out.println(P[i]);
        	W = P[i].getIntWeight();
        	V = P[i].getIntValue();

        	double F = V/W;
        	if(F>E){
        		Opt = i;
        	}
        	E = F;
        	System.out.println(E);
        }
        return P[Opt];
    }

    public static void main(String[] args) {
        MyValuePair Jade = new MyValuePair(30, 8);
        MyValuePair Gold = new MyValuePair(20, 6);
        MyValuePair Diamond = new MyValuePair(40, 12);
        MyValuePair Bronze = new MyValuePair(10, 1);
        //map.put("Jade", Jade);
        //map.put("Gold", Gold);
        //map.put("Diamond", Diamond);
        //map.put("Bronze", Bronze);

        MyValuePair[] Arr = new MyValuePair[4];
        Arr[0] = Jade;
        Arr[1] = Gold;
        Arr[2] = Diamond;
        Arr[3] = Bronze;

        System.out.println(Jade.getIntWeight());

        System.out.println(map);

        //temp for calculating object weight
        MyValuePair temp;
        //bag can hold 20lbs
        int bag = 20;
        int count = 0;

        System.out.println(optimalObject(Arr));



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

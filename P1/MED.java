/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;




public class MED {
	public static boolean compare(String A, String B){
		boolean result;

		result = (A.substring(0,0).equals(B.substring(0,0)));
		System.out.println(result);
		return result;
	}

    public static void main(String[] args) {
    	String spoof = "spoof";
    	String stool = "stool";
    	
    	//System.out.println(spoof.substring(0,0).equals(stool.substring(0,0)));
    	
    	compare(spoof, stool);

    	System.out.println("Hello");
    }

}
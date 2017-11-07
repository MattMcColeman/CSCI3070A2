/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;




public class MED {
	public static boolean compare(String A, String B){
		boolean result;
		String Ac = A.substring(1,3);
		String Bc = B.substring(2,4);
		result = Ac.equals(Bc);
		System.out.println(result);
		return result;
	}

    public static void main(String[] args) {
    	String spoof = "sooof";
    	String stool = "stool";
    	
    	//System.out.println(spoof.substring(0,0).equals(stool.substring(0,0)));
    	
    	compare(spoof, stool);

    	System.out.println("Hello");
    }

}
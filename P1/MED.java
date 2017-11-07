/**
**Author: Matt McColeman
**SID: 100525235
**Date: 
**/
import java.util.*;

public class MED {

	public static boolean compare(String A, String B){
		boolean result;
		int[][] table = new int[A.length()+1][B.length()+1];
		for (int i = 0; i <= A.length(); i++){
			table[i][0] = i;
			//System.out.print(table[i][0]);
		}
		for (int i = 0; i <= B.length(); i++){
			table[0][i] = i;
			//System.out.print(table[0][i]);
		}
		for (int i = 1; i <= A.length(); i++){
			for (int j = 1; j <= B.length(); j++){
				String Ac = A.substring(i-1,i);
				String Bc = B.substring(j-1,j);
				result = Ac.equals(Bc);
				//System.out.print(result);
				int x = table[i-1][j];
				int y = table[i][j-1];
				int z = table[i-1][j-1];
				if(x <= y && x <= z){
					table[i][j] = x + 1;
				} else if(y <= x && y <= z){
					table[i][j] = y + 1;
				}else{
					if(result){
						table[i][j] = z;
					}else{
						table[i][j] = z + 2;
					}
				}
			}
		}
		
		for (int i = 0; i <= A.length(); i++){
			for (int j = 0; j <= B.length(); j++){
				System.out.print(table[i][j] + "|");
			}
			System.out.println();
		}

		return false;
	}

    public static void main(String[] args) {
    	String spoof = "execution";
    	String stool = "intention";
    	
    	//System.out.println(spoof.substring(0,0).equals(stool.substring(0,0)));
    	
    	compare(spoof, stool);

    	System.out.println("Hello");
    }

}
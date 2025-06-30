package One_banc_as;
import java.util.*;
public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner pm=new Scanner(System.in);
		String s1=pm.next();
		String s2=pm.next();
		
		System.out.println(EditDistance(s1,s2));

	}
	public static int EditDistance(String s1,String s2) {
		 int dp[][]=new int[s1.length()][s2.length()];
		 for(int arr[]:dp) {
			 Arrays.fill(arr, -1);
		 }
		 return Min_opr(s1,s2,0,0,dp);
		 
	}
	public static int Min_opr(String s, String t, int i, int j, int dp[][]) {
	    if (s.length() == i) {
	        return t.length() - j;
	    }
	    if (t.length() == j) {
	        return s.length() - i;
	    }
	    if (dp[i][j] != -1) {
	        return dp[i][j];
	    }

	    int ans = 0;
	    if (s.charAt(i) == t.charAt(j)) {
	        ans = Min_opr(s, t, i + 1, j + 1, dp);
	        dp[i][j] = ans;
	    } else {
	        int D = Min_opr(s, t, i + 1, j, dp);
	        int R = Min_opr(s, t, i + 1, j + 1, dp);
	        int I = Min_opr(s, t, i, j + 1, dp);
	        ans = Math.min(R, Math.min(D, I)) + 1;
	        dp[i][j] = ans;
	    }
	    return dp[i][j];
	}


}

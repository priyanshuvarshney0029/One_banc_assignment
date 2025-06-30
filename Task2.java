package One_banc_as;
import java.util.*;
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner pm=new Scanner(System.in);
        String s1 = pm.nextLine();
        String s2 = pm.nextLine();
        int Ci =pm.nextInt();
        int Cd = pm.nextInt();
        int Cs = pm.nextInt();
        
        int result = EditDistance(s1, s2, Ci, Cd, Cs);
        
        System.out.println( result);
	}
	 public static int EditDistance(String s1, String s2, int Ci, int Cd, int Cs) {
	        int m = s1.length();
	        int n = s2.length();
	        
	        int[][] dp = new int[m + 1][n + 1];
	        
	        for (int i=0;i<=m;i++) {
	            dp[i][0]=i*Cd;
	        }
	        for (int j=0;j<=n;j++) {
	            dp[0][j]=j*Ci;
	        }
	        
	        for (int i=1;i<=m;i++) {
	            for (int j=1;j<=n;j++) {
	                if (s1.charAt(i-1)==s2.charAt(j-1)) {
	                    dp[i][j]=dp[i-1][j-1];
	                }
	                else {
	                    int insert_Cost=dp[i][j-1]+Ci;
	                    int delete_Cost=dp[i-1][j]+Cd;
	                    int substitute_Cost=dp[i-1][j-1]+Cs;
	                    
	                    dp[i][j] = Math.min(insert_Cost, Math.min(delete_Cost, substitute_Cost));
	                }
	            }
	        }
	        
	        return dp[m][n];
	    }

}

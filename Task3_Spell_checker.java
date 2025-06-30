package One_banc_as;
import java.util.*;
public class Task3_Spell_checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner pm=new Scanner(System.in);
		String dic[]=pm.nextLine().split(" ");
		
		int ci=pm.nextInt();
		int cd=pm.nextInt();
		int cs=pm.nextInt();
		
		pm.nextLine();
		String inp=pm.nextLine();
		int min_dis=Integer.MAX_VALUE;
		HashMap<String,Integer> dist_map=new HashMap<>();
		
		for(String word:dic) {
			int dd=edit_distance(inp,word,ci,cd,cs);
			dist_map.put(word, dd);
			if(dd<min_dis) {
				min_dis=dd;
			}
		}
		List<String> close=new ArrayList<>();
		for(Map.Entry<String,Integer> entry:dist_map.entrySet()) {
			if(entry.getValue()==min_dis) {
				close.add(entry.getKey());
			}
		}
		System.out.println(close);

	}
	public static int edit_distance(String s1,String s2,int ci,int cd,int cs) {
		int m=s1.length();
		int n=s2.length();
		
		int [][]dp=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			dp[i][0]=i*cd;
		}
		for(int j=0;j<=n;j++) {
			dp[0][j]=j*ci;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				int cost=s1.charAt(i-1)==s2.charAt(j-1)?0:cs;
			   dp[i][j] =Math.min( dp[i-1][j] + cd, Math.min(dp[i][j-1] + ci, dp[i-1][j-1] + cost));
			}
		}
		return dp[m][n];
	}
	

}

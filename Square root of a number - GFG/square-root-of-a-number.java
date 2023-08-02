//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long low = 1;
		long high = x;
		long ans = -1;
		if(x == 0){
		    return 0;
		}
		while(low <= high){
		    long mid = low + (high - low)/2;
		    if(mid * mid <= x){
		        ans = mid;
		        low = low + 1;
		    }
		    else{
		        high = high - 1;
		    }
		}
		return ans;
	 }
}

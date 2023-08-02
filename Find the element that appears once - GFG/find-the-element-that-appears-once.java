//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int A[], int N)
    {
        // your code here
        if(N == 1){
            return A[0];
        }
        if(A[0] != A[1]){
            return A[0];
        }
        if(A[N-1] != A[N-2]){
            return A[N-1];
        }
        int low = 1, high = N-2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]){
                return A[mid];
            }
            // (even, odd) --> element in right position
            // (odd, even) --> element in left position
            if(((mid % 2 == 1) && (A[mid - 1] == A[mid])) || ((mid % 2 == 0)&& A[mid + 1] == A[mid])){
                low = mid + 1;
            }
            else if(((mid % 2 == 0) && (A[mid - 1] == A[mid])) || ((mid % 2 == 1)&& A[mid + 1] == A[mid])){
                high = mid - 1;
            }
        }
        return -1;
    }
}
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FindMinHeightDiff {
    public static int solution(int[] a, int n, int k){
        Arrays.sort(a);
        //find longest tower
        int longestTowerWithK = 0;
        for(int i=0; i<n-1; i++){
            if ( a[i] < k )
                continue;
            if ( a[i] > a[n-1] - k)
                longestTowerWithK = a[i];
        }
        int shortestTowerWithoutK = Integer.MAX_VALUE;
        for(int i=n-1; i>0; i--){
            System.out.println(i);
        }
        return shortestTowerWithoutK;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int k = sc.nextInt();
        int n = sc.nextInt(); 
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        out.print(solution(arr, n, k));
        
        out.flush();
    }
    
}

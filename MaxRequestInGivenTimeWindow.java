// given an array on integer of length N representing timestamps of request came at a certain minute, and a window size W find the maximum number of requests come in any window of given size,
// Say N = 4, W = 4
// [1,3, 7, 5]
// The windows can be 
// [1,3] has 2 req
// [3,6] has 2 req
// [5,8] has 2 req
// so max number of req can be 2 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxRequestInGivenTimeWindow {
    public static void main(String[] args){
        //take input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> requestTimeStamps = new ArrayList<>();
        for(int i =0; i<n; i++){
            int v = sc.nextInt();
            requestTimeStamps.add(v);
        }
        int w = sc.nextInt();
        System.out.print(solve(requestTimeStamps, w));
    }

    public static int solve(List<Integer> requests, int w){
        int maxReq = 0;
        requests.sort(null);
        int start = 0;
        int end = 0;
        //now on the sorted list shrink the window ie start++ till requests[end] - requests[start] > w
        while(end<requests.size()){
            if(requests.get(end) - requests.get(start) > w){
                start++;
            }
            maxReq = Math.max(maxReq, end - start + 1);
            end++;
        }
        return maxReq;
    }
}

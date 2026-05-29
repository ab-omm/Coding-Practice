import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
Given a List of m List of 3 Integers that m x 3 matrix

such that each row means 1 of following operations

1, p, x -> at position p replace with x

2, -1, x -> at all position where a[i] < x, convert it to x

Find the most effective way to find out the final form of input list after all the m operations are done on it. 
 */
public class TrackUpNodes {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//number of elements
        List<Integer> arr = new ArrayList<>();
        int inp;
        for(int i=0; i<n; i++){
            inp = sc.nextInt();
            arr.add(inp);
        }
        //read operations array given as 2d matrix
        int instNum = sc.nextInt();
        List<List<Integer>> instructions = new ArrayList<>();
        for(int i =0; i<instNum; i++){
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            instructions.add(l);
        }
        List<Integer> res = solve(n, arr, instructions);
        System.out.print(res);  
    }
    //solve to find what will be final state of arr after all the operations
    public static List<Integer> solve(int n, List<Integer> arr, List<List<Integer>> instructions){
        // instructions are of 2 types
        // 1 p x type 1 which does arr[p] = x
        // 2 -1 x type 2 which replaces all values in the array which are less than x to x
        //process the instructions in reverse order
        // for all the type 1 instruction the last value updated of that 
        // index will be the final value for that index so processing from end if an index
        // is not yet visited take it as it's last updated value keep a visited time record storing `t`
        // because any type 2 operations that might have been happened after that will affect it if it 
        // is greater than the base value (either value at arr[i] if it was never visited or it's updated value 'x' through type 1 operation) 

        // and the type 2 instruction at any time t (number of instructions to 0) 
        // the value will be Max(x, Max_Value[t+1])
        int numOfInst = instructions.size();
        int[] lastUpdatedVal = new int[n];
        int[] visitedTime = new int[n];
        Arrays.fill(visitedTime, -1);

        int[] maxValueAtAnyTime = new int[numOfInst+1];
        //process instructions
        for(int t = numOfInst - 1; t>=0; t--){
            List<Integer> instruction = instructions.get(t);
            int typeOfInstruction = instruction.get(0);
            switch (typeOfInstruction) {
                case 1:
                    int updatingIndex = instruction.get(1);
                    if(visitedTime[updatingIndex]==-1){
                        lastUpdatedVal[updatingIndex] = instruction.get(2);
                        visitedTime[updatingIndex] = t;
                    }
                    //the max value till this time will be the last maximum
                    maxValueAtAnyTime[t] = maxValueAtAnyTime[t+1];
                    break;
                case 2:
                    maxValueAtAnyTime[t] = Math.max(instruction.get(2), maxValueAtAnyTime[t+1]);
                    break;
                default:
                    break;
            }
        }
        //make the final list
        for(int i = 0; i < n; i++ ){
            if(visitedTime[i]!= -1){
                //type 1 instruction was done on it
                arr.set(i, Math.max(lastUpdatedVal[i], maxValueAtAnyTime[visitedTime[i]+1]));
            }else{
                //if it was never visited then it will be Max of Max Value of all time i.e maxValueAtAnyTime(0) and it's initial value arr[i]
                arr.set(i, Math.max(arr.get(i), maxValueAtAnyTime[0] ));
            }
        }
        return arr;
    }
    // space complexity M + N
    // time complexity M + N

    public static void printMatrix(List<List<Integer>> mat ){
        for(List<Integer> l: mat){
            for(Integer i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}

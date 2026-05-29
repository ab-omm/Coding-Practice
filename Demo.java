import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class Demo {
    public static void main(String[] args){
        // Scanner scanner = new Scanner(System.in);
        // int x = scanner.nextInt();
        // System.out.println("Hey "+x);
        // scanner.close();
        // int[] aar = {1, 2, 6 , 45, 453};
        // for(int e: aar){
        //     System.out.println(e);
        // }
        // about sets
        // Set<Integer> iSet = new HashSet<Integer>();
        // iSet.add(4);
        // iSet.add(3);
        // iSet.add(6);
        // iSet.add(2);
        // iSet.add(9);
        // iSet.add(0);
        // // iSet.add(null);
        // System.out.println(iSet.isEmpty());
        // System.out.println(iSet.contains(4));
        // System.out.println(iSet.remove(null));
        
        //about arrayList
        // List<Integer> arrL = new ArrayList<Integer>();
        
        // arrL.add(3);
        // arrL.add(33);
        // arrL.add(31);
        // arrL.add(33);
        // arrL.add(4);
        // arrL.add(53);
        // arrL.add(37);
        // arrL.add(38);
        // arrL.add(5, 89);
        // arrL.set(1, 32);
        // System.out.println(arrL);
        // arrL.remove(3);
        // System.out.println(arrL);

        //we can also add any type of elements in the list
        // List anyE = new ArrayList<>();
        // anyE.add("helo");
        // anyE.add(33);
        // System.out.println(anyE);

        //about maps 
        //HashMap unordered, 
        //TreeMap key sorted order thus have to have the same key type,
        //LinkedHashMap retains the order of insertion 
        // Map map = new TreeMap<>();
        
        // map.put("house","mnerva");
        // map.put("building","tower c");
        // System.out.println(map);
        // PriorityQueue<Integer> pQueue
        //     = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        // pQueue.add(10);
        // pQueue.add(20);
        // pQueue.add(15);

        // Printing the top element of PriorityQueue
        // System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        // System.out.println(pQueue.poll());

        // Printing the top element again
        // System.out.println(pQueue.peek());
        // Set<Object> set = new HashSet<>();
        // set.add(1);
        // set.add("str");
        // set.add(6.09);
        // set.add(pQueue);
        // System.out.println(set);
        reverseBits(12);
        System.out.println(reverseBitsBetter(12));
    }

    public static long reverseBits(long n) {
		// Write your code here
		//find 32 bit representation
		int[] bits = new int[32];
		long auxn = n;
        int i =0;
		while(auxn>0){
			bits[i] = auxn%2 == 0 ? 0 : 1 ;
			auxn/=2;
            i++;
		}
		System.out.println(bits);
        for(int j = 0; j<bits.length; j++ ){
            System.out.print(" "+bits[j]);
        }
		

		//calculate decimal value of it
        long decimal = 0;
        long powerOf2 = 1;
        for(int j =  bits.length-1; j >=0; j--){
            decimal += powerOf2*bits[j];
            powerOf2*=2;
            System.out.println("power of 2 "+powerOf2);
        }
        System.out.println("decimal " + decimal);
        return 0L;
	}
    public static long reverseBitsBetter(long n){
        //it can be done through bit manipulation also 
        long auxn = n;
        int i = 31;
        long decimal = 0;
        while(i>=0 && auxn > 0){
            if(auxn%2 == 1){
                decimal += Math.pow(2, i);
            }
            auxn/=2;
            i--;
        }
        return decimal;
    }
}

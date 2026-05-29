import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean res = solve(n);
        System.out.print(res);    
    }
    public static boolean solve(int n){
        //findout reverse number
        int revNum = reverseNumber(n);
        //return if they are same
        return revNum == n;
    }
    public static int reverseNumber(int n){
        int auxN = n;
        int res = 0;
        while(auxN%10 == 0){
            auxN /= 10;
        }
        while(auxN > 0){
            int lastDigit = auxN%10;
            // sb.append(lastDigit);
            res = res*10 + lastDigit;
            auxN/=10;
        }
        return res;
    }
}

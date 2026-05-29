import java.util.Arrays;
import java.util.Scanner;
public class PalindromeSubstrings {
    
    private boolean[][] isPalindrome;
    private int[] memo;
    private int stringLength;
    private int minPalindromeLength;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        PalindromeSubstrings ps = new PalindromeSubstrings();
        System.out.println(Palindrome.reverseNumber(n));
        System.out.println(ps.maxPalindrome(s, k));
    }
    public int maxPalindrome(String s, int k){
        stringLength = s.length();
        minPalindromeLength = k;
        isPalindrome = new boolean[stringLength][stringLength];
        memo = new int[stringLength];
        for(int i = 0; i < stringLength; i++ ){
            Arrays.fill(isPalindrome[i], true);
            memo[i] = -1;
        }
        // printMatrix(isPalindrome, stringLength, stringLength);
        //calculate palindrome matrix
        for(int i = stringLength - 1; i>=0; i--){
            for(int j = i+1; j<stringLength; j++){
                System.out.println("processing "+i+" "+j);
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1]; 
            }
        }
        // printMatrix(isPalindrome, stringLength, stringLength);
        
        return 0;
    }

    private void printMatrix(boolean[][] m, int l, int b){
        for(int i=0; i<l; i++){
            for(int j=0; j<b; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

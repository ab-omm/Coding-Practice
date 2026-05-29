import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        solution2(n);
    }

    

    private static void solution(int n) {
        for(int i = 1; i<=n; i++){
            int c = i%15==0?1:i%3==0?2:i%5==0?3:0;
            switch (c) {
                case 1:
                    System.out.println("FizzBuzz");
                    break;
                case 2:
                    System.out.println("Fizz");
                    break;
                case 3:
                    System.out.println("Buzz");
                    break;
                default:
                    System.out.println(i);
                    break;
            }
        }
    }

    private static void solution2(int n){
        for(int i=1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            if(i%3 == 0) sb.append("Fizz");
            if(i%5 == 0) sb.append("Buzz");
            System.out.println(sb.length()>0?sb.toString():i);
        }
    }
}

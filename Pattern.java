import java.util.Scanner;
import static java.lang.Math.min;
public class Pattern {
    /*
     * this class have all pattern problems solution from striver A2Z
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // patternRectangle(n);
        theNumberPattern(n);
    }

    static void patternRectangle(int n){
        // ***
        // ***
        // ***
        StringBuffer buffer = new StringBuffer();

        for(int i = 0 ; i < n; i++){
            
            for(int j = 0; j < n; j++){
                buffer.append('*');
            }
            if(i != n-1)
                buffer.append('\n');
        }

        System.out.print(buffer.toString());
    }

    static void patternRightTriangle(int n){
        // *
        // **
        // ***
        if(n <= 0)return;
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                buffer.append('*');
            }
            if( i != n-1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternRightTriangleNum(int n){
        // 1
        // 12
        // 123
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                buffer.append(j+1);
            }
            if( i != n-1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternRightTriangleSingleNum(int n){
        // 1
        // 22
        // 333
        StringBuffer buffer = new StringBuffer();
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                buffer.append(i);
            }
            if( i != n)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternRightTriangleUpsideDown(int n){
        // ***
        // **
        // *
        if(n <= 0)return;
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                buffer.append('*');
            }
            if( i != n-1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternRightTriangleNumUpsideDown(int n){
        // 123
        // 12
        // 1
        StringBuffer buffer = new StringBuffer();
        for(int i=n; i>0; i--){
            for(int j = 1; j<=i; j++){
                buffer.append(j);
            }
            if( i != 1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternPyramid(int n){
        //      *   
        //     ***  
        //    ***** 
        if(n<1 && n>25)return;
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < n; i++){
            int numChars = 2*n - 1;
            for(int j = 0; j<=numChars; j++){
                if( j>= n-1-i && j <= n-1+i)
                    buffer.append('*');
                else
                    buffer.append(' ');

            }
            if( i < n - 1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternInvertedPyramid(int n){
        // ***** 
        //  ***  
        //   *   
        if(n<1 && n>25)return;
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < n; i++){
            int numChars = 2*n - 1;
            for(int j = 0; j<=numChars; j++){
                if( j>= i && j < numChars - i)
                    buffer.append('*');
                else
                    buffer.append(' ');

            }
            if( i < n - 1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternDiamondStar(int n){
    //      *   
    //     ***  
    //    ***** 
    //    ***** 
    //     ***  
    //      * 
        patternPyramid(n);
        System.out.println();
        patternInvertedPyramid(n);
    }

    static void patternhalfDiamondStar(int n){
        // *
        // **
        // ***
        // **
        // *
        if(n<1 && n>25)return;
        patternRightTriangle(n);
        if(n>1)
        {
            System.out.println();
            patternRightTriangleUpsideDown(n-1);
        }
    }

    static void patternBinaryTriangle(int n){
        // 1
        // 01
        // 101
        if(n<1)return;
        StringBuffer buffer = new StringBuffer();
        for(int i=1; i<=n; i++){
            int strtBit = i%2;
            for(int j=1;j<=i;j++){
                buffer.append(strtBit);
                strtBit = 1 - strtBit;
            }
            if(i<n)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void patternNumberCrown(int n){
        // 1    1
        // 12  21
        // 123321
        if(n<1)return;
        StringBuffer buffer = new StringBuffer();
        int space = 2*(n - 1);
        for(int i = 1; i<=n; i++){
            //first approach correct but better approach below
            // for(int j=1; j<=2*n; j++){
            //     if(j<=n){
            //         if(j<=i)
            //             buffer.append(j);
            //         else
            //             buffer.append(' ');
            //     }else {
            //         if(2*n - (j-1) <= i)
            //             buffer.append(2*n - (j-1));
            //         else
            //             buffer.append(' ');
            //     }
            // }
            //Number
            for(int j=1; j<=i; j++)
                buffer.append(j);
            
            //Space
            for(int j=0; j<space; j++)
                buffer.append(' ');
            
            //Number
            for(int j=i; j>=1; j--)
                buffer.append(j);
            
            if(i<n)
                buffer.append('\n');
            space-=2;
        }
        System.out.print(buffer.toString());
    }
    static void increasingNumberTriangle(int n){
        // 1
        // 23
        // 456
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        int start = 1;
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=i; j++){
                buffer.append(start++);
            }
            if(i<n)buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void increasingLetterTriangle(int n){
        // A
        // AB
        // ABC
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=1; i<=n; i++){
            // int start = 65; //ASCII for A
            for(int j=0; j<i; j++){
                buffer.append((char) (65+j));
            }
            if(i<n)buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void reverseIncreasingLetterTriangle(int n){
        // ABC
        // AB
        // A
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=0; i<n; i++){
            // int start = 65; //ASCII for A
            for(int j=0; j<n-i; j++){
                buffer.append((char) (65+j));
            }
            if(i<n-1)buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }

    static void alphaRampPattern(int n){
        // A
        // BB
        // CCC
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                buffer.append((char) (65+i));
            }
            if(i<n-1)buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }
    static void alphaHillPattern(int n){
        //      A  
        //     ABA 
        //    ABCBA
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=0; i<n; i++){
            //space
            for(int j = 0; j<n-i-1; j++)
                buffer.append(' ');

            //alphabets
            int strt = 65;//ASCII value of A
            for(int j = 0; j< 2*i + 1; j++){
                buffer.append((char) strt);
                if(j<i)
                    strt++;
                else
                    strt--;
            }

            //space
            for(int j = 0; j<n-i-1; j++)
                buffer.append(' ');

            if(i<n-1){
                buffer.append('\n');
            }
        }
        System.out.print(buffer.toString());
    }
    static void aplhaTrianglePattern(int n){
        // C
        // BC
        // ABC
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i = 1; i<=n; i++){
            int start = 65 + n - i;
            for(int j=1;j<=i; j++){
                buffer.append((char)start++);
            }
            if(i<n)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }
    static void symmetricVoidPattern(int n){
        // **********
        // ****  ****
        // ***    ***
        // **      **
        // *        *
        // *        *
        // **      **
        // ***    ***
        // ****  ****
        // **********
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=0; i<n; i++){
            //star
            for(int j = 0; j < n - i; j++)
                buffer.append('*');
            //space
            for(int j=0; j<2*i; j++)
                buffer.append(' ');
            //start
            for(int j = 0; j < n - i; j++)
                buffer.append('*');
            if(i<n)
                buffer.append('\n');
        }
        for(int i=1; i<=n; i++){
            //star
            for(int j = 0; j < i; j++)
                buffer.append('*');
            //space
            for(int j=0; j<2*(n-i); j++)
                buffer.append(' ');
            //start
            for(int j = 0; j <i; j++)
                buffer.append('*');
            if(i<n)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }
    static void butterflyPattern(int n){
        // *    *
        // **  **
        // ******
        // **  **
        // *    *
        if(n<1)return;
        if(n==1){
            System.out.print('*');
            return;
        }
        StringBuffer buffer=new StringBuffer();
        int elseSpaceCount = 2;
        int elseStarCount = n-1;
        for( int i = 1; i <= 2*n - 1; i++){
            if(i<=n){
                //star
                for(int j = 0; j<i ;j++)
                    buffer.append('*');
                //space
                for(int j = 0; j< 2*(n-i); j++)
                    buffer.append(' ');
                //star
                for(int j = 0; j<i ;j++)
                    buffer.append('*');
            }else{
                //star
                for(int j=0; j<elseStarCount; j++)
                    buffer.append('*');
                //space
                for(int j = 0; j< elseSpaceCount; j++)
                    buffer.append(' ');
                //star
                for(int j=0; j<elseStarCount; j++)
                    buffer.append('*');
                elseSpaceCount+=2;
                elseStarCount--;
            }
            if(i<2*n-1)
                buffer.append('\n');    
        }
        System.out.print(buffer.toString());
    }
    static void hollowRectanglePattern(int n){
        // ***
        // * *
        // ***
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<n; i++){
            if(i==0 || i==n-1){
                for(int j = 0; j<n; j++)
                    buffer.append('*');
            }else{
                buffer.append('*');
                for(int j = 0; j<n-2; j++)
                    buffer.append(' ');
                buffer.append('*');
            }
            if(i<n-1)
                buffer.append('\n');
        }
        System.out.print(buffer.toString());
    }
    static void theNumberPattern(int n){
        // 33333
        // 32223
        // 32123
        // 32223
        // 33333
        if(n<1)return;
        StringBuffer buffer=new StringBuffer();
        //the solution lies in knowing that all the numbers are n - min distance from edge of the matriX
        for(int i = 0; i < 2*n - 1; i++){
            for(int j = 0; j < 2*n - 1; j++){
                int top = i;
                int left = j;
                int bottom = (2*n - 2) - i;
                int right = (2*n - 2) - j;
                buffer.append(n - min(min(min(top, left),bottom),right));
            }
            if(i<2*n-2){
                buffer.append('\n');
            }
        }
        System.out.print(buffer.toString());
    }
}

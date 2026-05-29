import java.util.List;

public class Utilities {
    public static void printMatrix(List<List<Integer>> mat ){
        for(List<Integer> l: mat){
            for(Integer i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

package Target100Days;
import java.util.*;

public class Day19 {
    //remove duplicate from an array
    public static Set<Integer> remDup(int[] arr){
        int n=arr.length;
        Set<Integer> set=new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        return set;
    }

    //intersection of two sets
    public static Set<Integer> intersect(Set<Integer> set1,Set<Integer> set2){
        Set<Integer> res=new HashSet<>(set1);
        res.retainAll(set2);
        return res;
    }
    public static void main(String[] args) {
        int[] arr1={1,1,2,2,2,2,2,3,3,4,5,5,0};
        int[] arr2 = {2, 3, 5, 6, 7};
        System.out.println(remDup(arr1));
        Set<Integer> set1 = remDup(arr1);
        Set<Integer> set2 = remDup(arr2);

        System.out.println("Set 1 (Unique): " + set1);
        System.out.println("Set 2 (Unique): " + set2);
        System.out.println("Intersection: " + intersect(set1, set2));
    }
}

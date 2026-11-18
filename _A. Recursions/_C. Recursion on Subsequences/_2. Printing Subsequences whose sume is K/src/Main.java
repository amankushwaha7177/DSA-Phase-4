import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k =2;

        // code here
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        System.out.println(Arrays.toString(arr));
        check(0, arr, current, result, 0, k);
        System.out.println(result);

    }


    public static void check(int i, int[] arr, List<Integer> current, List<List<Integer>>  result, int s, int k){
        if(i == arr.length){
            if(s == k){
                result.add(new ArrayList(current));
            }
            return;
        }

        current.add(arr[i]);
        s = s + arr[i];
        check(i+1, arr, current, result, s, k);

        current.remove(current.size()-1);
        s = s - arr[i];
        check(i+1, arr, current, result, s, k);
    }
}

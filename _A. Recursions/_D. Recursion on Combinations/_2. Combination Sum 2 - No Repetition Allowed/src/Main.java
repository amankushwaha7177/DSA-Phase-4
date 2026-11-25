import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 2};
        int target = 3;

        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        fun(0, candidates, curr, result, target, 0);
        System.out.println(result);
    }

    public static void fun(int i, int[] arr, List<Integer> curr, List<List<Integer>> result, int k, int sum){
        if(sum == k){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(i == arr.length){
            return;
        }

        if(sum > k){
            return;
        }

        sum+=arr[i];
        curr.add(arr[i]);
        fun(i+1, arr, curr, result, k, sum);

        sum-=arr[i];
        curr.remove(curr.size()-1);

        int j = i;
        while(j+1 <= arr.length-1 && arr[j] == arr[j+1]){
            j++;
        }
        fun(j+1, arr, curr, result, k, sum);
    }
}
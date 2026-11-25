import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        Arrays.sort(nums);

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result  =  new ArrayList<>();

        fun(0, nums, curr, result);
        System.out.println(result); // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    }

    public static void fun(int i, int[] arr, List<Integer> curr, List<List<Integer>> result){
        if(i == arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        fun(i+1, arr,  curr, result);


        curr.remove(curr.size() -1);
        int j = i;
        while(j+1 <= arr.length-1 && arr[j] == arr[j+1]){
            j++;
        }
        fun(j+1, arr,  curr, result);
    }
}
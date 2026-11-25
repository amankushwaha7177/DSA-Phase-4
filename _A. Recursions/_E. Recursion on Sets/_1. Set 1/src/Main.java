import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result  =  new ArrayList<>();

        fun(0, nums, curr, result);
        System.out.println(result);
    }

    public static void fun(int i, int[] arr, List<Integer> curr, List<List<Integer>> result){
        if(i == arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        fun(i+1, arr,  curr, result);

        curr.remove(curr.size() -1);
        fun(i+1, arr,  curr, result);
    }
}
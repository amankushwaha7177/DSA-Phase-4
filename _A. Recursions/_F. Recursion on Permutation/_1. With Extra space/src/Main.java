import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        /*Always size of nums = curr = used in permutation */

        fun(nums, used, curr, result);
        System.out.println(result);
    }

    public static void fun(int[] arr, boolean[] used, List<Integer> curr, List<List<Integer>> result){
        if(curr.size() == arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i<= arr.length-1; i++){
            if(used[i] == true){
                continue;
            }

            curr.add(arr[i]);
            used[i] = true;
            fun(arr, used, curr, result);

            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }

}
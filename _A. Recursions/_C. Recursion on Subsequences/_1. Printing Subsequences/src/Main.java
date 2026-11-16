import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,1};

        // code here
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        check(0, arr, current, result);
        System.out.println(result);

    }


    public static void check(int i, int[] arr, List<Integer> current, List<List<Integer>>  result){
        if(i == arr.length){
                result.add(new ArrayList(current));
            return;
        }

        current.add(arr[i]);
        check(i+1, arr, current, result);

        current.remove(current.size()-1);
        check(i+1, arr, current, result);
    }
}

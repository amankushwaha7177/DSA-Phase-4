import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

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


/*
Time Complexity of Generating All Subsequences:

1. For an array of size n, every element has two choices:
   TAKE or NOT TAKE.

2. Therefore, total subsequences = 2^n.

3. If we only generate subsequences without storing or copying them:
   Time Complexity = O(2^n).

4. If we store every subsequence in a result list:
   Each subsequence can contain at most n elements.

5. Copying each subsequence can take O(n) time.

6. We generate 2^n subsequences, and each copy can cost O(n).

   Total Time Complexity = O(n * 2^n).

Example:
arr = [1, 2, 3]

Total subsequences = 2^3 = 8.

[1,2,3] -> 3 elements
[1,2]   -> 2 elements
[1,3]   -> 2 elements
[1]     -> 1 element
[2,3]   -> 2 elements
[2]     -> 1 element
[3]     -> 1 element
[]      -> 0 elements

Auxiliary Space Complexity:
O(n) for recursion stack and current subsequence.

Final:
Without storing/copying = O(2^n)
With storing/copying = O(n * 2^n)
Auxiliary Space = O(n), excluding output storage.
*/
import java.util.*;

public class Temp {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generate(0, arr, current, result);

        System.out.println(result);
    }

    public static void generate(
            int index,
            int[] arr,
            List<Integer> current,
            List<List<Integer>> result) {

        /*

        PROBLEM: PRINT ALL SUBSEQUENCES

        At every index, we have two choices:

        1. TAKE the current element.
        2. DO NOT TAKE the current element.

        Example:
        arr = [1, 2, 3]

        Total subsequences = 2^n = 2^3 = 8.


        RECURSION TREE:

                              (0, [])
                             /        \
                         TAKE 1     SKIP 1
                           /            \
                       (1,[1])        (1,[])
                       /    \          /    \
                   TAKE 2 SKIP 2   TAKE 2 SKIP 2
                     /       \       /       \
                (2,[1,2]) (2,[1]) (2,[2])   (2,[])
                   / \       / \     / \       / \
                  T   S     T   S   T   S     T   S


        T = TAKE
        S = SKIP

        Every root-to-leaf path represents one subsequence.


        STEP 1: BASE CASE

        When index == arr.length, we have processed every element.

        The current subsequence is now complete.

        Store a copy of current inside result.

        WHY new ArrayList<>(current)?

        Directly adding current stores its reference, not a separate copy.

        During backtracking, current gets modified using remove().
        Previously stored subsequences would also appear modified
        because they point to the same list.

        new ArrayList<>(current) creates an independent copy.

        */

        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }


        current.add(arr[index]);

        generate(index + 1, arr, current, result);

        /*

        STEP 3: BACKTRACK

        The TAKE branch has completed.

        We are now returning to the previous recursive call.
        */

        current.remove(current.size() - 1);

        /*

        STEP 4: DO NOT TAKE CURRENT ELEMENT

        We don't add arr[index] to current.

        Simply move to the next index.

        Example:

        current = [1, 2]

        We skip element 3.

        The next recursive call reaches the base case
        and stores [1, 2].

        MOVEMENT: GOING DOWN THE OTHER BRANCH.

        */

        generate(index + 1, arr, current, result);
    }
}


/*
FINAL RESULT:

[
    [1, 2, 3],
    [1, 2],
    [1, 3],
    [1],
    [2, 3],
    [2],
    [3],
    []
]


IMPORTANT CONCEPTS:

1. Every element has two choices: TAKE or NOT TAKE.

2. Every leaf of the recursion tree represents one subsequence.

3. Backtracking removes the last selected element.

4. The same current list is reused across recursive calls.

5. The result list stores independent copies.

6. Total subsequences = 2^n.

7. Time Complexity = O(n * 2^n), including copying/collecting results.

8. Auxiliary Space = O(n) for recursion stack and current list.
*/

/*
 * We use new ArrayList<>(current) instead of directly adding current.
 *
 * Reason:
 * Directly adding current stores its reference, not a separate copy.
 * During backtracking, current gets modified using remove().
 * Since both references point to the same list, previously stored
 * subsequences would also get modified.
 *
 * new ArrayList<>(current) creates an independent copy of the list.
 * Therefore, future modifications to current do not affect
 * the subsequences already stored in result.
 */

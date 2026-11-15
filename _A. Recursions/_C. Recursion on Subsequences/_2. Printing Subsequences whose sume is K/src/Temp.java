import java.util.*;

public class Temp {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int k = 3;

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        generate(0, arr, current, result, 0, k);

        System.out.println(result);
    }

    public static void generate(
            int index,
            int[] arr,
            List<Integer> current,
            List<List<Integer>> result,
            int currentSum,
            int k) {

        /*

        PROBLEM: PRINT ALL SUBSEQUENCES WHOSE SUM IS K

        At every index, we have two choices:

        1. TAKE the current element.
        2. DO NOT TAKE the current element.

        Example:
        arr = [1, 2, 3]
        K = 3

        Valid subsequences:
        [1, 2] -> Sum = 3
        [3]     -> Sum = 3


        RECURSION TREE:

                              (0, [], sum=0)
                              /            \
                          TAKE 1          SKIP 1
                           /                  \
                    (1,[1],sum=1)         (1,[],sum=0)
                       /      \              /      \
                   TAKE 2   SKIP 2       TAKE 2   SKIP 2
                     /          \           /          \
               (2,[1,2],3)  (2,[1],1)  (2,[2],2)   (2,[],0)

        Every leaf represents one complete subsequence.

        At the leaf, we check whether currentSum == k.

        Only matching subsequences are stored.


        STEP 1: BASE CASE

        When index == arr.length, every element has been processed.

        Now check whether the current subsequence has sum K.

        If yes, store an independent copy of current.

        WHY new ArrayList<>(current)?

        Directly adding current stores its reference, not a separate copy.

        During backtracking, current gets modified using remove().

        Previously stored subsequences would also appear modified
        because they point to the same list.

        new ArrayList<>(current) creates an independent copy.

        */

        if (index == arr.length) {

            if (currentSum == k) {
                result.add(new ArrayList<>(current));
            }

            return;
        }


        /*

        STEP 2: TAKE CURRENT ELEMENT

        Add arr[index] to current.

        Also add its value to currentSum.

        Example:

        index = 0
        arr[index] = 1

        current = [1]
        currentSum = 1

        Move to the next index recursively.

        MOVEMENT: GOING DOWN THE TAKE BRANCH.

        */

        current.add(arr[index]);

        generate(
                index + 1,
                arr,
                current,
                result,
                currentSum + arr[index],
                k
        );


        /*

        STEP 3: BACKTRACK

        The TAKE branch has completed.

        We are now returning to the previous recursive call.

        Remove the last added element to restore current.

        Example:

        current = [1, 2, 3]

        Remove 3.

        current = [1, 2]

        IMPORTANT:

        We don't need to subtract from currentSum here.

        currentSum is passed as an integer parameter.
        Each recursive call has its own value of currentSum.

        MOVEMENT: COMING BACK UP THE TREE.

        */

        current.remove(current.size() - 1);


        /*

        STEP 4: DO NOT TAKE CURRENT ELEMENT

        We don't include arr[index] in current.

        We also don't add anything to currentSum.

        Simply move to the next index.

        Example:

        current = [1, 2]
        currentSum = 3

        We skip element 3.

        The next recursive call reaches the base case.
        Since currentSum == k, store [1, 2].

        MOVEMENT: GOING DOWN THE NOT TAKE BRANCH.

        */

        generate(
                index + 1,
                arr,
                current,
                result,
                currentSum,
                k
        );
    }
}


/*

FINAL RESULT FOR:

arr = [1, 2, 3]
K = 3

[
    [1, 2],
    [3]
]


IMPORTANT CONCEPTS:

1. Every element has two choices: TAKE or NOT TAKE.

2. current stores the currently selected elements.

3. currentSum stores the sum of selected elements.

4. TAKE:
   Add the element to current.
   Add its value to currentSum.

5. BACKTRACK:
   Remove the last selected element from current.

6. NOT TAKE:
   Don't modify currentSum.
   Move to the next index.

7. At the base case:
   Check whether currentSum == k.

8. Store only matching subsequences using:
   new ArrayList<>(current).


COMPLEXITY:

Time Complexity = O(n * 2^n) in the worst case,
including copying matching subsequences.

Auxiliary Space = O(n) for recursion stack and current list,
excluding the result list.

*/
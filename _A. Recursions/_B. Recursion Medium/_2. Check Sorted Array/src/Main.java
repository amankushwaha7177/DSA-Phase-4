public class Main {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};

        int n = arr.length;
        int i =0;
        System.out.println(check(arr, i, n));
    }

    public static boolean check(int[] arr, int i, int n){
        if(i >= n-1){
            return true;
        }

        if(arr[i] < arr[i+1]){
            // return true;
            // keep going
        }

        if(arr[i] > arr[i+1]){
            return false;
        }

        return check(arr, i+1, n);
    }
}

// Given an array arr[], check whether it is sorted in non-decreasing order.
// Return true if it is sorted otherwise false.
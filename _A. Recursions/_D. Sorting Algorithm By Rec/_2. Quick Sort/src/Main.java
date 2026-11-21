import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,2,6,4};

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition +1, high);
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while(i < j){

            while(i <= j && arr[i] <= pivot){       // skip all <=      + pause at >
                i++;
            }

            while(i <= j && arr[j] > pivot){        // skip all >      + pause at <=
                j--;
            }

            if(i < j){                             // swap misplace element
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // where j will stop it will be partition point
        // so first swap pivot and partition
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j]= temp;

        return j;
    }
}
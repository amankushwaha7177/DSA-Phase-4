import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4, 1, 5, 2, 6, 4};

        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }

        int mid = low + (high -low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge2SortedArrays(arr, low, mid, high);
    }

    public static void merge2SortedArrays(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();

        int i = low;
        int j = mid + 1;

        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }

        // fill remaining elements from either of array.
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }

        while(j <= high){
            temp.add(arr[j]);
            j++;
        }

        // put elms form temp to original arr
        for( int k =0; k<= temp.size()-1; k++){
            arr[k+low] = temp.get(k);
        }

    }
}


/*
public void merge2SortedArrays(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;

        int ind = 0; // to track temp index.
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[ind] = arr[i];
                ind++;
                i++;
            }
            else{
                temp[ind] = arr[j];
                ind++;
                j++;
            }
        }

        // fill remaining elements from either of array.
        while(i <= mid){
            temp[ind] = arr[i];
            i++;
            ind++;
        }

        while(j <= high){
            temp[ind] = arr[j];
            j++;
            ind++;
        }

        // put elms form temp to original arr
        for( int k =0; k<= temp.length-1; k++){
            arr[k+low] = temp[k];
        }

    }
 */
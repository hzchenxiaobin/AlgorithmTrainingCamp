package ch2.快速排序;

public class QuickSort {

    private void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = partition(arr, low, high);
            sort(arr, low, mid - 1);
            sort(arr, mid + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        //选取第一个作为基准数
        int pivot = arr[low];
        int i=low, j=high;
        while(i < j) {
            while(i < j && arr[j] > pivot) j--;
            while(i < j && arr[i] <= pivot) i++;
            if(i < j) {
                swap(arr, i, j);
            }
        }

        if(arr[i] > pivot) {
            i--;
        }
        swap(arr, i, low);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

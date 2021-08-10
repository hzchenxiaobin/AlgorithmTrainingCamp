public class MergeSort {
    public void sort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int length = high - low + 1;
        int[] mergeArr = new int[length];

        int i=low,j=mid+1, index=0;
        while(i <= mid && j <= high) {
            if(arr[i] >= arr[j]) {
                mergeArr[index++] = arr[j];
                j++;
            } else {
                mergeArr[index++] = arr[i];
                i++;
            }
        }

        while(i<=mid) mergeArr[index++] = arr[i++];
        while(j<=high) mergeArr[index++] = arr[j++];

        for(i=low, index=0;i<=high;i++) {
            arr[i] = mergeArr[index++];
        }
    }



}

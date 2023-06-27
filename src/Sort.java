class Sort {
    public static void mergeSort (int[] arr, int left, int right){
        if(left<right){
        int mid = (right+left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    }

    public static void QuickSortH (int[] arr, int left, int right){
        if(left<right){
            int pi = partionH(arr,left,right);
            QuickSortH(arr,left,pi-1);
            QuickSortH(arr,pi+1,right);
        }
    }

    private static int partionH(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left-1, j = right+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void QuickSort (int[] arr, int left, int right){
        if(left<right){
            int pi = partion(arr,left,right);
            QuickSort(arr,left,pi-1);
            QuickSort(arr,pi+1,right);
        }
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static int partion(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left-1;
        for(int j = 0 ;j < right -1 ; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid+1-left;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i <n1; i++ ){
            leftArr[i] = arr[left + i];
        }

        for(int i = 0; i <n2; i++ ){
            rightArr[i] = arr[mid+i+1];
        }
        int i = 0, j = 0, k = left;
        while(i<n1 && j<n2){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(j<n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        while(i<n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] unsorted = {2,5,1,7,8,4};
        for(int i = 0;i<unsorted.length;i++)
            System.out.print(unsorted[i] + "->");
        System.out.println();
        //QuickSortH(unsorted,0,5);
        mergeSort(unsorted,0,5);
        for(int i = 0;i<unsorted.length;i++)
            System.out.print(unsorted[i] + "->");
    }
}
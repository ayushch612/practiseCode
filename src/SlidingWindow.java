public class SlidingWindow {
    public int maximumSumSubarrayOfSizeK(int[] arr, int k){
        int n = arr.length;
        int sum = arr[0];
        int maxSum;
        for(int i = 1 ; i < k ; i++){
            sum+=arr[i];
        }
        maxSum = sum;
        for(int j = k ; j < n ; j++){
            sum+=arr[j];
            sum-=arr[j-k];
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] matrix = {1,0,1};

        SlidingWindow sw = new SlidingWindow();
        System.out.println(sw.maximumSumSubarrayOfSizeK(matrix, 2));
    }
}

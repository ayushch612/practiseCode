
public class Array2D {
    public static void printSpiral(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;
        int rs = 0,re = rows - 1;
        int cs = 0, ce = columns - 1;
        while(cs <= ce && rs <= re){
            for(int i = cs;i < ce; i++){
                System.out.println(arr[rs][i]);
            }
            for(int i = rs ; i < re ; i++){
                System.out.println(arr[i][ce]);
            }
            for(int i = ce ; i > cs ; i--){
                System.out.println(arr[re][i]);
            }
            for(int i = re ; i > rs; i--){
                System.out.println(arr[i][cs]);
            }
            cs++;ce--;rs++;re--;
        }
    }

    public static void rotation(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int rs = 0, re = rows - 1;
        int cs = 0, ce = columns - 1;
        while (cs <= ce && rs <= re) {
            int temp = arr[rs+1][cs],temp2;
            for (int i = cs; i < ce; i++) {
                temp2 = arr[rs][i];
                arr[rs][i] = temp;
                temp = temp2;
                //System.out.println(arr[rs][i]);
            }
            for (int i = rs; i < re; i++) {
                temp2 = arr[i][ce];
                arr[i][ce] = temp;
                temp = temp2;
                //System.out.println(arr[i][ce]);
            }
            for (int i = ce; i > cs; i--) {
                temp2 = arr[re][i];
                arr[re][i] = temp;
                temp = temp2;
                //System.out.println(arr[re][i]);
            }
            for (int i = re; i > rs; i--) {
                temp2 = arr[i][cs];
                arr[i][cs] = temp;
                temp = temp2;
                //System.out.println(arr[i][cs]);
            }
            cs++;ce--;rs++;re--;
        }
    }
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
        rotation(A);
        printSpiral(A);

    }
}

public class DFS {
    private int rows;
    private int columns;
    private int[][] grid;

    private boolean[][] visited;
    public DFS(int[][] matrix){
        rows = matrix.length;
        columns = matrix[0].length;
        grid = matrix;
        visited = new boolean[rows][columns];
    }

    private void traversal(int row, int col){
       if(row >= rows || row < 0 || col >= columns || col < 0 || visited[row][col] || grid[row][col] != 1){
           return;
       }
       visited[row][col] = true;

       if(grid[row][col] == 1){
           System.out.print("{" + row + "," + col + "} -> ");
       }
       traversal(row - 1,col);
       traversal(row,col-1);
       traversal(row+1,col);
       traversal(row,col+1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };

        DFS dfs = new DFS(matrix);
        dfs.traversal(0, 0); // Start DFS from cell (0, 0)
    }
}

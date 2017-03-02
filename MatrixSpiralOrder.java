public class MatrixSpiralOrder {
    public static void main(String[] args){
        int[][] matrix = new int[][]{
            {33,29,-15,-20,-41,-1,34,20,-41,44},
            {14,-11,-27,-35,29,-14,34,-41,49,19},
            {-12,-44,44,-43,-13,-6,40,-24,-6,8},
            {-40,4,27,2,2,15,38,4,-13,15},
            {-42,3,5,10,15,34,-18,-22,9,38}
        };
        int[] resultArray = matrixElementsInSpiralOrder(matrix);
        StringBuilder builder = new StringBuilder();
        for (int data : resultArray){
            builder.append(data).append(",");
        }
        System.out.println(builder.deleteCharAt(builder.length()-1));
    }
    
    // Return array with matrix elements in spiral order
    static int[] matrixElementsInSpiralOrder(int[][] matrix) {
        int rowlen = matrix.length;
        // Return empty array if row length is 0
        int[] r = new int[]{};
        if(rowlen == 0){
            return r;
        }
        // Return the first row if there is only one row
        int collen = matrix[0].length;
        if (rowlen == 1 && collen == 1) {
            return matrix[0];
        }
        // Total number of elements
        int n = rowlen*collen;
        r = new int[n];
        
        // Starts at leftTop position
        int rightTop = 0, rightBottom = 0, leftTop = 1, leftBottom = 0;
        
        // Array index variables 
        int i = 0, j = 0, c = 0;
        
        // Run the loop till length of result array is equal to the total number of elements in matrix
        while (c < n) {
            // Move right
            if (leftTop > 0) {
                while (j<collen-rightTop && c<n) {
                    r[c++] = matrix[i][j++];
                }
                j--;
                i++;
                rightTop++;
                
            }    
            // Move down
            if (rightTop > 0) {
                while (i<rowlen-rightBottom && c<n) {
                    r[c++] = matrix[i++][j];
                }
                rightBottom++;
                i--;
                j--;
            }
            // Move left
            if (rightBottom > 0) {
                while (j>=leftBottom && c<n) {
                    r[c++] = matrix[i][j--];
                }
                leftBottom++;
                j++;
                i--;
            } 
            // Move up
            if (leftBottom > 0) {
                while (i>=leftTop && c<n) {
                    r[c++] = matrix[i--][j];
                }
                leftTop++;
                i++;
                j++;
            }  
        }
        return r;
    } // End of method

}
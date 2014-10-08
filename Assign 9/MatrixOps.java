
public class MatrixOps {

    public static double[][] multiply(double[][] matrix1, double[][] matrix2)
    {
            int m1Rows = matrix1.length,
                          m1Columns = matrix1[0].length,
                          m2Rows = matrix2.length,
                          m2Columns = matrix2[0].length;
                       
                      if (m1Columns != m2Rows) {
                        return null;
                      }
                       
                      double[][] result = new double[m1Rows][m2Columns];
                       
                      for(int i = 0; i < m1Rows; i++) { 
                        for(int j = 0; j < m2Columns; j++) { 
                          for(int x = 0; x < m1Columns; x++) {
                            result[i][j] += matrix1[i][x] * matrix2[x][j];
                          }
                        }  
                      }
                       
                      return result;
                    }	
}

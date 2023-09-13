/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konvolusicitra;

public class KernelMask {
    
    private final int[][] boxFilter = new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };
    
    private final int[][] averagingFilter = new int[][]{
        {1, 2, 1},
        {2, 4, 2},
        {1, 2, 1}
    };
    
    private final int[][] highpassFilter = new int[][]{
        {0, -1, 0},
        {-1, 5, -1},
        {0, -1, 0}
    };
    
    private final int[][] laplacianFilter = new int[][]{
        {0, 1, 0},
        {1, -4, 1},
        {0, 1, 0}
    };
    
    
    int[][] getMask(String type){
        if(type.equalsIgnoreCase("Laplacian Filter")){
            return laplacianFilter;
        } else if(type.equalsIgnoreCase("Averaging Filter")){
            return averagingFilter;
        } else if(type.equalsIgnoreCase("Box Filter")){
            return boxFilter;
        } else if(type.equalsIgnoreCase("High-pass Filter")){
            return highpassFilter;
        } else return laplacianFilter;
    }
}

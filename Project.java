/* You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.
Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j). We view the projection of 
these cubes onto the xy, yz, and zx planes. A projection is like a shadow, that maps our 3-dimensional figure to a 
2-dimensional plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
Return the total area of all three projections.
* Eg 1 :  grid = [[1,2],[3,4]]         Projection = 17 
* Eg 2 :  grid = [[2]]                 Projection = 5  
* Eg 3 :  grid = [[1,0],[0,2]]         Projection = 8  
*/
import java.util.*;
public class Project
{
      public int ProjectionSum(int grid[][])
      {
            int xyPlane = grid.length * grid[0].length;   // Calculating the XY-Plane projection...
            for(int i = 0; i < grid.length; i++)     //! Grid Iteration for XY-Plane -> O(N x M)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        if(grid[i][j] == 0)
                              xyPlane--;
                  }
            }
            int yzPlane = 0, xzPlane = 0, sum = 0;     //* Variable Declration -> O(1)
            for(int i = 0; i < grid[0].length; i++)    //! Grid Iteration fot YZ-Plane -> O(N x M)
            {
                  int max = Integer.MIN_VALUE;
                  for(int j = 0; j < grid.length; j++)
                        max = Math.max(max, grid[j][i]);    // Taking maximum vertically...
                  sum += max;    // Summing projection of YZ-Plane...
            }
            yzPlane = sum;
            System.out.println(yzPlane);
            sum = 0;
            for(int i = 0; i < grid.length; i++)     //! Grid Iteration for XZ-Plane -> O(N x M)
            {
                  int max = Integer.MIN_VALUE;
                  for(int j = 0; j < grid[0].length; j++)
                        max = Math.max(max, grid[i][j]);    // Taking maximum horizontally...
                  sum += max;      // Summing projection of XZ-Plane...
            }
            xzPlane = sum;
            System.out.println(xzPlane);
            return xyPlane + yzPlane + xzPlane;    // Returning Sum of all the Projections...
      }
      public void DisplayGrid(int grid[][])
      {     //! Displaying the Grid -> O(N x M)
            System.out.println("The Grid formed : ");
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                        System.out.print(grid[i][j]+", ");
                  System.out.println();
            }
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Ënter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter state of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            Project project = new Project();      // Object creation...
            project.DisplayGrid(grid);        // Function calling...
            System.out.print("Total Projection of the 3D Grid : "+project.ProjectionSum(grid));
            sc.close();
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(1)
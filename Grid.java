
public class Grid {
	
/**
 Grid Class is basically used for Sudoku Solving. Here the Matrix[9][9]
 is initially given.
 
 	
 * @param grid
 * @return
 */
	
	/**
	 * 
	i is the row number
	j is the column number.
	value is the value between 1 to 9 
	 methodCheck()
 is a booean method which is doing the main functionality	 
	 * @param grid
	 * @return
	 */

	public static  boolean methodCheck(int[] []grid){

		for(int i=0;i<9;i++){

			for(int j=0;j<9;j++){
				
				if(grid[i][j]!=0){
					continue;
				}

				else
				{
					int value=1;
					while(value<10){

						Boolean rowBoolean=rowCheck(i,value,grid);
						Boolean colBoolean=columnCheck(j,value,grid); 	
						Boolean gridBoolean = gridCheck(i,j,value,grid);
						
						if(rowBoolean==true && colBoolean==true && gridBoolean==true){
							grid[i][j]=value;
							
							if(methodCheck(grid))
								return true;
							grid[i][j]=0;
						}
						value++;

					}
					return false;

				}


			}
		}
		return true;

	}

	/**
	 GridCheck Method is used for checking 3*3 matrix.
	  
	 
	 * @param i
	 * @param j
	 * @param value
	 * @param grid
	 * @return
	 */
	
	private static boolean gridCheck(int i,int j,int value,int[][]grid) {
		// TODO Auto-generated method stub
		int x1 = 3 * ( i/ 3);
		int y1 = 3 * (j / 3);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++){
			for (int y = y1; y <= y2; y++)
			{
				if (grid[x][y] == value)
				{
					return false;
				}
			}
		}

		return true;


	}
/**
 
ColumnCheck method is used for checking the column specified 
 
 * @param j
 * @param value
 * @param grid
 * @return
 */

	private static boolean columnCheck(int j,int value,int[][]grid) {
		int i=0;
		while(i<9){
			if(grid[i][j]==value){
				return false;
			}
			i++;
		}

		return true;
		// TODO Auto-generated method stub

	}
	
	/**
	 RowCheck is used for Checking the specified row 
	 
	  
	 * @param i
	 * @param value
	 * @param grid
	 * @return
	 */

	public static  boolean rowCheck(int i,int value,int[][]grid){

		int j=0;


		while(j<9 )
		{
			if(grid[i][j]==value){
				return false;
			}
			j++;
		}


		return true;
	}
	/**
	 * 
	Inside  Main Method the grid is initialized with some numbers.
	 
	 
	 * @param args
	 */
	
	public static void main(String args[]){
		int[][]  grid=

			  { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if(methodCheck(grid))
		{
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				//System.out.println("The new Grid is ");
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
		}
		else
			System.out.println("solution not found");
	}
}
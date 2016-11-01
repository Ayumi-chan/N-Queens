public class Queens {
	public char[][] board;
	private int size;

	public Queens(int size) 
	{
		this.size = size;
		
		board = new char[size][size];
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				board[i][j] = '!';
			}
		}
	}

	public void get() 
	{
		if(placeQueens(0))
		{
			printBoard();
		}
		else
		{
			System.out.println("no solution");
		}
	}
	
	public void printBoard()
	{
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++) 
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean placeQueens(int q)
	{
		if(q==size)
		{
			return true;
		}
		for (int n = 0; n < size; n++) 
		{
			if (canPlace(n, q))
			{
				board[n][q] = 'Q';
				if(placeQueens(q+1))
				{
					return true;
				}
				board[n][q]= '!';
			}
		}
		return false;

	}
	
	public boolean canPlace(int r, int c) {

		for (int i = 0; i < c; i++)
		{
			if (board[r][i] == 'Q')
			{
				return false;
			}
		}

		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j] == 'Q') 
			{
				return false;
			}
		}

		for (int i = r, j = c; i < board.length && j >= 0; i++, j--) 
		{
			if (board[i][j] == 'Q')
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		
		new Queens(19).get();

	}

}
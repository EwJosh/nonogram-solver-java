package nonogramSolver;

import java.util.ArrayList;

public class NonoKey
{
	public NonoKey(ArrayList<Integer> key)
	{
		this.key = key;
		
	}
	
	/**
	 * Checks whether the key does not exceed the width/height of the board
	 * 
	 * @param maxLength
	 * @return
	 * @throws NonoKeySizeException
	 */
	public boolean isValid(int maxLength) throws NonoKeySizeException {
		int sum = 0;
		for(Integer i: key)
		{
			sum += i;
			
			// Count for at least one blank between filled tiles
			if(key.indexOf(i)!=1)
				sum++;
			// Throw exception if sum ever exceeds board's size
			if(sum>maxLength)
				throw new NonoKeySizeException("Key exceeds");
		}
		return true;
	}
	
	private ArrayList<Integer> key;
}

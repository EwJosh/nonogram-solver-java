package nonogramSolver;

import java.util.ArrayList;

public class NonoKey
{
	public NonoKey() {
		this.key = new ArrayList<Integer>(1);
		this.key.add(0);
	}
	
	public NonoKey(ArrayList<Integer> key)
	{
		this.key = key;
	}
	
	public NonoKey(int[] key)
	{
		this.key = new ArrayList<Integer>(key.length);
		for(int i: key)
			this.key.add(i);
	}
	
	public Integer get(int index){
		return this.key.get(index);
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
		for(Integer i: this.key)
		{
			sum += i;
			
			// Count for at least one blank between filled tiles
			if(this.key.indexOf(i)!=1)
				sum++;
			// Throw exception if sum ever exceeds board's size
			if(sum>maxLength)
				throw new NonoKeySizeException("Key exceeds");
		}
		return true;
	}
	
	private ArrayList<Integer> key;
}

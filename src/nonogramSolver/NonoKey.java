package nonogramSolver;

import java.util.ArrayList;

public class NonoKey
{
	public NonoKey() {
		this.key = new ArrayList<Integer>(1);
		this.key.add(0);
		this.isComplete = false;
	}
	
	public NonoKey(ArrayList<Integer> key)
	{
		this.key = key;
		this.isComplete = false;
	}
	
	public NonoKey(int[] key)
	{
		this.key = new ArrayList<Integer>(key.length);
		for(int i: key)
			this.key.add(i);
		this.isComplete = false;
	}
	
	public Integer get(int index){
		return this.key.get(index);
	}
	
	public int size() {
		return this.key.size();
	}
	
	/**
	 * 
	 * @return raw total sum of key values
	 */
	public int getSum() {
		int sum = 0;
		for(Integer i: this.key) {
			sum += i;
		}
		return sum;
	}
	
	public boolean isComplete() {
		return this.isComplete;
	}
	
	/**
	 * Checks whether the key does not exceed the width/height of the board
	 * 
	 * @param maxLength length of the corresponding line
	 * @return true if key is valid
	 * @throws NonoKeySizeException
	 */
	public boolean checkValid(int maxLength) throws NonoKeySizeException {
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
	
	/**
	 * Sets the value isComplete to true.
	 */
	public void complete() {
		this.isComplete = true;
	}
	
	private ArrayList<Integer> key;
	private boolean isComplete;
}


public interface Ekvivalensrelationer {
	
	/**
	 * Union the sets containing a and b
	 * @param a
	 * @param b
	 */
	public void union(int a, int b);
	/**
	 * Check if a and b are in the same set. Returns true if they are.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean same(int a, int b);
	
	/**
	 * Moves a from its own set to the set of b.
	 * 
	 * @param a
	 * @param b
	 */
	public void move(int a, int b);
	
	/**
	 * Create a set containing a
	 * 
	 * @param a
	 */
	public void makeSet(int a);
	
	/**
	 * Finds the set containing a
	 * 
	 * @param a
	 * @return
	 */
	public int find(int a);
}

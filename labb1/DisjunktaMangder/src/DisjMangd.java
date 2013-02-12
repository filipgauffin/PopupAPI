
/**
 * 
 * @author Filip Gauffin, filipgau@kth.se; Andreas Brytting, brytting@kth.se
 *
 * Operations on disjoint sets p.
 *
 */
public class DisjMangd implements Ekvivalensrelationer{
	
	private int[] p;
	private int[] rank;
	
	/**
	 * 
	 * @param elem
	 */
	public DisjMangd(int elem){
		p = new int[elem];
		rank = new int[elem];
	}

	/**
	 * Union the sets containing a and b
	 * @param a
	 * @param b
	 */
	@Override
	public void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x != y){
			link(x, y);
		}
	}
	/**
	 * Check if a and b are in the same set. Returns true if they are.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@Override
	public boolean same(int a, int b) {
		if(find(a) == find(b)){
			return true;
		}
		return false;
	}
	/**
	 * Moves a from its own set to the set of b.
	 * 
	 * @param a
	 * @param b
	 */
	@Override
	public void move(int a, int b) {
		// TODO Auto-generated method stub
		int x = find(a);
		int y = find(b);
		if(x != y){
			link(x, y);
		}
	}
	/**
	 * Create a set containing a
	 * 
	 * @param a
	 */
	@Override
	public void makeSet(int a) {
		p[a] = a;
	}
	/**
	 * Finds the set containing a
	 * 
	 * @param a
	 * @return
	 */
	@Override
	public int find(int a) {
		if(p[a] != a){
			p[a] = find(p[a]);
		}
		return p[a];
	}
	/**
	 * Link node a to b, the node with the smallest rank becomes child.
	 * 
	 * @param a
	 * @param b
	 */
	private void link(int a, int b) {
		if(rank[a] < rank[b]){
			p[a] = b;
		}
		else{
			p[b] = a;
			if(rank[a] == rank[b]){
				rank[a]++;
			}
		}
	}
}

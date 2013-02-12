
/**
 * 
 * @author Filip Gauffin, filipgau@kth.se
 *
 * Holds the prefixsum-representation of an array.
 * Supports insertion (change of element) and sum of all 
 * elements with smaller index then some given index.
 *
 * The array is used as a fenwick tree where even nodes 0, 2, ...  are the leaves holding
 * the real value for the those indices in the original array.
 * The odd indices hold a subset sum over the array. This means adding and getting sum
 * only requires lookup/alteration of a subset of the array equal to the height of the tree, O(logn)
 * 
 */
public class PrefixSum {
	private int[] i;
	private int counter = 0;
	
	/**
	 * New PrefixSum using array i
	 * 
	 * @param i
	 */
	public PrefixSum(int[] i){
		this.i = i;
	}
	/**
	 * New PrefixSum with array of length size
	 * 
	 * @param size
	 */
	public PrefixSum(int size){
		i = new int[size];
	}
	/**
	 * Add element elem to array in next available spot
	 * 
	 * @param elem
	 */
	public void addElem(int elem){
		i[counter] = elem;
		counter++;
	}
	/**
	 * Add delta to int at position last by updating each dependent node in the tree
	 * 
	 * @param last
	 * @param delta
	 */
	public void add(int last, int delta){
		while(last < i.length){
			i[last] += delta;
			last = last | (last + 1);
		}
	}
	/**
	 * Sum each number starting from given last index (excluding) to first element in the list.
	 * 
	 * @param last
	 * @return
	 */
	public int sum(int last){
		int sum = 0;
		last--;
		while(last >= 0){
			sum += i[last];
			last = (last & (last + 1)) - 1;
		}
		return sum;
	}
}
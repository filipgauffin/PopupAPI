import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 * @author Filip Gauffin, filipgau@kth.se
 *
 * Reads lists from stdin and finds the longset increasing subsequence of each list.
 * The resulting indices of the subsequences are printed to stdout.
 *
 */
public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		//Kattio io = new Kattio(new FileInputStream("test/test"), System.out);
		Kattio io = new Kattio(System.in, System.out);
		
		//long time = System.currentTimeMillis();
		
		int n;
		int[] numbers;
		while(io.hasMoreTokens()){
			n = io.getInt();
			
			numbers = new int[n];
			for(int i = 0; i < n; i++){
				numbers[i] = io.getInt();
			}
			numbers = IncSubseq.lis(numbers);
			
			io.println(numbers.length);
			for(int i = 0; i < numbers.length; i++){
				io.print(numbers[i] + " ");
			}
			io.println();
		}
		
		//System.out.println("Time: " + (System.currentTimeMillis() - time));
		
		io.close();
		
	}
}

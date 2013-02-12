import java.io.FileInputStream;

/**
 * 
 * @author Filip Gauffin, filipgau@kth.se
 *
 * Creates a list with size read from stdin and all values zero. On this list 
 * two operations are supported, + for altering a value and ? for requesting the 
 * sum of all elements up to this index.
 */
public class Main {
	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
		Kattio io = new Kattio(new FileInputStream("test/test"), System.out);
		//Kattio io = new Kattio(System.in, System.out);
		
		int numbers = io.getInt();
		int ops = io.getInt();
		PrefixSum ps = new PrefixSum(numbers);
		
		for(int i = 0; i < ops; i++){
			String token = io.getWord();
			
			if(token.equals("+")){
				ps.add(io.getInt(), io.getInt());
			}
			else if(token.equals("?")){
				io.println(ps.sum(io.getInt()));
			}
			else{
				io.close();
				throw new Exception("Invalid input command");
			}
		}
		io.close();
	}
}
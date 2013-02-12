import static org.junit.Assert.*;

import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

public class FenwickTreeTest
{

        @Test
        public void testSimpleAdd()
        {
                PrefixSum ft = new PrefixSum(256);
                ft.add(1, 1);
                Assert.assertEquals(1, ft.sum(1+1));
        }
        
        @Test
        public void testSimpleAddAtZeroPosition()
        {
                PrefixSum ft = new PrefixSum(256);
                ft.add(0, 1);
                Assert.assertEquals(1, ft.sum(0+1));
        }

        @Test
        public void testMulipleAdd()
        {
                PrefixSum ft = new PrefixSum(256);
                ft.add(1, 1);
                ft.add(1, 1);
                Assert.assertEquals(2, ft.sum(1+1));
        }

        @Test
        public void testMulipleAddToMulipleValues()
        {
                PrefixSum ft = new PrefixSum(256);
                ft.add(0, 1);
                ft.add(1, 1);
                ft.add(1, 1);
                ft.add(2, 1);
                Assert.assertEquals(3, ft.sum(1+1));
                Assert.assertEquals(4, ft.sum(2+1));
                Assert.assertEquals(4, ft.sum(3+1));
        }

        @Test
        public void testLargeNumberOfAdds()
        {
                PrefixSum ft = new PrefixSum(256);
                int sum = 0;
                for (int i = 0; i != 10; ++i)
                {
                        sum += i;
                        ft.add(1, i);
                        ft.add(2, i);
                }
                Assert.assertEquals(sum, ft.sum(1+1));
                Assert.assertEquals(sum * 2, ft.sum(2+1));
        }

        @Test
        public void testGetIndividualFrequency()
        {
                PrefixSum ft = new PrefixSum(256);
                ft.add(0, 1);
                ft.add(1, 1);
                ft.add(1, 1);
                ft.add(2, 1);
                ft.add(9, 4);
                //Assert.assertEquals(2, ft.getFrequency(1));
                //Assert.assertEquals(1, ft.getFrequency(2));
        }

        @Test
        public void findElementCorrespondingToACumulativeFreq()
        {
                PrefixSum ft = new PrefixSum(10);
                ft.add(0, 1);
                ft.add(1, 2);
                ft.add(2, 4);
                ft.add(3, 8);
                ft.add(4, 11);
                ft.add(5, 100);

                // just making sure
                Assert.assertEquals(1 + 2 + 4 + 8 + 11 + 100, ft.sum(5+1));
/*
                Assert.assertEquals(1, ft.indexOfCumulativeFrequency(2));
                Assert.assertEquals(2, ft.indexOfCumulativeFrequency(2 + 4));
                Assert.assertEquals(3, ft.indexOfCumulativeFrequency(2 + 4 + 8));
                Assert.assertEquals(4, ft.indexOfCumulativeFrequency(2 + 4 + 8 + 11));
                // NOTE: 8 instead of 5 because that's where the algorithm puts it
                Assert.assertEquals(8, ft.indexOfCumulativeFrequency(2 + 4 + 8 + 11 + 100));
*/
        }
        
        @Test
        public void verifyZeroes() throws Exception
        {
                PrefixSum ft = new PrefixSum(10);

                ft.add(0, 10);
                Assert.assertEquals(10, ft.sum(0+1));
                //Assert.assertEquals(10, ft.getFrequency(0));
        }

        @Test
        public void testRescaling()
        {
                PrefixSum ft = new PrefixSum(10);

                ft.add(0, 10);
                ft.add(1, 2);
                ft.add(2, 4);
                ft.add(3, 8);
                ft.add(4, 100);
                ft.add(5, 124);

                // before rescaling
                /*
                Assert.assertEquals(10, ft.getFrequency(0));
                Assert.assertEquals(2, ft.getFrequency(1));
                Assert.assertEquals(4, ft.getFrequency(2));
                Assert.assertEquals(8, ft.getFrequency(3));
                Assert.assertEquals(100, ft.getFrequency(4));
	*/
                // rescale
                //ft.rescale(2);

                // measure after rescaling
                /*
                Assert.assertEquals(1, ft.getFrequency(1));
                Assert.assertEquals(2, ft.getFrequency(2));
                Assert.assertEquals(4, ft.getFrequency(3));
                Assert.assertEquals(50, ft.getFrequency(4));
                Assert.assertEquals(124 / 2, ft.getFrequency(5));
        		*/
        }
        private int length = 10;
        private int maxVal = 190000000;
        @Test
        public void testRandom(){
        	PrefixSum pf = new PrefixSum(length+1);
        	int[][] ops = rlist();
        	int[] l = new int[length];
        	
        	for(int i = 0; i < ops[0].length; i++){
        		pf.add(ops[0][i], ops[1][i]);
        		add(l, ops[0][i], ops[1][i]);
        		if(i%1000000 == 0){
        			System.out.println(i);
        		}
        		for(int j = 0; j < length+1; j++){
        			Assert.assertEquals(sum(l, j), pf.sum(j));
        		}
        	}
        }
        public int[][] rlist(){
        	int n = maxVal;
        	Random r = new Random();
        	int[][] l = new int[2][n];
        	
        	for(int i = 0; i < n; i++){
        		l[0][i] = r.nextInt(length);
        		l[1][i] = r.nextInt()%1000000000;
        	}
        	return l;
        }
        public int sum(int[] l, int last){
        	int sum = 0;
        	for(int i = 0; i < last; i++){
        		sum += l[i];
        	}
        	return sum;
        }
        public void add(int[] l, int last, int delta){
        	l[last] += delta;
        }

}
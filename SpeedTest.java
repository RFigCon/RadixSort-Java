class SpeedTest{
	
	private static final long ITERATIONS = 100000;
	private static final int SIZE = 10000;
	
	private static int[] toSort;
	
	public static void main(String[] args){
		
		long start, finish, delta, delta2;
		
		toSort = new int[SIZE];
		
		setToSort();
		Radix.LSD(toSort);
		Radix2.LSD(toSort);  //Same as Radix class but using "OldRadix"'s method to check when to stop sorting
		
		delta = 0;
		delta2 = 0;
		for(int i = 0; i<ITERATIONS; i++){
			
			setToSort();
			
			start = System.nanoTime();
			Radix2.LSD(toSort);
			finish = System.nanoTime();
			delta += finish-start;
			
			start = System.nanoTime();
			Radix.LSD(toSort);
			finish = System.nanoTime();
			delta2 += finish-start;
		}
		delta /= ITERATIONS;
		delta2 /= ITERATIONS;
		System.out.println( delta + "\n" + delta2);
		
	}
	
	private static void setToSort(){
		for(int i = 0; i<SIZE; i++){
			toSort[i] = (int)(Math.random()*10000);
		}
	}
	
}
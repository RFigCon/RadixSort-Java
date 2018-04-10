public class TestSort{
	
	public static void main(String[] args){
		int[] n = {1001, 12, 2, 44, 17, 38, 27, 9, 33 };
		//int[] n = { 200, 11, 5, 9, 3 };
		//int[] n = { 10, 17, 9, 14, 3, 2 , 0, 1 };
		//int[] n = { 37, 49, 48, 14, 13, 8 , 7, 11 };
		
		printArrayInLine(n);
		
		Radix.LSD(n);
		//printSeparator(n[n.length-1]);
		printSeparator(10);
		
		printArrayInLine(n);
		
	}
	
	private static void printSeparator(int x){
		if(x==0) x = 10;
		while(x>0){
			x--;
			
			System.out.print('#');
			
		}
		System.out.print('\n');
	}
	
	private static void printArrayInLine(int[] n){
		
		for(int i = 0; i<n.length; i++){
			
			for(int j = 0; j<n[i]; j++){
				System.out.print('.');
			}
			System.out.print(n[i]);
			System.out.print('\n');
		}
		
	}
	
}
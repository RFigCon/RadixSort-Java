public class TestSort{
	
	public static void main(String[] args){
		//int[] n = {2001, 1200, 2, 44, 17, 38, 27, 9, 33 };
		//int[] n = { 200, 11, 5, 9, 3 };
		//int[] n = { 10, 17, 9, 14, 3, 2 , 0, 1 };
		//int[] n = { 37, 49, 48, 14, 13, 8 , 7, 11 };
		int[] n = { -37, 49, -48, 14, 13, -8 , 7, -11, -112, 99, 108 };
		
		printArrayInLine(n);
		
		Radix.LSD(n,true);
		printSeparator(n[n.length-1]);
		//printSeparator(0);
		
		printArrayInLine(n);
		
	}
	
	private static void printSeparator(int x){
		
		if(x==0) x = 10;
		while(x-->0){
			System.out.print('#');
		}
		System.out.print('\n');
		
	}
	
	private static void printArrayInLine(int[] n){
		
		for(int i = 0; i<n.length; i++){
			int len = Math.abs(n[i]);
			for(int j = 0; j<len; j++){
				if(n[i]<0){
					System.out.print('-');
				}else{
					System.out.print('+');
				}
			}
			System.out.print(n[i]);
			System.out.print('\n');
		}
		
	}
	
}
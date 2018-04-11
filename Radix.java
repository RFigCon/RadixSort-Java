public class Radix{
	
	private static final short BUCKETS = 10;
	
	private static void resetBucket(int[] buckets, int bucketSize){
		
		for(short i = 0; i<BUCKETS; i++){
			buckets[i*bucketSize] = 0;
		}
		
	}
	
	public static void LSD(int[] n){
		
		if(n.length==0) return;
		
		int iterations = getRequiredIterations(n);
		int bucketSize = n.length+1;
		
		int[] buckets = new int[BUCKETS * bucketSize];
		
		int pos = 0;
		int mult = 1;
		do{
			resetBucket(buckets, bucketSize);
			
			//Inserting the values in the bucket
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				int indx = pos*bucketSize;
				buckets[ indx + (++buckets[indx]) ] = n[i];
			}
			
			//Getting the values back in the array
			for(int i = 0, j = 0; i<n.length && j<BUCKETS; j++){
				int k = j*bucketSize;
				int size = buckets[k];
				for(int x = 0; x<size; x++, i++){
					n[i] = buckets[k + x+1];
				}
			}
			
			mult *= 10;
		}while(mult<=iterations);
		
	}
	
	private static int getRequiredIterations(int[] n){
		int largest = 0;
		for(int i = 0; i<n.length; i++){
			
			if(n[i]>largest){
				largest = n[i];
			}
			
		}
		
		return largest;
	}
	
}
public class Radix{
	
	private static final short POS_BUCKETS = 10;
	private static final short NEG_BUCKETS = 19;
	private static final short OFFSET = 9;
	
	public static void LSD(int n[], boolean neg){
		
		if(n.length==0) return;
		
		if(neg) LSDneg(n);//Accounting for negative numbers makes the sorting much slower
		else LSDpos(n);
		
	}
	
	private static void resetPosBucket(int[] buckets, int bucketSize){
		
		for(short i = 0; i<POS_BUCKETS; i++){
			buckets[i*bucketSize] = 0;
		}
		
	}
	//Only sorts positive arrays
	public static void LSDpos(int[] n){
		
		int iterations = getLargest(n);
		int bucketSize = n.length+1;
		
		int[] buckets = new int[POS_BUCKETS * bucketSize];
		
		int pos = 0;
		int mult = 1;
		do{
			resetPosBucket(buckets, bucketSize);
			
			//Inserting the values in the bucket
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				int indx = pos* bucketSize;
				buckets[ indx + (++buckets[indx]) ] = n[i];
			}
			
			//Getting the values back in the array
			for(int i = 0, j = 0; i<n.length && j<POS_BUCKETS; j++){
				int k = j*bucketSize;
				int size = buckets[k];
				for(int x = 0; x<size; x++, i++){
					n[i] = buckets[k + x+1];
				}
			}
			
			mult *= 10;
		}while(mult<=iterations);
		
	}
	
	private static void resetNegBucket(int[] buckets, int bucketSize){
		
		for(short i = 0; i<NEG_BUCKETS; i++){
			buckets[i*bucketSize] = 0;
		}
		
	}
	//Also sorts array with negatives
	public static void LSDneg(int[] n){
		
		int iterations = getLargest(n);
		int bucketSize = n.length+1;
		
		int[] buckets = new int[NEG_BUCKETS * bucketSize];
		
		int pos = 0;
		int mult = 1;
		do{
			resetNegBucket(buckets, bucketSize);
			
			//Inserting the values in the bucket
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				int indx = (pos + OFFSET) * bucketSize;
				buckets[ indx + (++buckets[indx]) ] = n[i];
			}
			
			//Getting the values back in the array
			for(int i = 0, j = 0; i<n.length && j<NEG_BUCKETS; j++){
				int k = j*bucketSize;
				int size = buckets[k];
				for(int x = 0; x<size; x++, i++){
					n[i] = buckets[k + x+1];
				}
			}
			
			mult *= 10;
		}while(mult<=iterations);
		
	}
	
	private static int getLargest(int[] n){
		int largest = 0;
		for(int i = 0; i<n.length; i++){
			
			if(n[i]>largest){
				largest = n[i];
			}
			
		}
		
		return largest;
	}
	
}
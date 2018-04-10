import java.util.ArrayList;

public class Radix{
	
	private static final short BUCKETS = 10;
	
	private static ArrayList< int[] > bucket;
	private static int iterations = 10;
	
	private static void resetBucket(){
		
		for(short i = 0; i<BUCKETS; i++){
			bucket.get(i)[0] = 0;
		}
	}
	
	private static void setBucket(int len){
		for(short i = 0; i<BUCKETS; i++){
			bucket.add( new int[len+1] );
		}
	}
	
	public static void LSD(int[] n){
		
		if(n.length==0) return;
		
		int iterations = getRequiredIterations(n);
		
		bucket = new ArrayList<>();
		setBucket(n.length);
		
		int pos = 0;
		int mult = 1;
		do{
			resetBucket();
			
			//Inserting the values in the bucket
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				int size = ++bucket.get(pos)[0];      //This is only for readability
				bucket.get(pos)[ size ] = n[i];
			}
			
			//Getting the values back in the array
			int i = 0;
			int j = 0;
			while(i<n.length && j<BUCKETS){
				
				for(int x = 0; x<bucket.get(j)[0]; x++){
					
					n[i] = bucket.get(j)[x+1];
					i++;
				}
				j++;
			}
			
			mult *= 10;
		}while(mult<=iterations);
		
	}
	
	private static int getRequiredIterations(int[] n){
		int iterations = 10;
		for(int i = 0; i<n.length; i++){
			
			if(n[i]>iterations){
				iterations = n[i];
			}
			
		}
		return iterations;
	}
	
}
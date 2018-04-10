import java.util.ArrayList;

public class Radix{
	
	private static final short BUCKETS = 10;
	private static ArrayList< ArrayList<Integer> > bucket;
	
	private static void resetBucket(){
		for(short i = 0; i<BUCKETS; i++){
			bucket.get(i).clear();
		}
	}
	
	private static void setBucket(){
		for(short i = 0; i<BUCKETS; i++){
			bucket.add(new ArrayList<Integer>());
		}
	}
	
	public static void LSD(int[] n){
		
		
		bucket = new ArrayList<>();
		setBucket();
		
		int pos = 0;
		int mult = 1;
		boolean finished;
		do{
			finished = true;
			resetBucket();
			//Inserting the values in the bucket
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				bucket.get(pos).add(n[i]);
			}
			
			//Getting the values back in the array
			int i = 0;
			int j = 0;
			while(i<n.length && j<BUCKETS){
				
				for(int x = 0; x<bucket.get(j).size(); x++){
					
					n[i] = bucket.get(j).get(x);
					i++;
				}
				j++;
			}
			
			mult *= 10;
		}while(!isSorted(n,mult));
		
	}
	
	private static boolean isSorted(int[] n, int mult){
		
		for(int i = 0; i<n.length; i++){
			
			if(n[i]>mult){
				return false;
			}
			
		}
		
		return true;
	}
	
}
import java.util.ArrayList;

public class OldRadix{
	
	private static final short BUCKETS = 10;
	private static ArrayList< ArrayList<Integer> > buckets;
	
	private static void resetBucket(){
		for(short i = 0; i<BUCKETS; i++){
			buckets.get(i).clear();
		}
	}
	
	private static void setBucket(){
		for(short i = 0; i<BUCKETS; i++){
			buckets.add(new ArrayList<Integer>());
		}
	}
	
	public static void LSD(int[] n){
		
		
		buckets = new ArrayList<>();
		setBucket();
		
		int pos = 0;
		int mult = 1;
		do{
			resetBucket();
			//Inserting the values in the buckets
			for(int i=0; i<n.length; i++){
				pos = (n[i]%(mult*10))/mult;
				
				buckets.get(pos).add(n[i]);
			}
			
			//Getting the values back in the array
			int i = 0;
			int j = 0;
			while(i<n.length && j<BUCKETS){
				
				for(int x = 0; x<buckets.get(j).size(); x++){
					
					n[i] = buckets.get(j).get(x);
					i++;
				}
				j++;
			}
			
			mult *= 10;
		}while(!isSorted(n));
		
	}
	
	private static boolean isSorted(int[] n){
		
		for(int i = 1; i<n.length; i++){
			
			if(n[i]<n[i-1]){
				return false;
			}
			
		}
		
		return true;
	}
	
}
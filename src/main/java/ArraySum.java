
public class ArraySum {
	
	public static void main(String[] args) {
		int[] array1= {1,3,2,6,74};
		
		for(int i=0;i<array1.length;i++) {
			if((array1[0]+array1[i+1]==7) && (i<array1.length)) {
				
				System.out.println(array1[0]);
				System.out.println(array1[i+1]);
				
			}
			else {
				System.out.println("Not found");
			}
		}
	}

}

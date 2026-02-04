
public class Patterns {
	
	public static void main(String[] args) {
		
		System.out.println("Patterns");
		
		for(int i=1;i<6;i++) {
			for(int j=1;j<=i;j++) {
			
			System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i=1;i<3;i++) { //i=1 
			//i=1
			//i=2
			//i=3 
			for(int j=3;j>=i;j--) {
				
				//3>1  ***
				//2>1 
				//1>=1 
				
				//2nd iteration
				//j=3   3>=2  **
				//j=2   2>=2
				//j=1   1>=2
				
				
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		
		
	}

}

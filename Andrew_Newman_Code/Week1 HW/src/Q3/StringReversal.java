package Q3;

public class StringReversal {
	
	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder("Revature");
		System.out.println("Original string: "+ s);
		int stringLength = s.length();
		
		for(int i=8;i>=0;i--) {
			if(i==0) {continue;}
			char currChar = s.charAt(i-1);
			s.append(currChar);
		}
		
		s.delete(0, stringLength);
		System.out.println("Reversed String: " + s);
	}
	
}

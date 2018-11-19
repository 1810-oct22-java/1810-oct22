package question11;

import question11helper.DifferentPackage;

public class AccessDifferentPackage {
	
	public static void main(String[] args) {
		
		DifferentPackage dp = new DifferentPackage();
		System.out.println(dp.getHidden1() + " " + dp.getHidden2());
	}
	
}

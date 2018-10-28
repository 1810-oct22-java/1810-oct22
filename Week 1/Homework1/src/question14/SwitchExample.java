package question14;

import java.time.LocalDateTime;

public class SwitchExample {
	
	public static void main(String[] args) {
		int switchNum = 2;
		switch(switchNum) {
		case 1:
			System.out.println(Math.sqrt(36));
			break;
		case 2:
			System.out.println(LocalDateTime.now());
			break;
		case 3:
			String core = "I am learning Core Java";
			String[] arr = core.split(" ");
			for(int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		default:
			System.out.println("non applicable");
		}
	}
	
}

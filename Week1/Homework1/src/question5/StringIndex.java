package question5;

public class StringIndex {
	public static void main(String[] args) {
		StringIndex si = new StringIndex();
		System.out.println(si.getSubString("get the substring Plz", 8));
	}
	public String getSubString(String str, int idx) {
		String smallerString = "";
		for(int i = 0; i < idx; i++) {
			smallerString += str.charAt(i);
		}
		return smallerString;
	}
}

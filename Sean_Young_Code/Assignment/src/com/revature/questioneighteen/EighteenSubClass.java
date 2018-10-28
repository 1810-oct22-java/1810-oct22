package com.revature.questioneighteen;
//EighteenSubClass is a child class of the parent class QuestionEighteenSuper
public class EighteenSubClass extends QuestionEighteenSuper {
	
	public static void main(String[] args) {
		EighteenSubClass e = new EighteenSubClass(); // instantiates class EighteenSubClass as an object
		e.capitalLetters();
		e.lowercaseToCapital();
		e.stringToInt();
	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questioneighteen.QuestionEighteenSuper#capitalLetters()
	 * capitalLetters counts the number of Upper Case letters in a string. it loops through the letters
	 * of each string and uses the Character.isUpperCase method to see if the character of the string
	 * is upper case. If it is upper case it adds 1 to the static variable count.
	 */
	@Override
	public void capitalLetters() {
		String string = "why so sad";
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(i)) {
				count += 1;

			}
		}
		System.out.println(count);

	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questioneighteen.QuestionEighteenSuper#lowercaseToCapital()
	 * This method takes a string and changes the lower case letters to Upper Case by
	 * using the .toUpperCase() method on the string.
	 */
	@Override
	public void lowercaseToCapital() {
		String string = "hello";
		String string1 = string.toUpperCase();
		System.out.println(string1);

	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questioneighteen.QuestionEighteenSuper#stringToInt()
	 * This method takes a string and changes it to an integer by using the parseInt method.
	 * It then adds 10 to the integer.
	 */
	@Override
	public void stringToInt() {
		String string = "27";
		int x = Integer.parseInt(string);
		x += 10;
		System.out.println(x);

	}

}

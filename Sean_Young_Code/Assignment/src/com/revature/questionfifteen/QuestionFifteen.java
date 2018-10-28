package com.revature.questionfifteen;

public class QuestionFifteen implements QuestionFifteenInterface {
	public static void main(String[] args) {
		QuestionFifteen q15 = new QuestionFifteen(); //instantiates an object of the class QuestionFifteen
		System.out.println(q15.additionMethod(5, 5)); //calls method additionMethod on the object q
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.questionfifteen.QuestionFifteenInterface#additionMethod(int, int)
	 * This overrides the abstract method that QuestionFifteen class implements. It takes two integers and adds
	 * them together
	 */
	@Override
	public int additionMethod(int a, int b) {
		int x = a + b;
		return x;
	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questionfifteen.QuestionFifteenInterface#subtractionMethod(int, int)
	 * This method overrides the abstract method that QuestionFifteen class implements from the interface. It 
	 * takes two integers and subtracts them.
	 */
	@Override
	public int subtractionMethod(int a, int b) {
		int x = a - b;
		return x;
	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questionfifteen.QuestionFifteenInterface#multiplicationMethod(int, int)
	 * This method overrides the abstract method that QuestionFifteen class implements from the interface.
	 * It takes two integers and multiplies them thus returning the result.
	 */
	@Override
	public int multiplicationMethod(int a, int b) {
		int x = a * b;
		return x;
	}
	/*
	 * (non-Javadoc)
	 * @see com.revature.questionfifteen.QuestionFifteenInterface#divisionMethod(int, int)
	 * This method overrides the abstract method that QuestionFIfteen class implements from the interface
	 * It takes two integers and divides them.
	 */
	@Override
	public int divisionMethod(int a, int b) {
		int x = a / b;
		return x;
	}

}

package com.revature.q18;

/**
 * 
 * @author Phil
 *
 */
public interface InterfaceClass {

	/**
	 * returns true if the string has a character that is uppercase
	 * @param str
	 * @return
	 */
	public abstract boolean hasUpper(String str);
	
	/**
	 * returns the string in full uppercase
	 * @param str
	 * @return
	 */
	public abstract String toUpper(String str);
	
	/**
	 * takes the int in the string and adds 10
	 * @param str
	 * @return
	 */
	public abstract int add10(String str);
	
}

package com.revature.removerepeatedchar;

/**
 * remove all repeated characters in a string
 * @author thienle
 *
 */
public class RemoveRepeatedChar {

	
	public String removeRepeatedChar(String str) {
		
		char[] characters = str.toCharArray();
		int length = characters.length;
		
		
		for(int i = 0; i < length; i++) {
			for(int j = i+1; j < length; j++) {
				if(characters[i]==characters[j]) {
					int temp = j;
					
					for(int k = temp; k < length-1; k++) {
						characters[k] = characters[k+1];
					}
					j--;
					length--;
				}
				
			}
		}
		
		String stringWithOutDuplicates = new String(characters);
		stringWithOutDuplicates = stringWithOutDuplicates.substring(0, length);
		
		return stringWithOutDuplicates;
	}

}

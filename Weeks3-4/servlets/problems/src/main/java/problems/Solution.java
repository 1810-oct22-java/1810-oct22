package problems;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args){

		//https://www.hackerrank.com/challenges/crossword-puzzle/problem
		String[] crossword = {"+-++++++++","+-++++++++","+-++++++++" ,"+-----++++" , "+-+++-++++" ,
				"+-+++-++++" , "+++++-++++" ,	"++------++",	"+++++-++++", "+++++-++++"};
		String words = "POLAND;LHASA;SPAIN;INDIA";

		String[] actual = crossword(crossword, words);
		String[] expected = {"++++++++++", "+POLAND+++", "+++H++++++", 
				"+++A++++++", "+++SPAIN++", "+++A++N+++", "++++++D+++",
				"++++++I+++", "++++++A+++" , "++++++++++" }; 


	}

	static String[] crossword(String[] crossword, String words) {
		String[] ws = words.split(";");
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.addAll(wordList);

	//	while(wordList.isEmpty()) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(crossword[i].charAt(j)=='-') {
						//start looking at letters
						System.out.print("(" +i + "," + j + "),");
						int count = 1;
						//check letters to right
						boolean go = true;
						int temp = i;
						while(go) {
							if(crossword[i].charAt(++temp)=='-') {
								
							}
						}
						
						
						//check letters below
					}
				}
			}
	//	}

		return null;
	}

}

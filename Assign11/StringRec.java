
public class StringRec {

		// DO NOT DECLARE ANY VARIABLES HERE
		// (you may declare local variables inside methods)

	 //Find and return the longest word (the word with the most letters in it) from the given sentence. You may assume that the input
	 //does not contain digits or punctuation. You may assume that words are separated by single spaces.
		public static String compare(String str1, String str2) {
	        if (str1.length() > str2.length()) {
	            return str1;
	        } else {
	            return str2;
	        }
	    }
		public static String longestWord(String sentence)
		{
		        //Find and return the longest word (the word with the most letters in it) from the
		        //given sentence. You may assume that the input does not contain digits or punctuation.
		        //You may assume that words are separated by single spaces.
		       
		    String longest;
		
		    int i = sentence.indexOf(' ');
		
		    if (i == -1)
		    {
		        return sentence;
		    }
		
		    String first = sentence.substring(0,i);
		    first = first.trim();
		    String rest = sentence.substring(i);
		    rest = rest.trim();
		
		    longest = compare(first,longestWord(rest));
		
		    return longest;
		       
		       
		}
		
		//Decompress the input text, which has been compressed using the RLE algorithm
		public static String decompress(String compressedText)
		 {
				if(compressedText.equals("") || compressedText.length()==1)
					return compressedText;
		
				String first = "";
				String rest = "";
				char c = compressedText.charAt(0);
		
				if (Character.isLetter(c) == true) {
					first = compressedText.substring(0, 1);
					rest = compressedText.substring(1);
					return first + decompress(rest);
		
				} else {
					first = compressedText.substring(0, 2);
					rest = compressedText.substring(2);
					int x = Integer.parseInt(compressedText.substring(0,1));
					char y = compressedText.charAt(1);
					return repeat(x, y) + decompress(rest); 
				}
		
			}
		
		public static String repeat(int i, char c){
		     String str = "";
		 
		     for(int j = 0; j < i; j++){
		     str = str+c;
		     }
		 
		     return str;
		}

		
}


public class MethodPractice {

		//count and return the number of vowels in the given string
		public static int numVowels(String s){
			s = s.toLowerCase();
			int count = 0;
			for(int i = 0; i<s.length()-1; i++){
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
				count = count+1;
				}
			}
			return count;
		}
		
		//determines if given number is a square of another
		public static boolean isSquared(int x){
		boolean squared = false;
		if(((Math.sqrt(x))%1) == 0){
			squared = true;
		}else{
			squared = false;
		}
		return squared;
		}
		
		//returns a string that is the reverse of the given string
		public static String reverse(String s){
				if (s == null){
				return null;
				}
				int l = s.length();
				if (l == 1){
				return s;
				}
				else if(l > 1){
				return s.charAt(l-1)+reverse(s.substring(1,l-1))+s.charAt(0);
				}
				return s;
				}
		
		//determines if s is the reverse of t
		//hint: you can use other methods
		public static boolean isReversed(String s, String t){
		boolean reversed;
		if(reverse(s).equals(t)){
			reversed = true;
		} else if(reverse(t).equals(s)){
			reversed = true;
		} else{
			reversed = false;
		}
		return reversed;
		}
		
		//You can test your methods above here.

	}
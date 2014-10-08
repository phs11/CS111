
public class NthPrime {
	
	public static void main(String[] args){
		
		//Write your code in the file NthPrime.java. Write your test cases in assign4-testcases.txt.

		//A prime number is one that has no divisors other than 1 and itself (no other number divides evenly into the prime number). The 1st (smallest) prime number is 2. The 2nd is 3, the 3rd is 5, etc.

		//Ask the user for a value n, and compute the nth prime number. You must perform this computation using loops. You MAY NOT hardcode a list of prime numbers into your program.
		//Examples: java NthPrime
		//10
		//RESULT: 29 
		
		System.out.println("Enter a value n to find the nth prime.");
		int n = IO.readInt();
		while (n < 1) {
			IO.reportBadInput();
			n = IO.readInt();
		}
		int i;
		int nextPrime = 1;
		int count = 0;
		while (count < n){
			nextPrime=nextPrime+1; //find the next prime number 
			for (i = 2; i <= nextPrime; i++){
				if (nextPrime % i == 0) {
					break; //prime not found
				}
			}
			if(i == nextPrime){
				count = count+1; 
			}
		}
		IO.outputIntAnswer(nextPrime);
	}

}

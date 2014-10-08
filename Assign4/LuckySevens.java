
public class LuckySevens {

	public static void main(String[] args){
	
		System.out.println("Enter the lower end of the range.");
		int lowRange = IO.readInt();
		System.out.println("Enter the upper end of the range.");
		int upRange = IO.readInt();
		while(upRange < lowRange){
			IO.reportBadInput();
			upRange = IO.readInt();
		}
		int count = 0;
		for(int n=lowRange; n <= upRange; n++){
			int posN = Math.abs(n);
			while(posN>0){	
				if(posN % 10 == 7){
					count = count+1;
				}
				posN = posN/10;
			}
		}
		IO.outputIntAnswer(count);
	}
	
}

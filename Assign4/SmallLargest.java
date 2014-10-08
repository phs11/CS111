
public class SmallLargest {

	public static void main(String[] args){
		
		System.out.println("What is the terminating value?");
		int termNum = IO.readInt();
		System.out.println("enter the first number");
		double num = IO.readDouble();
		double small = num;
		double large = num;
			while (num != termNum){
				System.out.println("enter the next number.");
				num = IO.readDouble();
				if(num == termNum){
					break;
				}else if(num > large){
				large = num;
				}else if(num < small){
					small = num;
				}
			}
			IO.outputDoubleAnswer(large);
			IO.outputDoubleAnswer(small);
		}
	}

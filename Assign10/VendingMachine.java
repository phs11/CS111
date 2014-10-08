
public class VendingMachine {
	// define fields here

	int numslots;
	int maxperslot;
	double cash;

	String[] vend;
	int[] numItems;
	double[] prices;
	

	//FAQ
	//if quantity greater than space left in the slot then return error
	//if you reset product then reset quantity
	//if you restock item that is already in another slot, only the name has to be the same
	//getQuantity non existing product return 0
	
	
	//Takes the number of slots in the vending machine, the maximum number of items that can fit into any one slot, and the 
	//amount of cash in the machine initially. This is the constructor method.

		public VendingMachine(int numslots, int maxperslot, double cash)
		{
		this.numslots = numslots;
		this.maxperslot = maxperslot;
		this.cash = cash;
		
		if(cash < 0){
			cash = 0;
		}
	        
		String[] vend = new String[numslots];
		this.vend = vend;
		double prices[] = new double[numslots];
		this.prices = prices;
		int[] numItems = new int[numslots];
		this.numItems = numItems;
		
		}

		
		//Make the given slot hold items of the specified kind of product, sold for the given price. The initial quantity of the 
		//product in this slot should be zero. If the slot already held another kind of product, the old product should be removed 
		//from this slot.
		public void setProduct(int slot, String product, double price)
		{
			
			
			if(slot <= numslots){
				prices[slot] = price;
				if(vend[slot] == null){
					vend[slot] = product;
				}else if(vend[slot] != null){
					vend[slot] = product;
					numItems[slot] = 0;
				}
			}else{
				System.out.println("The machine doesn't have that many slots");
				return;
			}
		}
	
		
		public void restockProduct(String product, int quantity)
		{
			int tempNum = 0;
			if(quantity > maxperslot){
				System.out.println("Error: quantity entered exceeds max quantity per slot.");
				return;
			}
			for(int i = 0; i<vend.length; i++){
				if(vend[i] == product && numItems[i] < maxperslot){
					if(numItems[i] + quantity <= maxperslot){
						numItems[i] = numItems[i] + quantity;
						break;
					}else if(quantity + numItems[i] > maxperslot){
						tempNum = maxperslot - numItems[i];
						numItems[i] = maxperslot;
						quantity = quantity - tempNum;
						if(quantity == 0){
							break;
						}
					}
				}
			}
	
			}
		//Add the given quantity of the specified product to the vending machine. Put as many of the items as possible into the
		//first slot that has been designated to hold that particular kind of product (using setProduct()). If not all of the 
		//items will fit into the first slot, put as many of the rest as possible into the second slot that holds that kind of 
		//product, etc. For partial credit, your method should at least be able to find the first slot designated for the 
		//specified product and put all of the items there.

		//Return the amount of cash now in the vending machine (this amount should increase whenever an item is purchased).
		public double getCashOnHand()
		{
			return cash; 
		}

		//Return the number of items in the given slot.
		public int getQuantity(int slot)
		{
			if(slot <= numslots){
				if(vend[slot] == null){
					return 0;
				}
			return numItems[slot]; 
			}
			else{
				return 0;
			}
		}

		//Return the total number of items of the specified kind of product that are in the vending machine. Remember that this 
		//product may be in more than one slot. If the product is not in the vending machine at all, simply return zero.
		public int getQuantity(String product)
		{	
			int productQuantity = 0;
			for(int j = 0; j<vend.length; j++){
				if(vend[j] == product){
					productQuantity = productQuantity + numItems[j];
				}
			}
			
	
			return productQuantity;
		}
		
		//Attempt to buy one item from the given slot. Return true if successful.
		public boolean buyItem(int slot)
		{
			boolean itemBought = false;
			if(slot <= numslots){
				if(vend[slot] != null){
					cash = cash + prices[slot];
					numItems[slot] = numItems[slot] - 1;
					itemBought = true;
				}
				else if(vend[slot] == null){
					
					itemBought = false;
				}
		
			}else{
				itemBought = false;
			}
			return itemBought;
		}

}

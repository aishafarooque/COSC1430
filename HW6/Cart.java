// /*
// CART CLASS

// Your Cart class should contain:

// Attributes (private)

// Item items[] - Items in the cart. Size of this array is initialized in constructor.
// int itemQuantities[] – quantity of each item in the cart. Eiample: A cart has 2 apples and 1 
// computer. item[0] has Apple with quantity[0] =2, Item[1] has Computer with quantity[1] = 1 i.e. 
// quantity[i] is the quantity of item[i]
// int itemCount – number of items (types, not quantities) at any given state. For above eiample if 
// you have 2 apples and 1 Electronics in the cart, your itemCount should be 2.
// double totalPrice - price of all the items in the cart
// int totalQuantity - quantity of all the items in the cart. For above eiample, total quantity is 3.

// Constructors
// Cart() - sets default value cartSize to 10 and creates arrays items & itemQuantities arrays having 
// size 10, initializes other int/double type attributes to 0/0.00.
// Cart(int cartSize) - sets cartSize and creates arrays items & itemQuantities arrays having size 
// cartSize, initializes other int/double type attributes to 0/0.00.. If cartSize is less than or equal 
// to zero, set it to default size 10.
// Methods - all methods are public (unless mentioned)
// */

// import java.util.Arrays;
// import java.util.List;

// public class Cart {
// 	private Item items[];
// 	private int itemQuantities[];
// 	private int itemCount; //number of items (types, not quantities) at any given state. 
// 	private int cartSize;
// 	public double totalPrice;
// 	public int totalQuantity;

// 	Cart() {
// 		cartSize = 10;
// 		items = new Item[10];
// 		itemQuantities = new int[10];
// 		itemCount = 0;
// 		totalQuantity = 0;
// 		totalPrice = 0.0;
// 		totalQuantity = 0;
// 	}//end constructor

// 	Cart(int cs) {
// 		if (cs <= 0) {
// 			cartSize = 10;
// 		}//end if
// 		else {
// 			cartSize = cs;
// 		}//end else
// 		items = new Item[cartSize];
// 		itemQuantities = new int[cartSize];
// 		itemCount = 0;
// 		totalQuantity = 0;
// 		totalPrice = 0.0;
// 		totalQuantity = 0;
// 	}//end constructor

// 	public int getItemCount() { //retrieves itemCount
// 		return itemCount;
// 	}
// 	public double getTotalPrice() { //retrieves totalPrice
// 		return totalPrice;
// 	}
// 	public int getTotalQuantity() { //retrieves totalQuantity
// 		return totalQuantity;
// 	}
// 	public int getCartSize() { //retrieves cartSize
// 		return cartSize;
// 	}

// 	public void setTotalPrice(Item itemToAdd){
// 		totalPrice += itemToAdd.getPrice();
// 	}


//     // -------------------------------------------------------
//     //  Sets the cart Size
//     // -------------------------------------------------------

// 	public void setCartSize(int newCartSize) { 
// 		/* It always works if newCartSize greater than current 
// 		cartSize. If the newCartSize is less than current cartSize, resize only if itemCount is less than newCartSize, 
// 		otherwise leave unchanged. If newCartSize is less than or equal to zero, no update is done. */
// 		if (newCartSize > cartSize) {
// 			cartSize = newCartSize;
// 		}

// 		else if (newCartSize > cartSize || newCartSize < cartSize && itemCount < newCartSize){
// 			cartSize = newCartSize;
// 		}

// 		else if (newCartSize <= 0 ) {
// 			//do nothing
// 		}
// 	}


//     // -------------------------------------------------------
//     //  Adds an item to the shopping cart.
//     // -------------------------------------------------------

// 	public void add(Item itemToAdd, int addQuantity) {
// 		// check if item already eiists, 
// 		// 	if yes, increment item quantity

// 		// if not:
// 		// 	check if there is space
// 		// 		if yes, then add item

// 		// 		if not, increase cartsize by 1
// 		// 		and then add item

// 		try {
// 			if (addQuantity <= 0 || itemCount == cartSize) {
// 				return;
// 			}
// 			int found = -1;
// 			if (itemCount < cartSize) {
// 				found = search(itemToAdd);
// 				if (found == -1) { //if found
// 					items[itemCount] = itemToAdd;
// 					itemQuantities[itemCount] = addQuantity;
// 					totalPrice += (addQuantity * itemToAdd.getPrice());
// 					itemCount += 1;

// 				}//end if
// 				else {
// 					itemQuantities[found] += addQuantity;	
// 					totalPrice += (addQuantity * itemToAdd.getPrice());
// 					itemCount += 1;			
// 				}//end else
// 			}
// 			totalQuantity += addQuantity;
// 			// totalPrice += (addQuantity * itemToAdd.getPrice());
// 			found = -1; //reset 
// 		} catch(NullPointerException e) {
// 			System.out.print("");
// 		}


// 	}



// 	public void remove(Item itemToRemove, int removeQuantity) {
// 		//do something

// 		int counter = -1; //default value
// 		if (itemCount > 0 && removeQuantity > 0) {
// 			counter = search(itemToRemove); //returns indei
// 			if (counter != -1) {
// 				if (removeQuantity == itemQuantities[counter]) {
// 					itemQuantities[counter] -= removeQuantity;
// 					totalQuantity -= removeQuantity;
// 					totalPrice -= removeQuantity * itemToRemove.getPrice();
// 					itemCount -= 1; //decrement
// 				}//end if

// 				else if (removeQuantity < itemQuantities[counter]) {
// 					itemQuantities[counter] -= removeQuantity;
// 					totalQuantity -= removeQuantity;
// 					totalPrice -= removeQuantity * itemToRemove.getPrice();
// 					// itemCount -= 1; //decrement
// 				}//end if

// 				else if (removeQuantity > itemQuantities[counter]) {
// 					totalQuantity -= itemQuantities[counter];
// 					totalPrice -= itemQuantities[counter] * itemToRemove.getPrice();
// 					itemCount -= 1;
// 				}//end else if


// 				else if (removeQuantity <= 0) {
// 					//do nothing
// 				}
// 				}//end if
// 			}//end if
// 	}

//     // -------------------------------------------------------
//     //  Searches for an item to the shopping cart.
//     // -------------------------------------------------------

// 	private int search (Item itemToFind) {
// 		/* 	int found = -1;
// 		for (int i = 0; i < itemCount; i++) {
// 			if (items[i].getName() == itemToFind.getName()){
// 				found = i;
// 			} else {
// 				found = -1;
// 			}//end if-else
// 		}//end for

// 		return found;*/


// 		int found = -1;
// 		String s = "";
// 		String f = "";
// 		for (int i = 0; i < itemCount; i++) {
// 			s = items[i].formattedOutput();
// 			f = itemToFind.formattedOutput();
// 			if (items[i].getName() == itemToFind.getName()){
// 				if(items[i].getClass() == itemToFind.getClass()){
// 					f = itemToFind.formattedOutput();
// 					if(itemToFind.formattedOutput().equals(s))	{
// 						found = i;
// 						break;
// 					}
// 					else if(items[i].getClass()	==	itemToFind.getClass()){
// 						f = itemToFind.formattedOutput();
// 						if(itemToFind.formattedOutput() == s)	{
// 							found = i;
// 							break;
// 						}
// 						// else if (items[i].getWeight() == itemToFind.getWeight()) {
// 						// 	found = i;
// 						// 	break;
// 						// }

// 						// else if (items[i].getWeightUnit() == itemToFind.getWeightUnit()) {
// 						// 	found = i;
// 						// 	break;
// 						// }
// 						else if(items[i].getClass()	==	itemToFind.getClass()){
// 							f = itemToFind.formattedOutput();
// 							if(itemToFind.formattedOutput() == s)	{
// 								found = i;
// 								break;
// 							}
// 						// else if (items[i].getFabric() == itemToFind.getFabric()) {
// 						// 	found = i;
// 						// 	break;
// 						// }

// 						// else if (items[i].getSize() == itemToFind.getSize()) {
// 						// 	found = i;
// 						// 	break;
// 						// }

// 					}//end if-else
// 			}//end for
// 		} else {
// 			found = i;
// 		}
// 	}}
// 	return found;
// }



// 	public String formattedOutput() {
// 		String result = "";

//         //Loops till number of items available in the cart

// 		for (int i = 0; i < itemCount; i++)
// 			result += items[i] + ", " + itemQuantities[i] + ", " + itemQuantities[i] * items[i].getPrice();
// 			result += "Total Quantity: " + totalQuantity;
// 			result += "Total Price: " + totalPrice;
// 		return result;
// 	}

// 	public static void main(String[] args) {
// 		System.gc();
// 	}
// }



// /*


// // void add (Item item, int addQuantity) - to add items to the cart. Make sure you can only add items 
// // if there is enough room in the cart (the quantity of each item does not matter). If an item is added 
// // (you can use searchItem method here) that is already in the cart, increase the quantity, but do not duplicate the item. If addQuantity is less than or equal to zero, no update is required.

// // void remove (Item item, int removeQuantity) - to remove removeQuantity number of items from the 
// // cart (if the removeQuantity is greater than quantity of items in the cart, it removes all of them). 
// // For eiample, you have 7 apples in the cart and removeItem("Apples",15) is called, then you remove all 
// // 7 of them (including the item from the cart), but if removeItem("Apples",5) is called, you remove 5 of 
// // them and 2 apples remain in the cart. Note that, you can only remove item if it is present in the cart 
// // (you can use searchItem method). If removeQuantity is less than or equal to zero, no update is required.

// // private int search (Item item) – returns indei of the item in the array if found, or -1 if item is not 
// // found in the cart. Compare name of the item only. This is a helper function you can use in addItem or 
// // removeItem method.

// // String formattedOutput() - Calls the formattedOutput() function of all items in the cart, followed by the 
// // quantity of each item type in cart, and its total price (the price should reflect the quantity). Finally, 
// // formattedOutput() should include the total number of items in the cart and the total price of all items in the cart.

// */









/////////////////////////////////////////////////////////////////////
import java.text.DecimalFormat;

class Cart{
  private Item items[];
  int itemQuantities[];
  int itemCount;
  int totalQuantity;
  double totalPrice;
  Cart(){
    items = new Item[10];
    itemQuantities = new int[10];
    itemCount = totalQuantity = 0;
    totalPrice = 0.00;
  }
  Cart(int cartSize){
    if (cartSize <= 0){
      items = new Item[10];
      itemQuantities = new int[10];
    }
    else {
      items = new Item [cartSize];
      itemQuantities = new int[cartSize];
    }
    itemCount = totalQuantity = 0;
    totalPrice = 0.00;
  }
  int getItemCount()
  {
    return itemCount;
  }
  double getTotalPrice(){
    return totalPrice;
  }
  int getTotalQuantity(){
    return totalQuantity;
  }
  int getCartSize(){
    return items.length;
  }
  void setCartSize(int newCartSize){
    if (newCartSize > 0){
      if (items.length < newCartSize){
        Item temp[] = new Item[newCartSize];
        System.arraycopy(items, 0 , temp , 0 , itemCount);
        items = new Item[newCartSize];
        items = temp;
      }
      else if (newCartSize < items.length && itemCount <= newCartSize){
        Item temp[] = new Item[newCartSize];
        System.arraycopy(items, 0, temp, 0, itemCount);
        items = new Item[newCartSize];
        items = temp;
      }
    }
  }
  void add(Item item, int addQuantity){
    int indx = -1;
    if (itemCount < items.length){
      if (addQuantity > 0){
        indx = search(item);
        if (indx == -1){
          items[itemCount] = item;
          itemQuantities[itemCount] = addQuantity;
          itemCount++;
        }
        else {
          itemQuantities[indx] += addQuantity;
        }
        totalQuantity += addQuantity;
        totalPrice += (addQuantity * item.getPrice());
      }
    }
  }
  void remove (Item item, int removeQuantity){
    int indx = -1;
    if (itemCount > 0){
      if (removeQuantity > 0){
        indx = search(item);
        if (indx == -1){

        }
        else{
          if (removeQuantity > itemQuantities[indx]){
            totalQuantity -= itemQuantities[indx];
            totalPrice -= itemQuantities[indx] * item.getPrice();
            itemQuantities[indx] = 0;
            for (int x = indx; x < itemCount - 1; x++){
              items[x] = items[x+1];
            }
            itemCount--;
          }
          else if (removeQuantity < itemQuantities[indx]){
            itemQuantities[indx] -= removeQuantity;
            totalQuantity -= removeQuantity;
            totalPrice -= removeQuantity * item.getPrice();
          }
          else if(removeQuantity == itemQuantities[indx]){
            itemQuantities[indx] -= removeQuantity;
            totalQuantity -= removeQuantity;
            totalPrice -= removeQuantity * item.getPrice();
            itemCount--;
          }
        }
      }
    }
  }
  private int search(Item item){
    String searchItem = "";
    int searchedItem = -1;
    for (int x = 0; x < itemCount; x++){
      if(items[x].getName()==item.getName()){
        searchItem = items[x]. formattedOutput();
        if(items[x].getClass() == Electronics.class){
          if (item.formattedOutput().equals(searchItem)){
            searchedItem = x;
            break;
          }
          else if(items[x].getClass() == Food.class){
            if (item.formattedOutput().equals(searchItem)){
              searchedItem = x;
              break;
            }
            else if(items[x].getClass() == Food.class){
              if (item.formattedOutput().equals(searchItem)){
                searchedItem = x;
                break;
              }
              else if (items[x].getClass() == Dress.class){
                if (item.formattedOutput().equals(searchItem)){
                  searchedItem = x;
                  break;
                }
              }
            }
          }
          return searchedItem;
        }
      }
      String formattedOutput(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String result = "";
        for ( x = 0; x < itemCount; x++){
          result += items[x].formattedOutput() + "," + itemQuantities[x] + "," + df.format(itemQuantities[x] * items[x].getPrice());
          result += "\nTotal Quantity: " + totalQuantity;
          result += "\nTotal Price: " + df.format(totalPrice);
        }
        return result;
      }
    }
  }
}

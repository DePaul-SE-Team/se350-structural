package org.example.Facade.Simple.Bad;

/**
 * Requirement: Let’s say that we have an eCommerce application that allows users
 *  to request orders. Here are the steps involved:
 * - Authenticate
 * - CheckInventory
 * - Connect to payment
 * - ChargeUser
 * At the end it should return a response (200)
 */
public class Client {
    public static void main (String [] args){
        // as a client
        UserRequest userRequest = new UserRequest("dj","123",100f,"123", new String[]{"12", "12", "2"});
        Authenticate authenticate = new Authenticate();
        authenticate.apply();
        Inventory inventory = new Inventory();
        for (var item: userRequest.ItemIds()){
            inventory.checkInventory(item);
        }
        Payment pay = new Payment(userRequest.getName(), userRequest.getAmount(), userRequest.getCardNumber());
        pay.Pay();
        FullFillOrder fullFillOrder = new FullFillOrder(inventory);
        fullFillOrder.FullFill(userRequest.getName(),userRequest.getAddress(),userRequest.ItemIds());

    }
}

class UserRequest{
    private final String name;
    private final String cardNumber;
    private final float amount;
    private final String address;
    private final String[] itemIds;

    UserRequest(String name, String CardNumber, float Amount, String address, String [] ItemIds){
        this.name = name;
        this.cardNumber = CardNumber;
        this.amount = Amount;
        this.address = address;
        this.itemIds = ItemIds;
        System.out.println("submit order");
    }
    public String getName(){
        return this.name;
    }
    public String getCardNumber(){
        return this.cardNumber;
    }
    public float getAmount(){
        return amount;
    }
    public String [] ItemIds(){
        return itemIds;
    }
    public String getAddress(){
        return address;
    }
}

class Authenticate{
    public void apply(){
        System.out.println("Aunthenticate");
    }
}

class Inventory{
    public boolean checkInventory(String id){
        return true;
    }
    public void reduceInventory(String id, int amount){
        System.out.println(String.format("reducing inventory of %s by %d",id, amount));
    }
}

class Payment{
    String name;
    float amount;
    String cardNumber;
    Payment(String name, float amount, String cardNumber){
        this.name = name;
        this.amount = amount;
        this.cardNumber = cardNumber;
    }
    public void Pay(){
        System.out.println(String.format("charging user: %s, with card: %s, of amount: %f",this.name, this.cardNumber,this.amount));
    }
}
class FullFillOrder{
    Inventory inventory;
    FullFillOrder(Inventory inventory){
        this.inventory  = inventory;
    }
    public void FullFill(String name, String address, String [] items){
        for(var item : items){
            inventory.reduceInventory(item,1);
        }
    }
}



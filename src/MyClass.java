/*
  @Author : Ganesh Bonde
  This solution can be used for personal use. It cannot be used for Commericial use.
  If you want to use this solution for commercial purpose then please contact the Author.
*/
import java.util.*;
public class MyClass {
    static List <Supplier> supplierList = new ArrayList();
    static List <Buyer> buyerList = new ArrayList();
    static List <Output> desiredList = new ArrayList();
    static boolean blnPrintResultOnConsole = true;
    static StringBuffer strOutputStream = new StringBuffer("");
    public static void main(String args[]) {
    int testNumber = 1;    
     System.out.println("*********************************************************************************************************");
     System.out.println("Test Case 1");
     
    // Test Case 1
    // Input 1
    addInput("s1", "09:45", "tomato" , "24/kg" , "100kg");
    // Desired output
    desiredList = new ArrayList();
    
    // Test Output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 2
    addInput("s2", "09:46", "tomato" , "20/kg" , "90kg");
    
    // Desired output
    desiredList = new ArrayList();
    
    // Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 3
    addInput("d1", "09:47", "tomato" , "22/kg" , "110kg");
    desiredList = new ArrayList();
    
    // Desired output
    desiredList.add(new Output("d1", "s2" , "20/kg" , "90kg"));
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 4
    addInput("d2", "09:48", "tomato" , "21/kg" , "10kg");
    
    // Desired output
    desiredList = new ArrayList();
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 5
    addInput("d3", "09:49", "tomato" , "21/kg" , "40kg");
    
    // Desired output
    desiredList = new ArrayList();
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 6
    addInput("s3", "09:50", "tomato" , "19/kg" , "50kg");
    
    // Desired output
    desiredList = new ArrayList();
    desiredList.add(new Output("d1", "s3" , "19/kg" , "20kg"));
    desiredList.add(new Output("d2", "s3" , "19/kg" , "10kg"));
    desiredList.add(new Output("d3", "s3" , "19/kg" , "20kg"));
    
    // Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
     if(blnPrintResultOnConsole){
           System.out.println("Output:");
           System.out.println(strOutputStream);
        }
    // Test Case 2
    System.out.println("*********************************************************************************************************");
     System.out.println("Test Case 2");
     strOutputStream =new StringBuffer("");
     supplierList = new ArrayList();
     buyerList = new ArrayList();
     desiredList = new ArrayList();
     

    // Input 1
    addInput("d1", "09:47", "tomato" , "110/kg" , "1kg");
    // Desired output
    desiredList = new ArrayList();
    
    // Test Output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 2 
    addInput("d2", "09:45", "potato" , "110/kg" , "10kg");
    
    // Desired output
    desiredList = new ArrayList();
    
    // Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 3 
    addInput("d3", "09:48", "tomato" , "110/kg" , "10kg");
    desiredList = new ArrayList();
    
    // Desired output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 4 s1 09:45 potato 110/kg 1kg
    addInput("s1", "09:45", "potato" , "110/kg" , "1kg");
    
    // Desired output 
    desiredList = new ArrayList();
    desiredList.add(new Output("d2", "s1" , "110/kg" , "1kg"));
    
    //Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 5 
    addInput("s2", "09:45", "potato" , "110/kg" , "7kg");
    
    // Desired output  
    desiredList = new ArrayList();
    desiredList.add(new Output("d2", "s2" , "110/kg" , "7kg"));
    
    // Test Output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 6 
    addInput("s3", "09:45", "potato" , "110/kg" , "2kg");
    
    // Desired output
    desiredList = new ArrayList();
    desiredList.add(new Output("d2", "s3" , "110/kg" , "2kg"));
  
    
    // Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
    
    // Input 7  
    addInput("s4", "09:45", "tomato" , "110/kg" , "11kg");
    
    // Desired output
    desiredList = new ArrayList();
    desiredList.add(new Output("d1", "s4" , "110/kg" , "1kg"));
    desiredList.add(new Output("d3", "s4" , "110/kg" , "10kg"));
    
    // Test output
    System.out.println(" Desired output test "+testNumber++ +" " + testDesiredOutput(desiredList,outputGenerated()));
     if(blnPrintResultOnConsole){
           System.out.println("Output:");
           System.out.println(strOutputStream);
        }
    

    } 
    
    
    
    public static void addInput(String orderId, String time, String produce, String price , String quantity){
        if(orderId!= null && orderId.contains("s")){
            supplierList.add(new Supplier (orderId, time, produce, price , quantity));
        }else{
            buyerList.add(new Buyer(orderId, time, produce, price , quantity));
        }
        
    }
    
    public static Boolean testDesiredOutput(List <Output> expectedList , List <Output> observeredList){
        if (expectedList == null && observeredList == null && expectedList.size() == 0 && observeredList.size() == 0 ){
            return true;
        }
        if (expectedList == null && observeredList == null && expectedList.size() != observeredList.size()){
        
            return false;
        }
        for(int i = 0 ; i <  expectedList.size() ; i++){
            if(expectedList.get(i) != null && !expectedList.get(i).equals(observeredList.get(i))){
                return false;
            }
        }
        
        return true;
    }
    
    public static List <Output> outputGenerated(){
        List <Output> outputList = new ArrayList();

        for(int i = 0 ; i< buyerList.size() ; i++){
           Buyer buyer = buyerList.get(i);
             for(int j = 0 ; j< supplierList.size() ; j++){
                 Supplier supplier = supplierList.get(j);
                if(buyer.getPrice() >= supplier.getPrice() && buyer.getProduce().equals(supplier.getProduce()) ){
                     if(buyer.getQuantity() > supplier.getQuantity()){
                         outputList.add(new Output(buyer.getOrderId() , supplier.getOrderId() , supplier.getPrice()+"" , supplier.getQuantity()+""));
                         buyer.setQuantity(buyer.getQuantity() - supplier.getQuantity());
                         supplier.setQuantity(0);
                         supplierList.remove(j);
                         j--;
                     }else if(buyer.getQuantity() <= supplier.getQuantity()){
                         outputList.add(new Output(buyer.getOrderId(), supplier.getOrderId() , supplier.getPrice()+"" , buyer.getQuantity()+""));
                         supplier.setQuantity( supplier.getQuantity()- buyer.getQuantity());
                         buyer.setQuantity(0);
                         buyerList.remove(i);
                         i--;
                         break;
                         
                     }
                }
            }
        }
        if(blnPrintResultOnConsole){
            for(Output out :outputList ){
                strOutputStream = strOutputStream.append( out.toString() + "\n"); 
            }
        }
        return outputList;
    }
    
    
    
}

class Supplier{
    private String orderId;
    private String time;
    private String produce;
    private int price;
    private int quantity;
    
    public Supplier(String orderId, String time, String produce, String price, String quantity){
        this.orderId = orderId;
        this.time = time;
        this.produce =  produce;
        this.price = Integer.parseInt(price.split("/")[0]);
        this.quantity =Integer.parseInt(quantity.replace("kg","")) ;
    }
    
    
    // Getter
    public String getOrderId() {
        return orderId;
    }
    
    
    // Getter
    public int getPrice() {
        return price;
    }
    
    
    // Getter
    public String getProduce() {
        return produce;
    }
    
    // Getter
    public int getQuantity() {
        return quantity;
    }
    
     // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
} 

class Buyer{
    private String orderId;
    private String time;
    private String produce;
    private int price;
    private int quantity;
    public Buyer(String orderId,String time, String produce, String price,String quantity){
        this.orderId = orderId;
        this.time = time;
        this.produce =  produce;
        this.price = Integer.parseInt(price.split("/")[0]);
        this.quantity = Integer.parseInt(quantity.replace("kg","")) ;
    }
    
    // Getter
    public String getOrderId() {
        return orderId;
    }
    
    // Getter
    public int getPrice() {
        return price;
    }
    
    // Getter
    public String getProduce() {
        return produce;
    }

    // Getter
    public int getQuantity() {
        return quantity;
    }
    
     // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
  
    
} 

class Output{
    private String demandOrderId;
    private String supplyOrderId;
    private int price;
    private int quantity;
    public Output(String demandOrderId,String supplyOrderId,  String price,String quantity){
        this.demandOrderId = demandOrderId;
        this.supplyOrderId = supplyOrderId;
        this.price = Integer.parseInt(price.split("/")[0]);
        this.quantity = Integer.parseInt(quantity.replace("kg",""));
    }
    
    @Override
    public boolean equals(Object o) {
        
        Output output = (Output) o;
        
        if(this.demandOrderId == output.demandOrderId && this.supplyOrderId == output.supplyOrderId && this.price == output.price && this.quantity == output.quantity ){
        return true;
        }else {
            return false;
        }
    }
    
    public String toString(){
        return demandOrderId + " " + supplyOrderId+ " " + price  + "/kg " + quantity +"kg";
    }
    
    
    
} 
package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PurchaseHistory {


    // adicionar no cvs reader para pular a primeira linha

    //creating atributtes
    ArrayList<String> customers;
    HashMap<String, Integer> customerIndex;
    ArrayList<String> products;
    HashMap<String, Integer> productIndex;
    ArrayList<HashSet<Integer>> purchaseLists; //creates a list of sets of integers

    public PurchaseHistory(){
        customers = new ArrayList<>();
        customerIndex = new HashMap<>();
        products = new ArrayList<>();
        productIndex = new HashMap<>();
        purchaseLists = new ArrayList<>();
 

        CSVReader reader = new CSVReader("C://Users//filip//Documents//Projeto_EDA//recommendation-system//data//dados_venda1.csv");
        ArrayList<String[]> data = reader.readCSV();


        for(String[] row : data){

            String customerCode = row[1];
            
            // if the client does not exist in the hashmap
            if (!customerIndex.containsKey(customerCode)){
                int index = customers.size(); //create the index of the new client
                customers.add(customerCode); //adds the new client in the list
                customerIndex.put(customerCode, index); //adds the new client and the index in the hashmap
                purchaseLists.add(new HashSet<>()); // adds an empty set in purchaseLists
            }

            String productCode = row[2];
            String productName = row[3];

            if (!productIndex.containsKey(productCode)){
                int index = products.size();
                products.add(productName);
                productIndex.put(productCode, index);
            }

            int customerIdx = customerIndex.get(customerCode); //get the client index
            int productIdx = productIndex.get(productCode); //get the product index

            purchaseLists.get(customerIdx).add(productIdx); 
        }
    }

    public void printCustomerProducts(String customerCode){
        if (!customerIndex.containsKey(customerCode)){
            System.out.println("Customer not found");
            return;
        }
        int customerIdx = customerIndex.get(customerCode);

        System.out.println("Customer " + customerCode);
        System.out.println("Products:");

        for(int productIdx : purchaseLists.get(customerIdx)){ //productIdx receives each element from the set
            System.out.println(products.get(productIdx));// gets the products name in the list products using the index
        }    
    }
}

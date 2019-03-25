/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping_program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author user00
 */
public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        Store store = new Store("Camera Online Store");

        // Read all products from the products file
        File productFile = new File("products.txt");
        try (Scanner input = new Scanner(productFile);) {
            input.useDelimiter(",");
            while (input.hasNext()) {
                int id = Integer.parseInt(input.next().trim());
                String name = input.next();
                String supplier = input.next();
                int price = Integer.parseInt(input.next().trim());

                Product product = new Product(id, name, supplier, price);
                store.addProduct(product);
            }
        }

        // Read all accounts from the account file
        File customerFile = new File("accounts.txt");
        try (Scanner input = new Scanner(customerFile);) {
            input.useDelimiter(",");
            while (input.hasNext()) {
                int account_id = Integer.parseInt(input.next().trim());
                String username = input.next();
                String password = input.next();
                String name = input.next();
                String address = input.next();
                String phone = input.next();
                String email = input.next();
    
                Customer customer = new Customer(name, address, phone, email);
                
                Account account = new Account(account_id, username, password, customer);
                store.addAccount(account);
            }
        }
        
        // we store products and account data in array 
    }
}

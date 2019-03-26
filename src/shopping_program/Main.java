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
                
                int account_id  = Integer.parseInt(input.next().trim());
                String username = input.next();
                String password = input.next();
                String name     = input.next();
                String address  = input.next();
                String phone    = input.next();
                String email    = input.next();

                Customer customer = new Customer(name, address, phone, email);

                Account account = new Account(account_id, username, password, customer);
                store.addAccount(account);
            }
        }

        // we store products and account data in array 
        System.out.println("^^^^^^ Welcome to our " + store.getName() + " ^^^^^");
        System.out.println("*****************************************");

        while (true) {
            System.out.println("Are you a customer or an admin?\n  (1) for user \n  (2) for admin\n  (3) to exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            int ans;
            
            switch (choice) {
                case 1: // User mode
                    do {
                        System.out.println("Choose the required operations from the list below:\n  (1) Display all products \n  (2) Add a product to the shopping cart by id \n  (3) Go back to main menu");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice == 1) {
                            System.out.println("The list of available products: \n");
                            for(int i = 0; i < store.getProducts().size(); i++){
                                System.out.println("-Product ID: " + store.getProducts().get(i).getId());
                                System.out.println("-Product Name: " + store.getProducts().get(i).getName());
                                System.out.println("-Product Supplier: " + store.getProducts().get(i).getSupplier());
                                System.out.println("-Product Price: " + store.getProducts().get(i).getPrice());
                                System.out.println("******************************************");
                            }
                        } else if (choice == 2) {
                            /* 
                            add to shopping cart 
                            ....................
                            display the shopping cart*/
                            
                            System.out.println("Enter the id of the product:");
                            int productID = sc.nextInt();
                            System.out.println("Enter the product quantity:");
                            int quantity = sc.nextInt();                                                        
                            
                            // get product object from store
                            Product product = store.getProductData(productID);
                            
                            // create orderd item
                            Order_item order_item = new Order_item(product, quantity); 
                            
                            // add ordered item to customer shopping cart
                            store.getAccounts().get(0).getShoppingCart().add_item(order_item);
                            
                            // get shopping cart of an account
                            Shopping_cart cart = store.getAccounts().get(0).getShoppingCart();
                            
                            // here to show all the products in shopping cart
                            for(int i = 0 ; i < cart.getOrder_items().size(); i++ ){
                                System.out.println( cart.getOrder_items().get(i).getProduct().toString() );
                                System.out.println("******************************************");
                                System.out.println("Quantity: " + cart.getOrder_items().get(i).getQuantity());
                            }

                            
                        } else if (choice == 3) {
                            break;
                        }
                        System.out.println("Another user operation? (0) for yes | (1) for No.");
                        ans = sc.nextInt();
                    } while (ans == 0);
                    break;
                case 2:// Admin mode
                    do {
                        System.out.println("Choose the required operations from the list below:\n  (1) Display all products \n  (2) Display all accounts\n  (3) Add a product  \n  (4) Delete a product \n  (5) Go back to main menu");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice == 1) {
                            System.out.println("The list of available products: \n");
                            for(int i = 0; i < store.getProducts().size(); i++){
                                System.out.println("-Product ID: " + store.getProducts().get(i).getId());
                                System.out.println("-Product Name: " + store.getProducts().get(i).getName());
                                System.out.println("-Product Supplier: " + store.getProducts().get(i).getSupplier());
                                System.out.println("-Product Price: " + store.getProducts().get(i).getPrice());
                                System.out.println("******************************************");
                            }
                        } else if (choice == 2) {
                            System.out.println("The list of accounts: \n");
                             for(int i = 0; i < store.getAccounts().size(); i++){
                                System.out.println("Account ID: " + store.getAccounts().get(i).getAccount_id());
                                System.out.println("Account Username: " + store.getAccounts().get(i).getUsername());
                                System.out.println("Account Password: " + store.getAccounts().get(i).getPassword());
                                System.out.println("Customer details for this account: ");
                                System.out.println("-name: " + store.getAccounts().get(i).getCustomer().getName());
                                System.out.println("-address: " + store.getAccounts().get(i).getCustomer().getAddress());
                                System.out.println("-email: " + store.getAccounts().get(i).getCustomer().getEmail());
                                System.out.println("-phone: " + store.getAccounts().get(i).getCustomer().getPhone());
                                System.out.println("******************************************");
                            }
                        } else if (choice == 3) {
                            // read product details from the admin and add it to the products array list within the store
                            System.out.println("Enter Product ID : ");
                            int productID = sc.nextInt();                            
                            
                            // go to read next line
                            sc.nextLine();
                            
                            System.out.println("Enter Product name : ");
                            String productName = sc.nextLine();               
                            
                            System.out.print("Enter Product supplier : ");
                            String productSupplier = sc.nextLine();                                                       
                            
                            System.out.print("Enter Product price : ");
                            int productPrice = sc.nextInt();
                            
                            Product product = new Product(productID, productName, productSupplier, productPrice);
                            store.getProducts().add(product);
                            
                            System.out.println("Great! The product has been added!");
                        } else if (choice == 4) {
                            System.out.println("Enter the index of the product to be deleted:");
                            int index = sc.nextInt();
                            store.getProducts().remove(index);
                        } else if (choice == 5) {
                            break;
                        }
                        System.out.println("Another admin operation? (0) for yes| (1) for No");
                        ans = sc.nextInt();
                    } while (ans == 0);
                    break;
                case 3:
                    System.out.println("Thanks for visiting our store!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect Entry! Try agian!");
                    break;
            }

        }

    }
}

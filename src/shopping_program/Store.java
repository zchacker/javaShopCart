/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping_program;

import java.util.ArrayList;

/**
 *
 * @author user00
 */
public class Store {
    String name;
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Account> accounts = new ArrayList<Account>();

    public Store(String name) {
        this.name = name;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
    
    public void addAccount(Account account){
        this.accounts.add(account);
    }
    
    public void deleteProduct(int id) {
        //this.products.
        
        int index = -1;
        // search for product index
        for(int i = 0; i  < this.products.size(); i++){
            if(this.products.get(i).getId() == id){
                index = i;
                break;
            }
        }
        
        this.products.remove(index);
    }
    
    public void deleteAccount(int account_id) {
    //this.products.

        int index = -1;
        // search for product index
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getAccount_id() == account_id) {
                index = i;
                break;
            }
        }

        this.products.remove(index);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping_program;

/**
 *
 * @author user00
 */
public class Account {
    int account_id;
    String username;
    String password;
    Customer customer;
    Shopping_cart shoppingCart;

    public Account(int account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public Shopping_cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Shopping_cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" + "account_id=" + account_id + ", username=" + username + ", password=" + password + '}';
    }

    
    
    
}

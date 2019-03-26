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
public class Product {
    int id;
    String name;
    String supplier;
    int price;

    public Product(int id, String name, String supplier, int price) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
       // return super.toString(); //To change body of generated methods, choose Tools | Templates.
       return 
        "-Product ID : " + this.id + 
        "\n-Product Name: " + this.name + 
        "\n-Product Supplier: " + this.supplier + 
        "\n-Product Price: " + this.price;
    }
    
    
}

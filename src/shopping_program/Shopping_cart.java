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
public class Shopping_cart {
    ArrayList<Order_item> order_items = new ArrayList<Order_item>();

    public ArrayList<Order_item> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(ArrayList<Order_item> order_items) {
        this.order_items = order_items;
    }
    
    public void add_item(Order_item item){
        this.order_items.add(item);
    }
}

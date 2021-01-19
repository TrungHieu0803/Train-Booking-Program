/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
package node;

import entity.Customer;

public class NodeC {
    
    public Customer in4;
    public NodeC next;

    

    public NodeC(Customer in4, NodeC next) {
        this.in4 = in4;
        this.next = next;
    }

    public NodeC(Customer c) {
        this.in4 = c;
        next = null;
    }
}

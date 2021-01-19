/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import entity.Booking;

/**
 *
 * @author Administrator
 */
public class NodeB {
    public Booking in4;
    public NodeB next;

    

    public NodeB(Booking in4, NodeB next) {
        this.in4 = in4;
        this.next = next;
    }

    public NodeB(Booking b) {
        this.in4 = b;
        next = null;
    }

    
}

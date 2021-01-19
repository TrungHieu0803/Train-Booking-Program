package node;

import entity.Train;

public class NodeT {

    public Train info;
    
    public NodeT next;

    public NodeT(Train x, NodeT p) {
        info = x;
        next = p;
    }

    public NodeT(Train x) {
        info = x;
        next = null; 
    }

    
}

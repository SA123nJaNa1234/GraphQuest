package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Node> nodes = new ArrayList<>();

    public Graph(){

        Node n0 = new Node(7,500,80);
        Node n1 = new Node(3,350,160);
        Node n2 = new Node(11,650,160);
        Node n3 = new Node(1,250,260);
        Node n4 = new Node(5,450,260);
        Node n5 = new Node(9,600,260);
        Node n6 = new Node(13,750,260);
        Node n7 = new Node(0,200,380);
        Node n8 = new Node(4,350,380);
        Node n9 = new Node(6,500,380);
        Node n10 = new Node(8,600,380);
        Node n11 = new Node(12,700,380);
        Node n12 = new Node(14,820,380);
        Node n13 = new Node(2,300,500);
        Node n14 = new Node(10,650,500);

        nodes.add(n0);nodes.add(n1);nodes.add(n2);nodes.add(n3);nodes.add(n4);
        nodes.add(n5);nodes.add(n6);nodes.add(n7);nodes.add(n8);nodes.add(n9);
        nodes.add(n10);nodes.add(n11);nodes.add(n12);nodes.add(n13);nodes.add(n14);

        connect(n0,n1,2);   // 7 -> 3
        connect(n0,n2,8);   // 7 -> 11

        connect(n1,n3,1);   // 3 -> 1
        connect(n1,n4,6);   // 3 -> 5

        connect(n2,n5,2);   // 11 -> 9
        connect(n2,n6,9);   // 11 -> 13

        connect(n3,n7,4);   // 1 -> 0
        connect(n3,n13,7);  // 1 -> 2

        connect(n4,n8,2);   // 5 -> 4
        connect(n4,n9,5);   // 5 -> 6

        connect(n5,n10,1);  // 9 -> 8

        connect(n6,n11,3);  // 13 -> 12
        connect(n6,n12,2);  // 13 -> 14

        connect(n10,n14,2); // 8 -> 10
    }

    private void connect(Node a, Node b, int weight){

        a.neighbors.add(new Edge(b, weight));
        b.neighbors.add(new Edge(a, weight));

    }
    
    public void resetGraph() {

        for(Node n : nodes){

            n.visited = false;

            n.color = java.awt.Color.GRAY;

            n.radius = 20;

        }

    }

}
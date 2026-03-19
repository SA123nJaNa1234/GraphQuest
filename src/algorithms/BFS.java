package algorithms;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import graph.Edge;
import graph.Graph;
import graph.Node;
import ui.GraphFrame;
import ui.GraphPanel;

public class BFS {

    public static void search(Graph graph, GraphPanel panel, int target, GraphFrame frame){

        Queue<Node> q = new LinkedList<>();

        Node start = graph.nodes.get(0);

        q.add(start);

        start.visited=true;

        while(!q.isEmpty()){

            if(frame.stopRequested) return;

            Node current = q.poll();

            pop(current,panel);

            current.color = Color.BLUE;

            panel.repaint();

            if(current.value==target){

                current.color = Color.RED;

                pop(current,panel);

                return;

            }

            for(Edge e : current.neighbors){

                Node n = e.to;

                if(!n.visited){

                    n.visited=true;

                    q.add(n);

                }

            }

        }

        JOptionPane.showMessageDialog(panel,"Value Not Present");

    }

    static void pop(Node n,GraphPanel panel){

        try{

            n.radius=28;

            panel.repaint();

            Thread.sleep(120);

            n.radius=20;

            panel.repaint();

            Thread.sleep(120);

        }catch(Exception e){}

    }

}
package algorithms;

import java.awt.Color;

import javax.swing.JOptionPane;

import graph.Edge;
import graph.Graph;
import graph.Node;
import ui.GraphFrame;
import ui.GraphPanel;

public class DFS {

    public static boolean dfs(Node node,int target,GraphPanel panel,GraphFrame frame){

        if(frame.stopRequested) return true;

        node.visited=true;

        pop(node,panel);

        node.color = Color.BLUE;

        panel.repaint();

        if(node.value==target){

            node.color=Color.RED;

            pop(node,panel);

            return true;

        }

        for(Edge e : node.neighbors){

            Node n = e.to;

            if(!n.visited){

                if(dfs(n,target,panel,frame)) return true;

            }

        }

        pop(node,panel);

        return false;

    }

    public static void search(Graph graph,GraphPanel panel,int target,GraphFrame frame){

        if(!dfs(graph.nodes.get(0),target,panel,frame)){

            JOptionPane.showMessageDialog(panel,"Value Not Present");

        }

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
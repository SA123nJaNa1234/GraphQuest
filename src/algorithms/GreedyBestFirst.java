package algorithms;

import java.awt.Color;
import java.util.Comparator;
import java.util.PriorityQueue;

import graph.Edge;
import graph.Graph;
import graph.Node;
import ui.GraphFrame;
import ui.GraphPanel;

public class GreedyBestFirst {

    static int heuristic(Node a, Node b){

        int dx = a.x - b.x;
        int dy = a.y - b.y;

        return (int)Math.sqrt(dx*dx + dy*dy);
    }

    public static void search(Graph graph, GraphPanel panel, int target, GraphFrame frame){

        Node foundGoal = null;

        for(Node n : graph.nodes){
            if(n.value == target){
                foundGoal = n;
                break;
            }
        }

        if(foundGoal == null) return;

        final Node goal = foundGoal;

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> heuristic(n,goal)));

        Node start = graph.nodes.get(0);

        pq.add(start);

        while(!pq.isEmpty()){

            if(frame.stopRequested) return;

            Node current = pq.poll();

            if(current.visited) continue;

            current.visited = true;

            pop(current,panel);

            current.color = Color.BLUE;

            panel.repaint();

            if(current == goal){

                current.color = Color.RED;

                pop(current,panel);

                return;
            }

            for(Edge e : current.neighbors){

                Node next = e.to;

                if(!next.visited){

                    pq.add(next);

                }

            }

        }

    }

    static void pop(Node n, GraphPanel panel){

        try{
            n.radius = 28;
            panel.repaint();
            Thread.sleep(120);

            n.radius = 20;
            panel.repaint();
            Thread.sleep(120);
        }
        catch(Exception ignored){}
    }
}
package algorithms;

import java.awt.Color;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import graph.Edge;
import graph.Graph;
import graph.Node;
import ui.GraphFrame;
import ui.GraphPanel;

public class Dijkstra {

    public static void search(Graph graph, GraphPanel panel, int target, GraphFrame frame){

        Map<Node,Integer> dist = new HashMap<>();

        for(Node n : graph.nodes)
            dist.put(n,Integer.MAX_VALUE);

        Node start = graph.nodes.get(0);

        dist.put(start,0);

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(dist::get));

        pq.add(start);

        while(!pq.isEmpty()){

            if(frame.stopRequested) return;

            Node current = pq.poll();

            if(current.visited) continue;

            current.visited = true;

            pop(current,panel);

            current.color = Color.BLUE;

            panel.repaint();

            if(current.value == target){

                current.color = Color.RED;

                pop(current,panel);

                return;
            }

            for(Edge e : current.neighbors){

                Node next = e.to;

                int newDist = dist.get(current) + e.weight;

                if(newDist < dist.get(next)){

                    dist.put(next,newDist);

                    pq.add(next);

                }

            }

        }

    }

    static void pop(Node n, GraphPanel panel){

        try{

            n.radius=28;
            panel.repaint();
            Thread.sleep(120);

            n.radius=20;
            panel.repaint();
            Thread.sleep(120);

        }catch(Exception ignored){}
    }
}
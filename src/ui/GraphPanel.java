package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class GraphPanel extends JPanel {

    public Graph graph;

    public GraphPanel(Graph g){
        this.graph = g;
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(2));

        // Draw edges with weights
        for(Node n : graph.nodes){

            for(Edge e : n.neighbors){

                Node neighbor = e.to;

                // Prevent drawing the same edge twice
                if(n.value < neighbor.value){

                    g2.setColor(Color.BLACK);
                    g2.drawLine(n.x, n.y, neighbor.x, neighbor.y);

                    int midX = (n.x + neighbor.x) / 2;
                    int midY = (n.y + neighbor.y) / 2;

                    g2.setColor(Color.WHITE);
                    g2.fillRect(midX - 10, midY - 10, 20, 20);

                    g2.setColor(Color.BLACK);
                    g2.drawRect(midX - 10, midY - 10, 20, 20);

                    g2.drawString("" + e.weight, midX - 4, midY + 4);
                }
            }
        }

        // Draw nodes
        for(Node n : graph.nodes){

            g2.setColor(n.color);

            g2.fillOval(
                    n.x - n.radius/2,
                    n.y - n.radius/2,
                    n.radius,
                    n.radius
            );

            g2.setColor(Color.BLACK);

            g2.drawString("" + n.value, n.x - 5, n.y + 5);
        }
    }
}
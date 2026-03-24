package ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import algorithms.AStar;
import algorithms.BFS;
import algorithms.DFS;
import algorithms.Dijkstra;
import algorithms.GreedyBestFirst;
import graph.Graph;

public class GraphFrame extends JFrame {

    Graph graph;
    GraphPanel panel;

    JTextField searchField;

    public boolean stopRequested=false;

    public GraphFrame(){

        graph = new Graph();

        panel = new GraphPanel(graph);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        searchField = new JTextField(5);

        String[] algos={"BFS","DFS","Dijkstra","Greedy","A*"};

        JComboBox<String> algoBox = new JComboBox<>(algos);

        JButton start = new JButton("Start");

        JButton stop = new JButton("Stop");

        topPanel.add(new JLabel("Search"));
        topPanel.add(searchField);
        topPanel.add(algoBox);
        topPanel.add(start);
        topPanel.add(stop);

        add(topPanel,BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);

        setTitle("GraphQuest - Graph Search Visualizer");

        setSize(1000,700);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);

        start.addActionListener(e -> {

            stopRequested=false;
            graph.resetGraph();  

            panel.repaint();


            int target = Integer.parseInt(searchField.getText());

            String algo = (String)algoBox.getSelectedItem();

            new Thread(() -> {

                switch(algo){

                    case "BFS":
                        BFS.search(graph,panel,target,this);
                        break;

                    case "DFS":
                        DFS.search(graph,panel,target,this);
                        break;

                    case "Dijkstra":
                        Dijkstra.search(graph,panel,target,this);
                        break;

                    case "Greedy":
                        GreedyBestFirst.search(graph,panel,target,this);
                        break;

                    case "A*":
                        AStar.search(graph,panel,target,this);
                        break;

                }

            }).start();

        });

        stop.addActionListener(e -> stopRequested=true);

    }

}
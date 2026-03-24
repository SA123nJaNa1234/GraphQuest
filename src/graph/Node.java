
package graph;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Node {

    public int value;
    public int x;
    public int y;

    public boolean visited = false;

    public int radius = 20;

    public Color color = Color.GRAY;

    public List<Edge> neighbors = new ArrayList<>();

    public Node(int value,int x,int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }

}
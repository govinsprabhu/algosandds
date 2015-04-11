package algorithms.problems.AlgorithmDesignAndAnalysis.kosaraju;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by GPrabhu on 12/1/2014.
 */
public class KosarajuMyWay {

    private static ArrayList<Vertex> graph = new ArrayList<>();
    private static ArrayList<Vertex> reGraph=new ArrayList<>();
    public static void main(String[] args) {
        getGraphFromFile();

    }

    public static ArrayList<Vertex> getGraphFromFile() {
        HashMap<Integer, Vertex> hashVertex = new HashMap<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("SCC.txt"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] vertexes = line.split(" ");
                if (!hashVertex.containsKey(vertexes[0])) {
                    Vertex vertex = new Vertex();
                    vertex.setId(Integer.parseInt(vertexes[0]));
                    vertex.getEdges().add(Integer.parseInt(vertexes[1]));
                    hashVertex.put(Integer.parseInt(vertexes[0]),vertex);
                    graph.add(vertex);
                }

                else {
                    Vertex vertex=graph.get(Integer.parseInt(vertexes[0]));
                    vertex.getEdges().add(Integer.parseInt(vertexes[1]));
                }
                if (!hashVertex.containsKey(vertexes[1])) {
                    Vertex vertex = new Vertex();
                    vertex.setId(Integer.parseInt(vertexes[1]));
                    vertex.getEdges().add(Integer.parseInt(vertexes[1]));
                    hashVertex.put(Integer.parseInt(vertexes[0]),vertex);
                    reGraph.add(vertex);
                }
                else{
                    Vertex vertex=graph.get(Integer.parseInt(vertexes[1]));
                    vertex.getEdges().add(Integer.parseInt(vertexes[0]));
               }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }
}

class Vertex {
    int id;
    ArrayList<Integer> edges;

    public void setId(int id) {
        this.id = id;
    }

    public void setEdges(ArrayList<Integer> edges) {
        this.edges = edges;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getEdges() {
        return edges;
    }

    Vertex() {
        edges = new ArrayList<>();
    }


}


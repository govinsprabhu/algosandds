package algorithms.problems.AlgorithmDesignAndAnalysis.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Algorithms: Design and Analysis, Part 1
 * Programming Question - Week 5
 * @author Felix Garcia Lainez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Vertex> vertexArray = readGraphFromFile();

        for(int i = 1; i < vertexArray.size(); i++)
        {
            Vertex current = vertexArray.get(i);
            HashMap<Integer, Vertex> vertextHashMap = createVertexHashMapFromArray(vertexArray);

            int distance = computeDijkstraAlgorithm(current, vertextHashMap);

            System.out.println("Distance to Vertex " + current.getId() + " => " + distance);
        }
    }

    /**
     * Process the Dijkstra Algorithm
     * @param target The vertex to be found
     * @param vertextHashMap The hashmap of vertex
     * @return  The distance from first vertex to target
     */
    private static int computeDijkstraAlgorithm(Vertex target, HashMap<Integer, Vertex> vertextHashMap)
    {
        int pathDistance = 0;

        Vertex currentVertex = vertextHashMap.get(1);
        currentVertex.setExplored(true);
        currentVertex.setDistance(0);

        while(vertextHashMap.size() > 0)
        {
            for(Edge e : currentVertex.getEdgesArray())
            {
                int distance = currentVertex.getDistance() + e.getDistance();

                Vertex v = vertextHashMap.get(e.getDestinationVertexId());

                if(v != null)
                {
                    if(distance < v.getDistance()){
                        v.setDistance(distance);
                    }
                }
            }


            //SELECT MIN DISTANCE VERTEX
            int minDistance = 0;
            Vertex minDistanceVertex = null;

            Iterator<Integer> it = (Iterator<Integer>)vertextHashMap.keySet().iterator();

            while(it.hasNext())
            {
                Vertex v = vertextHashMap.get(it.next());

                if(!v.isExplored() && (v.getDistance() < minDistance || minDistance == 0))
                {
                    minDistance = v.getDistance();
                    minDistanceVertex = v;
                }
            }

            if(minDistanceVertex != null)
            {
                currentVertex = minDistanceVertex;
                currentVertex.setExplored(true);
                vertextHashMap.remove(currentVertex.getId());

                //WE HAVE FOUND THE TARGET
                if(currentVertex.getId() == target.getId())
                {
                    currentVertex = minDistanceVertex;
                    break;
                }
            }
            else
            {
                //THE TARGET HAS NOT BEEN FOUND
                break;
            }
        }

        if(currentVertex.getId() == target.getId()){
            pathDistance = currentVertex.getDistance();
        }
        else{
            pathDistance = 100000;
        }

        return pathDistance;
    }

    /**
     * Create a HashMap of Vertex from a given vertex list.
     * Restarts the state of each Vertex object added to the map
     * @param vertexArray The vertex list
     * @return The HashMap created
     */
    private static HashMap<Integer, Vertex> createVertexHashMapFromArray(ArrayList<Vertex> vertexArray)
    {
        HashMap<Integer, Vertex> vertextHashMap = new HashMap<Integer, Vertex>();

        for(Vertex v : vertexArray)
        {
            v.setExplored(false);
            v.setDistance(100000);
            vertextHashMap.put(Integer.valueOf(v.getId()), v);
        }

        return vertextHashMap;
    }

    /**
     * Reads the graph used as input for the assignment
     * @return A hash that contains each vertice and the list
     * of vertices linked to it
     */
    private static ArrayList<Vertex> readGraphFromFile()
    {
        ArrayList<Vertex> vertexArray = new ArrayList<Vertex>();

        FileInputStream fstream = null;
        try
        {
            fstream = new FileInputStream("dijkstraData.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null)
            {
                // process the line
                StringTokenizer tokens = new StringTokenizer(line);

                Vertex vertex = new Vertex(Integer.valueOf(tokens.nextToken()), 100000);

                while(tokens.hasMoreTokens())
                {
                    String edgeStr = tokens.nextToken();

                    StringTokenizer edgeTokenizer = new StringTokenizer(edgeStr, ",");

                    // first item is the token
                    int node = new Integer(edgeTokenizer.nextToken()).intValue();
                    int distance = new Integer(edgeTokenizer.nextToken()).intValue();

                    Edge edge = new Edge(node, distance);
                    vertex.getEdgesArray().add(edge);
                }

                vertexArray.add(vertex);
            }

            br.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                fstream.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vertexArray;
    }
}

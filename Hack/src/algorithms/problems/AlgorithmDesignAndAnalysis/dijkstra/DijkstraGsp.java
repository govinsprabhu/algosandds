package algorithms.problems.AlgorithmDesignAndAnalysis.dijkstra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by GPrabhu on 11/22/2014.
 */
public class DijkstraGsp {

    public static void main(String[] args) throws IOException {
        ArrayList<VertexNew> vertexList = getVertex();
        for (int i=1;i<vertexList.size();i++) {
            VertexNew vertexNew=vertexList.get(i);
            HashMap<Integer, VertexNew> hashVertex = getHashVertex(vertexList);
            int distance = dijkstra(vertexNew, hashVertex);
            System.out.println("distance to Node " + vertexNew.getId()+ " : " + distance);
        }
    }

    private static int dijkstra(VertexNew targetNode, HashMap<Integer, VertexNew> hashVertex) throws IOException {
        VertexNew currentVertex = hashVertex.get(1);
        currentVertex.setDistance(0);
        currentVertex.setExplored(true);
        while (hashVertex.size() > 0) {
            for (EdgeNew e : currentVertex.getEdge()) {
                int distance = currentVertex.getDistance() + e.getDistance();
                VertexNew vertexNew = hashVertex.get(e.getId());
                if (vertexNew != null) {
                    if (distance < vertexNew.getDistance())
                        vertexNew.setDistance(distance);
                }
            }
            Iterator<Integer> integerIterator = hashVertex.keySet().iterator();
            int minimumDistance = 0;
            int i = 2;
            VertexNew minVertexNew = null;
            while (integerIterator.hasNext()) {
                VertexNew vertexNew = hashVertex.get(integerIterator.next());
                if (!vertexNew.isExplored() && (vertexNew.getDistance() < minimumDistance || minimumDistance == 0)) {
                    minimumDistance = vertexNew.getDistance();
                    minVertexNew = vertexNew;
                }
            }
            if (minVertexNew == null) {
                break;
            } else {
                minVertexNew.setExplored(true);
                hashVertex.remove(minVertexNew.getId());
                currentVertex = minVertexNew;

                if (currentVertex.getId()==targetNode.getId()) {
                    currentVertex = minVertexNew;
                    break;
                }
            }

        }
        if (currentVertex.getId() == targetNode.getId()) {
            return currentVertex.getDistance();
        }
        return 10000;
    }

    public static ArrayList<VertexNew> getVertex() throws IOException {
        ArrayList<VertexNew> arrayList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("dijkstraDataNew.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        while ((line = reader.readLine()) != null) {

            StringTokenizer token = new StringTokenizer(line);
            VertexNew vertexNew = new VertexNew(Integer.parseInt(token.nextToken()), 10000);
            while (token.hasMoreTokens()) {
                String edgeAndDistance = token.nextToken();
                StringTokenizer stringTokenizer = new StringTokenizer(edgeAndDistance, ",");
                int node = Integer.parseInt(stringTokenizer.nextToken());
                int distance = Integer.parseInt(stringTokenizer.nextToken());
                EdgeNew edgeNew = new EdgeNew(distance, node);
                vertexNew.getEdge().add(edgeNew);
            }
            arrayList.add(vertexNew);
        }

        return arrayList;
    }

    public static HashMap<Integer, VertexNew> getHashVertex(ArrayList<VertexNew> arrayList) {
        HashMap<Integer, VertexNew> hashVertex = new HashMap<>();
        arrayList.forEach(x -> hashVertex.put(x.getId(), x));
        arrayList.forEach(x->x.setDistance(10000));
        arrayList.forEach(x->x.setExplored(false));
        return hashVertex;
    }
}




package algorithms.problems.AlgorithmDesignAndAnalysis.kosaraju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StronglyConnectedComponentsProblem {

    List<Integer>[] adjacentVertices = null;
    List<Integer>[] incomingVertices = null;

    public StronglyConnectedComponentsProblem(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader inputFil = new FileReader(file);
        BufferedReader in = new BufferedReader(inputFil);
        String s = in.readLine();
        adjacentVertices = new List[875714]; // One vertex is wasted / unused
        incomingVertices = new List[875714];
        in.close();

    }

    private void addEdge(int vertex1, int vertex2) {
        List<Integer> adjacentVertexList = adjacentVertices[vertex1];
        if (adjacentVertexList == null)
            adjacentVertexList = new ArrayList<Integer>();
        if (!adjacentVertexList.contains(vertex2)) {
            adjacentVertexList.add(vertex2);
            adjacentVertices[vertex1] = adjacentVertexList;
        }

        List<Integer> incomingVertexList = incomingVertices[vertex2];
        if (incomingVertexList == null)
            incomingVertexList = new ArrayList<Integer>();
        if (!incomingVertexList.contains(vertex1)) {
            incomingVertexList.add(vertex1);
            incomingVertices[vertex2] = incomingVertexList;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        StronglyConnectedComponentsProblem problem = new StronglyConnectedComponentsProblem("kosaraju.txt");

        problem.printTopComponents();

    }

    private void printTopComponents() {
        List<List<Integer>> stronglyConnectedComponents = (new StronglyConnectedComponents(adjacentVertices, incomingVertices)).getComponents();

        int[] componentSizes = new int[stronglyConnectedComponents.size()];

        int i = 0;
        int totalSize = 0;
        for (List<Integer> component : stronglyConnectedComponents) {
            componentSizes[i] = component.size();
            totalSize += componentSizes[i];
            i++;
        }

        Arrays.sort(componentSizes);

        System.out.println("Total Nodes from All SCCs = " + totalSize);

        for (i = componentSizes.length - 1; i > componentSizes.length - 6 && i >= 0; i--)
            System.out.print(componentSizes[i] + ",");

    }

}
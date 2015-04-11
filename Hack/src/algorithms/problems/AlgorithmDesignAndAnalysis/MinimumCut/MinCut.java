package algorithms.problems.AlgorithmDesignAndAnalysis.MinimumCut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MinCut {
    private AdjacencyLists graph = new AdjacencyLists();
    private int nodeLen = graph.len;
    private int cutNum;
    private int nodeA, nodeB;
    private int min = nodeLen - 1;
    private ArrayList<Integer> arraySet = new ArrayList();
    private int count = 0;

    public MinCut() {
        for (count = 0; count < 50; count++) {
            input();
            contract();
        }
        System.out.println(min);
    }

    // input the graph file
    public void input() {
        cutNum = nodeLen - 1;
        graph = new AdjacencyLists();
        arraySet = new ArrayList();
        try {
            String file = "kargerMinCut.txt";
            FileReader in = new FileReader(file);
            BufferedReader br = new BufferedReader(in);
            String s;
            int x;
            while ((s = br.readLine()) != null) {
                Scanner sca = new Scanner(s);
                x = sca.nextInt();
                graph.addVertex(x);
                // System.out.print(x); //datastructure
                while (sca.hasNext()) {
                    int y = sca.nextInt();
                    graph.addAdjvex(x, y);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initSet();
    }

    // initialize the arraySet for the random set
    public void initSet() {
        for (int j = 0; j < nodeLen; j++) {
            arraySet.add(j, j+1);
            // System.out.println(arraySet.get(j)); //datastructure
        }
    }

    // contract two random node until there are only two node left
    public void contract() {
        int num;
        while (arraySet.size() > 2) {
            // System.out.println(arraySet.size()); //datastructure
            randEdge();
            graph.contractVertex(nodeA, nodeB);
            // System.out.println(graph.getLen()); //datastructure
            tempNum(nodeA);
        }
        // when the contract is end, print the current and in all minNum
        if (arraySet.size() == 2) {
            if (cutNum < min) {
                min = cutNum;
            }
            // if(graph.UFO < min){
            // min = graph.UFO;
            // } //datastructure
            System.out.println("///" + cutNum + " - " + min + "///" + count); // datastructure
        }
    }

    // computer the edge number of node chosen
    public void tempNum(int a) {
        int num = graph.computerEdge(a); // computer edge of a after contract
        if (num < cutNum) {
            cutNum = num;
        }
        // graph.print(a); //datastructure
        // System.out.println("///////"+num + "///////"); //datastructure
    }

    // randomize a edge
    public void randEdge() {
        Random rand = new Random();
        int indexOfNodeA;
        int indexOfNodeB;
        indexOfNodeA = rand.nextInt(arraySet.size());// from 0 to getLen()-1
        nodeA = arraySet.get(indexOfNodeA); // from 1 to size
        int randomSeed = graph.nodeHash.get(nodeA).nodeEdge.size();//linkEdge index start from 0
        indexOfNodeB = rand.nextInt(randomSeed); // from 0 to
        // nodeA.linkEdge.size()
        nodeB = graph.getAdjvex(nodeA, indexOfNodeB);
        arraySet.remove(arraySet.indexOf(nodeB));
//                System.out.println(nodeA + "+++" + nodeB); // datastructure
    }

    public static void main(String[] args) {
        MinCut test = new MinCut(); // datastructure
    }
}

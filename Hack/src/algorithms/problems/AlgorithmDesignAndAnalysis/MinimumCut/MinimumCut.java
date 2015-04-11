package algorithms.problems.AlgorithmDesignAndAnalysis.MinimumCut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by GPrabhu on 11/9/2014.
 */

class node{
    int value;
    LinkedList<Integer> linkEdge;

}
class AdjacentList{
    HashMap<Integer,node> nodeHash=new HashMap();
    void addNode(int id){
        node node=new node();
        node.value=id;
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        node.linkEdge=linkedList;
        nodeHash.put(id,node);
    }
    void addEdge(int id,int adjacentValue){
        nodeHash.get(id).linkEdge.addLast(adjacentValue);
    }
    int getEdgeLength(int id){ return nodeHash.get(id).linkEdge.size();}

    Integer getNode(int indexOfA, int indexOfB) {
        return  nodeHash.get(indexOfA).linkEdge.get(indexOfB);
    }

    public void contractVertex(int nodeA, int nodeB) {
        deleteNodeB(nodeA,nodeB);

    }

    private void deleteNodeB(int nodeA, int nodeB) {
        while(nodeHash.get(nodeA).linkEdge.contains(nodeB))
        {
            nodeHash.get(nodeA).linkEdge.remove(nodeB);
        }
        while(nodeHash.get(nodeB).linkEdge.contains(nodeA))
        {
            nodeHash.get(nodeB).linkEdge.remove(nodeA);

        }

    }
}

public class MinimumCut {
    AdjacentList graph=new AdjacentList();
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    int nodeA,nodeB;
    public MinimumCut(){
        initGraph();
        findMini();

   }

    private void findMini() {
        if(arrayList.size()>2){
            rand();
            graph.contractVertex(nodeA,nodeB);
            


        }
    }

    private void rand() {
       Random rand= new Random();
        int indexOfA=rand.nextInt(200);
        int sizeOfA=graph.getEdgeLength(indexOfA);
        nodeA=arrayList.get(indexOfA);
        int indexOfB=rand.nextInt(sizeOfA);
        int nodeB=graph.getNode(indexOfA,indexOfB);
        arrayList.remove(nodeB);
    }

    private void initGraph() {
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("kargerMinCut.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null){
                Scanner scanner=new Scanner(s);
                int id=scanner.nextInt();
                graph.addNode(id);
                while(scanner.hasNext())
                {
                   graph.addEdge(id,scanner.nextInt());
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initArray();
    }

    private void initArray() {
        for(int j=0;j<200;j++)
        {
            arrayList.add(j,j+1);
        }
    }

    public static void main(String args[]) throws IOException {
        MinimumCut minimumCut=new MinimumCut();
    }
}

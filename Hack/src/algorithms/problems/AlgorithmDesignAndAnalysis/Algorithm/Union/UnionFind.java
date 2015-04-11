package algorithms.problems.AlgorithmDesignAndAnalysis.Algorithm.Union;

/**
 * Created by GPrabhu on 10/2/2014.
 */
public class UnionFind {
   int[] id =new int[10];
    int[] p={4,3,6,9,2};
    int[] q={3,8,5,4,1};
    int N=p.length;
    UnionFind(){
        for(int i=0;i<p.length;i++){
            id[i]=i;
        }
    }
    public static void main(String[] args) {
        int n=10;
        UnionFind uf=new UnionFind();
        for(int i=0;i<uf.p.length;i++){
            if(uf.connected(uf.p[i], uf.q[i])){
                uf.union(uf.p[i],uf.q[i]);
                System.out.println(uf.p+" "+uf.q);
            }
        }
    }

    private void union(int p, int q) {
        int pid=id[p];
        int qid=id[q];
        for(int count=0;count<N;count++){
            if(id[count]==p)
                id[count]=q;
        }
        id[p]= id[q];
    }

    private boolean connected(int p, int q) {
        return id[p]== id[q];
    }
}

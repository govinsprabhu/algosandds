package algorithms.problems.AlgorithmDesignAndAnalysis.Algorithm.Union;

/**
 * Created by GPrabhu on 10/3/2014.
 */
public class QuickUnion {
    int[] id =new int[10];
    int[] p={4,3,6,9,2};
    int[] q={3,8,5,4,1};
    int N=p.length;
    QuickUnion(){
        for(int i=0;i<p.length;i++){id[i]=i;}
     }
    public static void main(String[] args) {
        int n=10;
        QuickUnion uf=new QuickUnion();
        for(int i=0;i<uf.p.length;i++){
            if(uf.connected(uf.p[i], uf.q[i])){
                uf.union(uf.p[i],uf.q[i]);
                System.out.println(uf.p+" "+uf.q);
            }
        }
    }
    private int  findRoot(int i){
        while(id[i]!=i)i=id[i];
        return i;
    }

    private void union(int p, int q) {
        id[findRoot(p)]=findRoot(q);
    }

    private boolean connected(int p, int q) {
        return findRoot(p)== findRoot(q);
    }

}

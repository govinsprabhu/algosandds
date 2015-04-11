package algorithms.problems.AlgorithmDesignAndAnalysis.Algorithm.Union;

/**
 * Created by GPrabhu on 10/3/2014.
 */
public class QuickUnionImproved {
    int[] id = new int[10];
    int[] size = new int[10];
    int[] p = {4, 3, 6, 9, 2};
    int[] q = {3, 8, 5, 4, 1};
    int N = p.length;

    QuickUnionImproved() {
        for (int i = 0; i < p.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        QuickUnionImproved uf = new QuickUnionImproved();
        for (int i = 0; i < uf.p.length; i++) {
            if (uf.connected(uf.p[i], uf.q[i])) {
                uf.union(uf.p[i], uf.q[i]);
                System.out.println(uf.p + " " + uf.q);
            }
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private void union(int p, int q) {
        if (size[p] < size[q]) {
            id[root(p)] = root(q);
            size[q] += size[p];
        } else {
            id[root(q)] = root(p);
            size[p] += size[q];
        }
        id[root(p)] = root(q);
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}

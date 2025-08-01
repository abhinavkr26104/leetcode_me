import java.util.*;
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if (parent.get(node) != node) {
            parent.set(node, findPar(parent.get(node)));
        }
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) 
    {
       
        DisjointSet ds = new DisjointSet(n);
        int e=0;
        for(int i=0;i<connections.length;i++)
        {
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findPar(u)==ds.findPar(v))
            {
                e++;
            }
            else
            {
                ds.unionBySize(u, v);
            }
        }
        int nC=0;

        for (int i = 0; i < n; i++) {
            if(ds.parent.get(i)==i)
            nC++;
        }
        if(e>=(nC-1))
        {
            return nC-1;
        }
        return -1;




    
        
    }
}
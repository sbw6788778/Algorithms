package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeighedQuickUnionUF {
	private int [] a;
	private int N;
	private int [] sz;
	WeighedQuickUnionUF(int N){
		this.N=N;
		a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=i;
		sz=new int[N];
		for(int i=0;i<N;i++)
			sz[i]=1;
	}
	public void  union(int p,int q){
		int rootP=find(p);
		int rootQ=find(q);
		if(rootQ==rootP) return;
		if(sz[rootP]<sz[rootQ])
		{
			a[rootP]=rootQ;
			sz[rootQ]+=sz[rootP];
		}
		else{
			a[rootQ]=rootP;
			sz[rootP]+=sz[rootQ];
		}
		N--;
	}
	public int find(int p){
		while(p!=a[p]) p=a[p];
		return p;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int count(){
		return N;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		UF uf=new UF(N);
		while(!StdIn.isEmpty()){
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(uf.count()+"compinents");
			for (int l:uf.a)
				System.out.print(l);
			System.out.println("\n");
			
		}
	}

}

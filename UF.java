package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int [] a;
	private int N;
	UF(int N){
		this.N=N;
		a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=i;
	}
	public void  union(int p,int q){
		int idP=a[p];
		int idQ=a[q];
		if(connected(p,q))
			return;
		for(int i=0;i<a.length;i++){
			if(a[i]==idP)
				a[i]=idQ;}
		N--;
	}
	public int find(int p){
		return a[p];
	}
	public boolean connected(int p,int q){
		return a[p]==a[q];
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

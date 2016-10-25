package Algorithms;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfString<t> implements Iterable<t>{
	private t [] a;
	private int N;
	FixedCapacityStackOfString(int x){
	//指定栈顶的指针
		a=(t[])new Object[x];
	}
	public t pop(){
		t temp=a[--N];
		a[N]=null;//防止游离
		if(N>0&&N==a.length/4)
			resize(a.length/2);
		return temp;
	}
	public void push(t item){
		if(a.length==N)
			resize(2*N);
		a[N++]=item;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	private void resize(int max){
		t[] new_size=(t[])new Object[max];
		for(int i=0;i<a.length;i++){
			new_size[i]=a[i];
		}
		a=new_size;
	}
	public Iterator<t> iterator(){
		return new Iterator(){
			private int i=N;
			public boolean hasNext(){return i>0; }
			public t next(){return a[--i];}
			public void remove(){}
		};
	}
	
	public static void main(String[] args) {
		 FixedCapacityStackOfString<String> s=new  FixedCapacityStackOfString<String>(100);
		 while(!StdIn.isEmpty()){
			 String item=StdIn.readString();
			 if(!item.equals("-"))
				 s.push(item);
			 else if(!s.isEmpty())
				 StdOut.print(s.pop()+" ");
			 for(String d:s)
				 System.out.println(d);
		 }
		 StdOut.println("("+s.size()+"left on stack)");
		 
	}

}

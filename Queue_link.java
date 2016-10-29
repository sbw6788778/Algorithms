package Algorithms;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;
public class Queue_link<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int N;
	private class Node{
		T value;
		Node next;
	}
	public void enqueue( T value){
		Node oldLast=last;
		last=new Node();
		last.value=value;
		last.next=null;
		if(isEmpty())
			first=last;
		else oldLast.next=last;
		N++;
	}
	public T dequeue(){
		T a=first.value;
		first=first.next;
		if(isEmpty()) last=null;
		N--;
		return a;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public Iterator iterator(){
		return new Iterator(){
			private Node current=first;
			public boolean hasNext(){return current!=null; }
			public T next(){ 
				T v=current.value;
				current=current.next;
				return v;
			}
		};
	}
	
	public static void main(String[] args) {
	     Queue_link<String> stack=new Queue_link<String>();
		while(!StdIn.isEmpty()){
			String item=StdIn.readString();
			if(!item.equals("-"))
				stack.enqueue(item);
			else if(!stack.isEmpty()) System.out.println(stack.dequeue());
		}
		StdOut.println("("+stack.size()+"left on stsck)");
	}
}

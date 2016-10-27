package Algorithms;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Stack_link<T> {
	private int N;
	private Node first=new Node();
	private class Node{
		T value;
		Node next;
	}
	public void push(T value){
		Node oldFirst=first;
		first=new Node();
		first.value=value;
		first.next=oldFirst;
		N++;
	}
	public T pop(){
		T a=first.value;
		first=first.next;
		N--;
		return a; 
	}
	public boolean isEmpty(){
		return first==null;
	}
	public int size(){
		return N;
	}
	public static void main(String[] args) {
		Stack_link stack=new Stack_link();
		while(!StdIn.isEmpty()){
			String item=StdIn.readString();
			if(!item.equals("-"))
				stack.push(item);
			else if(!stack.isEmpty()) System.out.println(stack.pop());
		}
		StdOut.println("("+stack.size()+"left on stsck)");
	}
}

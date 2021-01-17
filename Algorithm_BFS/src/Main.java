import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
	
// DFS (깊이 우선 검색) : STATCK
// BFS (넓이 우선 검색) : QUEUE
	

// queue는 구현해서 사용
class Queue<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		} 
	}
	private Node<T> first;
	private Node<T> last;
	
	public void enqueue(T item) {
		Node<T> t = new Node<T>(item);
		
		if(last != null) {
			last.next = t;
		}
		last = t;	
		if(first == null){
			first = last;
			
		}
	}
	
	public T dequeue() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first ==null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

class Graph {
	class Node{
		int data;
		//인접한 노드들의 관계를 LinkedList로 표현
		LinkedList<Node> adjacent;
		boolean marked; // 방문했는지 검사
		Node (int data){ // 노드의 생성자에서는  데이터를 받고 마킹을 false초기화 linkedlist 준비
			this.data = data;  
			this.marked = false;
			adjacent = new LinkedList<Node>(); 
		}
	}
	Node[] nodes; 
	Graph(int size){
		nodes = new Node[size]; // 노드를 저장할 배열  
		for(int i=0;i<size;i++) { 
			nodes[i] = new Node(i); //배열 크기만큼 객체 생성 
		} 
	}
	
	//노드의 관계를 저장하는 메소드 
	void addEdge(int i1, int i2) { 
		Node n1 = nodes[i1];  // 데이터가 index와 같아서 받은수를 인덱스로 사용
		Node n2 = nodes[i2];
		//
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	void dfs() {
		dfs(0);
	}
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked=true;
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n: r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	void bfs() {
		bfs(0);
	}
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.dequeue();
			for (Node n: r.adjacent) {
				if(n.marked == false) {
				n.marked = true;
				queue.enqueue(n);
				}
			}
			visit(r);
		}
	}	
	
	// dfs 재귀함수 사용하는 부분 
	void dfsR(Node r) {
		if (r == null ) return;
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	
	void visit(Node n) {
		System.out.print(n.data+" ");
	}
}

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		//dfs 0부터 수행
		//g.dfs();
		//g.dfs(3);
		
		//bfs 0부터 수행
		//g.bfs();
		  
		//재귀함수이용
		//g.dfsR();
		
		
	}
}

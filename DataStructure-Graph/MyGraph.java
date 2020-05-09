import java.util.*;

class MyGraph<T> { 
  
  private int numberOfNodes;
  private HashMap<T, List<T>> adjacentList;

  public MyGraph() { 
    this.numberOfNodes = 0;
    this.adjacentList = new HashMap<>(); 
  } 
  
  public void addVertex(T node) { 
    if(!adjacentList.containsKey(node)){
      adjacentList.put(node, new LinkedList<T>());
      numberOfNodes++;
    }
  }

  public void addEdge(T node1, T node2) {
    if (!adjacentList.containsKey(node1))
      addVertex(node1); 
    if (!adjacentList.containsKey(node2))
      addVertex(node2); 
    // undirected
    adjacentList.get(node1).add(node2);
    adjacentList.get(node2).add(node1);
  } 
  public void showConnections() { 
    Set<T> allNodes = adjacentList.keySet();
    for (T node: allNodes) { 
      List<T> nodeConnections = this.adjacentList.get(node); 
      String connections = ""; 

      for (T vertex: nodeConnections) {
        connections += vertex + " ";
      } 
      System.out.println(node + "-->" + connections); 
    } 
  }


  public static void main(String[] args){
    MyGraph<Integer> myGraph = new MyGraph<>();
    myGraph.addVertex(0);
    myGraph.addVertex(1);
    myGraph.addVertex(2);
    myGraph.addVertex(3);
    myGraph.addVertex(4);
    myGraph.addVertex(5);
    myGraph.addVertex(6);
    myGraph.addEdge(3, 1); 
    myGraph.addEdge(3, 4); 
    myGraph.addEdge(4, 2); 
    myGraph.addEdge(4, 5); 
    myGraph.addEdge(1, 2); 
    myGraph.addEdge(1, 0); 
    myGraph.addEdge(0, 2); 
    myGraph.addEdge(6, 5);
    myGraph.showConnections(); 
    MyGraph<Character> myGraph2 = new MyGraph<>();
    myGraph2.addVertex('A');
    myGraph2.addVertex('B');
    myGraph2.addVertex('C');
    myGraph2.addVertex('D');
    myGraph2.addVertex('E');
    myGraph2.addVertex('F');
    myGraph2.addVertex('G');
    myGraph2.addEdge('D', 'B'); 
    myGraph2.addEdge('D', 'E'); 
    myGraph2.addEdge('E', 'C'); 
    myGraph2.addEdge('E', 'F'); 
    myGraph2.addEdge('B', 'C'); 
    myGraph2.addEdge('B', 'A'); 
    myGraph2.addEdge('A', 'C'); 
    myGraph2.addEdge('G', 'F');
    myGraph2.showConnections(); 
  }
} 

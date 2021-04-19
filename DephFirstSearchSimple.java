import java.util.*;
public class Code {
  public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
    
    List<Vertex> list = new ArrayList<>();
    
    v1.addNeighbour(v2);
    v1.addNeighbour(v3);
    
    v3.addNeighbour(v4);
    v4.addNeighbour(v5);
    
    list.add(v1);
    list.add(v2);
    list.add(v3);
    list.add(v4);
    list.add(v5);
    
    DepthFirstSearch d = new DepthFirstSearch();
    d.dfs(list);
  }
  
  static class DepthFirstSearch {
    private Stack<Vertex> stack;
    
    public DepthFirstSearch() {
      this.stack = new Stack<>();
    }
    
    public void dfs(List<Vertex> vertexList) {
      for(Vertex v : vertexList) {
        if(!v.isVisited()) {
          v.setVisited(true);
          dfsWithStack(v);
        }
       }
    }
    
    private void dfsWithStack(Vertex rootVertex) {
			this.stack.add(rootVertex);
      rootVertex.setVisited(true);
      
      while(!this.stack.isEmpty()) {
        Vertex actualVertex = this.stack.pop();
        System.out.print(actualVertex + " ");
        
        for(Vertex v : actualVertex.getNeighbourList()) {
          if(!v.isVisited()) {
            v.setVisited(true);
            this.stack.push(v);
          }
        }
      }
    }
  }
  
  static class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> neighbourList;
    
    public Vertex(String name) {
      this.name = name;
      this.neighbourList = new ArrayList<>();
    }
    
    public List<Vertex> getNeighbourList() {
      return this.neighbourList;
    }
    
    public void addNeighbour(Vertex vertex) {
      this.neighbourList.add(vertex);
    }
    
    public void setName(String name) {
      this.name = name;           
    }
    
    public String getName() {
      return this.name;
    }
    
    public void setVisited(boolean visited) {
      this.visited = visited;
    }
    
    public boolean isVisited() {
      return this.visited;
    }
    
    @Override
    public String toString() {
      return this.name;
    }
  }
}

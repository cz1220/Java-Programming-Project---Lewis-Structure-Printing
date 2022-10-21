
public class LewisTreePrinting<E> {


	private static class Node<E> {
	
	    
	    private E element;              
	    private Node<E> east;           
	    private Node<E> west;            
	    private Node<E> north; 
	    private Node<E> south; 
	
	    public Node(E e, Node<E> N, Node<E> S, Node<E> E, Node<E> W) {
	      element = e;
	      north = N;
	      south = S;
	      east = E; 
	      west = W;  
	    }
	  
	 
	    //getters
	
	    public E getElement() { 
	    	return element; 
	    }
	
	
	    public Node<E> getEast() {
	    	return east; 
	    }
	
	
	    public Node<E> getWest() { 
	    	return west; 
	    }
	   
	    public Node<E> getSouth() { 
	    	return south;
	    }
	    
	    public Node<E> getNorth() { 
	    	return north;
	    }
	    
	
	  //setters
	
	    public void setNorth(Node<E> N) { 
	    	north = N; 
	    }
	
	    public void setSouth(Node<E> S) { 
	    	south = S; 
	    }
	
	    public void setEast(Node<E> E) { 
	    	east = E; 
	    }
	    
	    public void setWest(Node<E> W) {
	    	west = W; 
	    }
	      
	    
	  } //end of nested node class

  private Node<E> root;                    
  private Node<E> position;                  
  
  public LewisTreePrinting() {

           
  }
  
  public void setRoot(E element) {
	  this.root =  new Node<E>(element, null, null, null, null);   
	  this.position = root; 
  }


 

  
  public void Add(E letter, String direction) {
	  Node<E> add = new Node<E>(letter, null, null,null, null); 
	  
	  if (position == null) {
		  System.out.println("Position does not exist"); 
	  }
	  
	  else if (direction.equalsIgnoreCase("North") ) {
		  position.setNorth(add);
		  add.setSouth(position);
	  }
	  
	  else if (direction.equalsIgnoreCase("South") ) {
		  position.setSouth(add);
		  add.setNorth(position);
	  }
	  
	  else if (direction.equalsIgnoreCase("East")) {
		  position.setEast(add);
		  add.setWest(position);
	  }
	  
	  else if (direction.equalsIgnoreCase("West")) {
		  position.setWest(add);
		  add.setEast(position);
	  }
	  
	  position = add; 
	
  }
  
  public void Move(String direction) {
	  if (direction == "North" && position.getNorth() != null) {
		  position = position.getNorth(); 
	  }

	  
	  else if (direction == "South" && position.getSouth() != null) {
		  position = position.getSouth(); 
	  }
	  
	  else if (direction == "East" && position.getEast() != null) {
		  position = position.getEast(); 
	  }
	  
	  else if (direction == "West" && position.getWest() != null) {
		  position = position.getWest(); 
	  }
  }
  
  
  public void PrintNode(Node<E> node, String directionfrom) {
	  System.out.print(node.getElement().toString()); 
	  
	  if(node.getNorth()!= null && !directionfrom.equalsIgnoreCase("North")) {
		  PrintNode(node.getNorth(), "South"); 
	  }
	  if(node.getSouth()!= null && !directionfrom.equalsIgnoreCase("South")) {
		  PrintNode(node.getSouth(), "North");
	  }
	  if(node.getWest()!= null && !directionfrom.equalsIgnoreCase("West")) {
		  PrintNode(node.getWest(), "East");
	  }
	  
	  if(node.getEast()!= null && !directionfrom.equalsIgnoreCase("East")) {
		  PrintNode(node.getEast(), "West");
	  }
	 
  }
  
  
  
  
  
 public void Print() {
	 System.out.print(root.getElement().toString()); 
	 
	 if (root.getEast() != null) {
		 PrintNode(root.getEast(), "West"); 
		 	 
	 }
	 
	 if(root.getWest()!= null) {
		 PrintNode(root.getWest(),"East"); 
	 }
	 
	 if(root.getSouth()!= null) {
		 PrintNode(root.getSouth(),"North");  
	 }
	 
	 if(root.getNorth()!= null) {
		 PrintNode(root.getNorth(),"South");  
	 }
	 System.out.println();
 }
 
  
} 

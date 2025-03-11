package algoProje;


public class Node {
	// degiskenlerimiz
	
	private Student data; // getData bilgilere ulasmamizi saglicak
	private Node next; // getNext bir sonraki node'ye gecmemizi saglicak
	private Node previous; // getPrevious bir onceki node'ye donmemizi saglicak
	
	// constructor
	public Node(Student data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	// sadece data parametresini alan constructor
    public Node(Student data) {
        this(data, null, null);
    } 
    
    
	// getter setter
	
	public Student getData() {
		return data;
	}

	public void setData(Student data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	
	
}

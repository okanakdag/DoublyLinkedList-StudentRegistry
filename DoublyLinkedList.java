package algoProje;

public class DoublyLinkedList {
	// degiskenlerimi
	private Node head = null; // cift bagli listenin basi
	private Node tail = null; // cift bagli listenin sonu
	

	// numara sirasina gore ekleme metodu
	public void add(Student newStudent) {
		// liste bossa bu blokta eklenecek
		if(isEmpty()) {
			head = tail = new Node(newStudent);
			return;
		}

		Node newNode = new Node(newStudent);
		int newStudentNumber = newStudent.getOgrNo();
		Node current = head;

		Boolean added = false;
		while(!added) {
			// yeni numara büyükse node current'ın önüne eklenir
			if (newStudentNumber > current.getData().getOgrNo()) {
				
				Node previousNode = current.getPrevious();
				newNode.setNext(current);
				current.setPrevious(newNode);

				if (previousNode != null) {
					newNode.setPrevious(previousNode);
					previousNode.setNext(newNode);
				}
				else {
					head = newNode;
				}

				added = true;
			}
			// liste bittiyse yeni node sona eklenir
			else if(current.getNext() == null) {
				tail.setNext(newNode);
				newNode.setPrevious(current);
				tail = newNode;
				added = true;
			}
			// current guncellenir
			else {
				current = current.getNext();
			}

		}
	}
	
	
	// Adi ve soyadi verilen bir ogrenciyi listede arayarak eger varsa bu ogrencinin (varsa ayni ad ve soyada sahip diger ogrencilerin de bilgilerini yazdiran metot
	public void printStudent(String adSoyad){
		// liste bos ise mesaji yazdirir
		if(isEmpty()){
			System.out.println("List is empty");
			return;
		}

		Node current = head;
		// ogrenci bulunamama durumu icin degisken olusturduk
		// eger ogrenci bulunursa true olacak
		boolean studentFound = false;

		while(current != null){
			// girilen ogrenci listemizde varsa yazdirilacaktir
			if(current.getData().getAdSoyad().replaceAll("\\s+","").toUpperCase().equals(adSoyad)){
				System.out.println(current.getData());
				// ogrenci bulunduysa degiskenimiz true donecek
				studentFound = true;
			}
			current = current.getNext();
		}
		// ogrenci bulunamama durumunda bu bloga girecek
		if(!studentFound){
			System.out.println("Student not Found");
		}
		
	}
	
	// numarasi verilen ogrenciyi silme isini yapan metod
	public void remove(int ogrNo) {
		// liste bos ise mesaji yazdirir
		if(isEmpty()){
			System.out.println("List is empty");
			return;
		}
		// listenin tek elemaniysa bu bloga girecek
		else if(head == tail) {
			head = tail = null;
			return;
		}
		
		// listenin tek elemani degilse de bu bloga girer
		else{
			Node current = head;
		
			Boolean removed = false;
		
			while(!removed) {
				// eslesme varsa node cikarilir
				if (ogrNo == current.getData().getOgrNo()) {
					Node next = current.getNext();
					Node previous = current.getPrevious();

					// head cikariliyosa
					if (current == head) {
						next.setPrevious(null);
						head = next;
					}

					// tail cikariliyosa
					else if (current == tail) {
						previous.setNext(null);
						tail = previous;
					}

					else {
						previous.setNext(next);
						next.setPrevious(previous);
					}
					removed = true;
				}
			
				// eslesme yoksa current ilerler
				else {
					current = current.getNext();
				}
			}
		}
	}
		
	
	// ogrenci numarasina gore artan sirada yazdiran metod
	public void descendingOrder(){
		if(isEmpty()){
			System.out.println("List is empty!");
			return;
		}
		else{
			Node current = head;
			while(current != null){
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}
	
	// ogrenci numarasina gore azalan sirada yazdiran metod
	public void ascendingOrder(){
		if(isEmpty()){
			System.out.println("List is empty");
		}
		else{
			Node current = tail;
			while(current != null){
				System.out.println(current.getData());
				current = current.getPrevious();
			}
		}
	}
	
	
	// Liste bossa true degilse false donecektir
	public boolean isEmpty(){
		return (head == null);
	}
}

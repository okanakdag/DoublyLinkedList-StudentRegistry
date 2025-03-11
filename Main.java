package algoProje;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
	    Scanner input = new Scanner(System.in);
        Scanner stringScanner;
	    System.out.println(
	    		"\nWelcome to the Program!!!"+
                "\nOperations:" +
                "\n1) Read the student.txt file and fill the list."+
                "\n2) Enter student from keyboard."+
                "\n3) Search student with name."+
                "\n4) Delete student from the list."+
                "\n5) Print list in ascending order."+
                "\n6) Print list in descending order."+
                "\n7) Exit.");
	    
	    boolean donguDegiskeni = true;
	    
	    while(donguDegiskeni){
            System.out.print("Enter the operation you want to do (1-7): ");
            int choice = input.nextInt(); // kullanicin secimini tutmak icin choice degiskeni olusturdum
            
            if(choice == 1){
                
                Scanner file = null; 
                try {
                    file = new Scanner(new FileInputStream("students.txt"));
                } catch (FileNotFoundException e) {
                    System.out.println("File is not found.");
                    System.out.println("Terminating the program.");
                    System.exit(0);
                }
                while (file.hasNext()) {
                    String line = file.nextLine();    
                    stringScanner = new Scanner(line); 
                    stringScanner.useDelimiter(",");   
                    String ogrNo = stringScanner.next();                          
                    String adSoyad = stringScanner.next();
                    adSoyad = adSoyad.replaceAll("\\s+","");
                    int newOgrNo = Integer.parseInt(ogrNo);
                    Student student = new Student(newOgrNo, adSoyad); 
                
                    while (stringScanner.hasNext()) {
                        student.addNumber(stringScanner.next());  
                    }
                    doublyLinkedList.add(student);  
                }
                System.out.println("List is created."); 
            	
            }
            
            else if(choice == 2){
            	
                String _gunahkecisi = input.nextLine();
                
                System.out.println("Enter the name and surname of the student you want to add: ");
                String adSoyad = input.nextLine();

            	
                System.out.println("Enter the student number of the student you want to add: ");
                String ogrNo = input.nextLine(); 
             
                // degisken donusumu yaparak ogrNo'yu int'e cevirdik
                int newOgrNo = Integer.parseInt(ogrNo);
                Student student = new Student(newOgrNo, adSoyad); // student tipinde nesne olusturduk  
                // bu nesneyi add metoduyla listemize ekleyecegiz
                System.out.println("Enter the phone numbers of the student you want to add (separated by ','): ");
                String numbers = input.nextLine();                  
                stringScanner = new Scanner(numbers);    
                stringScanner.useDelimiter(",");        
                while (stringScanner.hasNext()) {
                   student.addNumber(stringScanner.nextLine());
                }
                doublyLinkedList.add(student);  // // Student tipindeki nesne linked liste eklenir.
                System.out.println("Student is added succesfully.");
            }
            
            else if(choice == 3){
            	// adSoy'i girilen ogrenci veya ogrencileri yazdiran metod

                String _gunahkecisi = input.nextLine();
                
                System.out.println("Name and surname of the student you want to search: ");
                String adSoyad = input.nextLine();
                adSoyad = adSoyad.replaceAll("\\s+","");
                adSoyad = adSoyad.toUpperCase();
                doublyLinkedList.printStudent(adSoyad);
            	
            }
            
            else if(choice == 4){
            	// ogrenci numarasi girilen ogrenciyi listeden cikaran metod
                System.out.print("Student Number of the student you want to delete from the list: ");
                int ogrNo = input.nextInt();
                doublyLinkedList.remove(ogrNo);
            }
          	         	
            else if(choice == 5){
            	// listeyi ogrNo'ya gore artan sirada yazdiran metod
            	System.out.println("");
            	doublyLinkedList.descendingOrder();
            }

            else if(choice == 6){
            	// listeyi ogrNo'ya gore azalan sirada yazdiran metod
            	System.out.println("");
            	doublyLinkedList.ascendingOrder();
            }

            else if(choice == 7){
                System.out.println("Terminating the program...");
            	donguDegiskeni = false;
            }
            
            else{
            	System.out.println("Invalid input.\n Please key in again...");
            }
            
	    }
        
        input.close();
	
	}
	
}
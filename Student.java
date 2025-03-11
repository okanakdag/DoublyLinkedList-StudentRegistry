package algoProje;

import java.util.ArrayList;

public class Student {
	// degiskenlerimizi tanimladik
	// tabii ki de disardan erisilemesin diye private olarak tanimladik
	private int ogrNo;
	private String adSoyad;
	private ArrayList<String> phoneNumbers;
	
	// constructor
	public Student(int ogrNo, String adSoyad) {
		this.ogrNo = ogrNo;
		this.adSoyad = adSoyad;
		this.phoneNumbers = new ArrayList<>();
	}
	
	// getters and setters
	public int getOgrNo() {
		return ogrNo;
	}
	public void setOgrNo(int ogrNo) {
		this.ogrNo = ogrNo;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	} 
	
	// override ettigimiz toString metodu
    public String toString() {
        return ("Student number: " +ogrNo +" Name: "+ adSoyad +" Phone number: "+ phoneNumbers);
    }

    
    
    // telefon numaralirini  arrayList'e eklememizi saglayan metod   
    public void addNumber(String number) {
        phoneNumbers.add(number);
    }

}


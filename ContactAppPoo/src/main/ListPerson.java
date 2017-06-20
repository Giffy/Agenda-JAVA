package main;

import java.util.Arrays;

public class ListPerson {
	
	private Person[] contacts;

	
	public ListPerson(String[] strContacts){
		iniContact(strContacts); 
	}
	
	private void iniContact(String[] strContacts) {
		contacts = new Person[strContacts.length]; 
		  
		  for(int i=0; i<strContacts.length; i++){
			  String contactFileFormat = strContacts [i]; 
			  Person contact = new Person(contactFileFormat);
		      //add(contact); 
			  contacts[i] = contact;  
		  }
	}


	/**
	 * Retorna el numero de personas que contiene
	 * @return
	 */
	public int size() {
		return contacts.length;
	}

	/**
	 * Obtiene la persona que tiene el index i 
	 * @param i
	 * @return
	 */
	public Person get(int i) {
		return contacts[i];
	}
	
	/** Sobre escribe una persona de la lista en el index dado por index 
	 * @param person
	 * @param index
	 */
	public void set(Person person, int index){
		// TODO Auto-generated method stub
		contacts[index]= person;
			
	}
	
	/**
	 * Retorna el index del objeto person 
	 * @param person
	 * @return
	 */
	public int indexOf(Person person){
		int index = -1; 
		for(int i=0; i<contacts.length; i++){
			if(contacts[i].equals(person)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}

	/**
	 * Adiciona una persona al arreglo interno de personas. 
	 * Se adiciona en la ultima posicion
	 * @param contact
	 */
	public void add(Person contact) {			
		
		System.out.println(contact);
		
			
		Person[] copyContacts = new Person[contacts.length+1];	
		for(int i=0;i<contacts.length;i++){
			copyContacts[i]=contacts[i];
		}
		
		
		
		
		//contacts = copyContacts;
	}
	
	
	/**
	 * Elimina una persona del la lista
	 * @param person
	 */
	public void remove(Person person) {
		int index = indexOf(person);
		remove (index);	
	}
	public void remove(int index) {
				
		if (index<0 || index>= contacts.length){
			    System.out.println("error");  								// error
		}else{
				Person[] contactsCopy = new Person [contacts.length-1];
				for (int i=0; i<contactsCopy.length; i++){
					if (i<index){
						contactsCopy[i]=contacts[i];
					}else{
						contactsCopy[i]=contacts[i+1];
					}
				}
				contacts = contactsCopy;
		
		}		
		
		return;
	}
	
	/**
	 * Retorna todas las personas que coontengan strString en su campo name
	 * @return
	 */
	public Person[] findByName(String strName){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		
		for(Person person: contacts){
			if(person.getName().contains(strName))
				array[counter++]=person; 
		}
		
		Person personsWidthName[] = new Person[counter];  
		
		for(int i=0,k=0; i<array.length; i++){
			if(contacts[i].getName().contains(strName))
				personsWidthName[k++]=contacts[i];
		}
		
	 return personsWidthName;	
	}

	/**
	 * Retorna todas las personas que coontengan strMail en su campo email
	 * @return
	 */
	public Person[] findByEmail(String strMail){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		
		// for each
		// for (int i=0; i<contacts.length; i++){
		// Person person = contact [i];
		// }
		
		for(Person person: contacts){
			if(person.getEmail().contains(strMail))
				array[counter++]=person; 
		}
		
		Person personsWidthEmail[] = new Person[counter];  
		for(int i=0,k=0; i<contacts.length; i++){
			if(contacts[i].getEmail().contains(strMail))
				personsWidthEmail[k++]=contacts[i];
		}
		
	 return personsWidthEmail;
	}
	
	/**
	 * Retorna una copia de la lista ordenada alfabeticamente
	 * @return
	 */
	public Person[] sort(){		
    	String[] namesOrdenados= new String [contacts.length];
    	Person[] listSort = new Person[contacts.length]; 
    	    	
    	for (int i=0; i<contacts.length; i++){								
    	  	    namesOrdenados [i] = contacts[i].getFullName(); 
    	}
    	
    	Arrays.sort(namesOrdenados);	
    	
       	listSort = findByFullName (namesOrdenados);
    	  
		return listSort;
		
			
	}
	private Person[] findByFullName (String[] namesOrdenados ){
    	
    	Person[] listSort = new Person[contacts.length]; 
    	
    	for (int k=0; k<namesOrdenados.length; k++){
    		for (int i=0; i<contacts.length; i++)
		      	if (namesOrdenados[k].equals( contacts[i].getFullName())){
		      		listSort[k]  =  contacts[i];
		      	}
		}
    		
    	return listSort;
  	}
    	   
	/**
	 * Retorna una copia de la lista 
	 * @return
	 */
	
	public Person[] getList(){
		Person[] listCopy = new Person[contacts.length]; 
		for (int i=0; i<contacts.length; i++){								
		  	    listCopy [i] = contacts[i]; 
		}
		return listCopy;
	}

	public String[] toFileFormat() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

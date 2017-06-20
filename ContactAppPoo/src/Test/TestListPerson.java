package Test;

import org.junit.Assert;
import org.junit.Test;

import util.FileHelper;
import main.ListPerson;
import main.Person;

public class TestListPerson {

	@Test	
	public void testContructorList(){
		
	
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
	    ListPerson list = new ListPerson(strContacts ); 
	     
		 Assert.assertEquals(strContacts.length,list.size());
		 Person person = list.get(0);  
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getEmail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress()); 
		
	}
	
	
	@Test	
	public void testAddList(){
		
		String strContactAdd= "Pablo Marmol; 0034123456789; pedro@pica.com;Marmol 47";
		
		String[] strNewList= new String[] 
				{"Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"};
		
		ListPerson list = new ListPerson(strNewList);	
		Person newPerson = new Person(strContactAdd);
		list.add(newPerson);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	@Test	
	public void testFindByMail(){
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String strContact2= "Pablo Madrmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		String strMail="pablo@pica.com";
		
		ListPerson list = new ListPerson(strContacts);
		
		Person[] index= list.findByEmail(strMail);
		
		Assert.assertEquals(2, index.length);
		Assert.assertEquals("pablo@pica.com", index[0].getEmail());
		Assert.assertEquals("pablo@pica.com", index[1].getEmail());
				
	}

	@Test	
	public void testFindByName(){
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String strContact2= "Pablo Madrmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		String strName="Pablo";
		
		ListPerson list = new ListPerson(strContacts);
		
		Person[] index= list.findByName(strName);
		
		Assert.assertEquals(2, index.length);
		Assert.assertEquals("Pablo", index[0].getName());
		Assert.assertEquals("Pablo", index[1].getName());
				
	}

	@Test	
	public void testSort(){
		String strContact0= "cPedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "dPablo Marmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String strContact2= "bPablo Madrmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		Person[] index= list.sort();
		
		Assert.assertEquals(3, index.length);
		Assert.assertEquals("bPablo", index[0].getName());
		Assert.assertEquals("cPedro", index[1].getName());
		Assert.assertEquals("dPablo", index[2].getName());
				
	}
	

	@Test	
	public void testRemove(){
		String strContact0= "cPedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "dPablo Marmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String strContact2= "bPablo Madrmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		Assert.assertEquals(3 , list.size());
		Assert.assertEquals("cPedro", list.get(0).getName());
		Assert.assertEquals("dPablo", list.get(1).getName());
		
		
		int index = 1;
		list.remove(index);
		
		Assert.assertEquals(2 , list.size());
		Assert.assertEquals("cPedro", list.get(0).getName());
		Assert.assertEquals("bPablo", list.get(1).getName());
		
				
	}
	

	@Test	
	public void testSet(){
		String strContact0= "cPedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "dPablo Marmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String strContact2= "bPablo Madrmol; 003412415700;pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		String newContact= "Jordi Marmol; 003412415700;pablo@pica.com;Marmol 46";
		
		Person newPerson= new Person(newContact);
				
		int index = 1;
		list.set(newPerson, index);
				
		Assert.assertEquals(3 , list.size());
		Assert.assertEquals("cPedro", list.get(0).getName());
		Assert.assertEquals("Jordi", list.get(1).getName());
					
	}
	
	
}

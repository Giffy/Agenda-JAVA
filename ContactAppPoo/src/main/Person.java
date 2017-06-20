package main;

public class Person {
	
	private String name; 
	private String surname; 
	private String phone; 
	private String email; 
	private String address;
	
	/**
	 * Inicia las variables del objeto a partir de una cadena con formato:
	 * format:  name surname;phone;email;address
	 *  
	 * @param contactFileFormat  String con formato 
	 */
	public Person(String contactFileFormat) { 
	
		String[] values = contactFileFormat.split(";"); 
		if(values.length<4)
			throw new RuntimeException("Formato incorrecto en contactFileFormat"); 
		
		String[] fullname = values[0].split(" "); 
		String nombre = fullname.length==2?fullname [0]:values[0];
		String apellido  = fullname.length==2?fullname [1]:""; 
		
		this.name = nombre;
		this.surname = apellido; 
		
		setPhone(values[1]);
		setEmail(values[2]);
		setAddress(values[3]);	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
			this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	@Override
	public String toString(){	 	
		return "\n\t\t" + name  + " " + surname + "\t\t" + phone + "\t\t" + email + "\t\t" + phone + "\t\t"  + address;	
	}

	public String toFileFormat(){
		return  this.name + " " + this.surname + ";" + this.phone + ";" + this.email + ";" + this.address; 
	}
	

	@Override
	public boolean equals(Object obj) {
	    boolean r=false; 
		Person person = (Person) obj; 	
		if(this.name.equals(person.getName())&& 
				this.surname.equals(person.getSurname())&& 
					this.phone.equals(person.getPhone()) &&	
						this.email.equals(person.getEmail())  &&	
						  this.address.equals(person.getAddress()) 
							){
			r = true; 
		}
		return r; 
	}

	
	public String getFullName(){
		String FullName = name + " " + surname;
		return FullName;
	}


	

}
package main;

import util.Input;

public class UserInterface {
	
	
	public static void menu(){
		System.out.println(	"\t\t\t\t -----  Agenda de contactos  ----- \t\n\n"
							+ "\tElige las opciones tecleando una numero o la palabra Salir para cerrar la agenda:\n\n"
						// 	+ "\n\t\t\t\t a  :  Adicionar un contacto"
							+ "\n\t\t\t\t lc :  Listar todos los contactos almacenados"
							+ "\n\t\t\t\t lo :  Listar ordenados por nombre"
							+ "\n\t\t\t\t bn :  Buscar por nombre"
							+ "\n\t\t\t\t be :  Buscar por email"
						//	+ "\n\t\t\t\t e  :  Editar contacto"
							+ "\n\t\t\t\t r  :  Eliminar un contacto"
							+ "\n\t\t\t\t menu  :  Para volver a ver el menu"
							+ "\n\n\t\t\t\t Salir :  Para cerrar la agenda y guardar cambios"
							+ "\n\n\n\tTeclea una opcion:");		
	}
	
	private static void encabezado(){
		System.out.println( "\nReferencia\t Nombre \t\t\tTelefono\t\tE-Mail\t\t\tDireccion");
	}

	public static String scannContact(){
		
		
		//Pantalla de Nuevo registro
				String[] registro;
				registro = new String [4];
				
				System.out.println("\t\t\t\t -----  Agenda de contactos  ----- \t\n\n");
				System.out.println("\tUn contacto debe tener la siguiente informacion:\n");
				System.out.println("\t\t\t\t - Nombre y apellido");
				System.out.println("\t\t\t\t - Telefono");
				System.out.println("\t\t\t\t - Email");
				System.out.println("\t\t\t\t - Direccion");
				
								
				// Adicionar un nuevo registro		
				System.out.println("\n\n\t \t Nombre y apellidos:");
				registro[0]= String.valueOf(util.Input.scannLine());
				System.out.println("\t \t Telefono:");
				registro[1]= String.valueOf(util.Input.scannLine());
				System.out.println("\t \t Email");
				registro[2]= String.valueOf(util.Input.scannLine());
				System.out.println("\t \t Direccion");
				registro[3]= String.valueOf(util.Input.scannLine());
					
				return registro[0] + ';' + registro[1] + ';' + registro[2] + ';' + registro[3] ;		
	}

	
	public static Person scannPerson(){
		String contact = scannContact(); 
		return new Person(contact); 
	}
	
	
	public static String scannOption() {
		String key= util.Input.scannLine();
		return key;
	}

	public static void showList( Person[] list) {
		System.out.println(	"\n\n\t\t\t\t -----  Agenda de contactos  ----- \t\n\n");
		encabezado();
		for (int i=0; i<list.length; i++){
			Person person=list[i];
			int counter= i+1;
			System.out.println(counter + "\t\t" + person.getFullName() + "\t\t" + person.getPhone() + "\t\t" + person.getEmail() + "\t\t" + person.getAddress() );			
		}
	}
	
	public static String findName() {
		System.out.print ( "Escribe el nombre a buscar: " );
		String key= util.Input.scannLine();
		return key;
	}

	
	public static String findEmail() {
		System.out.print ( "Escribe el E-mail a buscar: " );
		String key= util.Input.scannLine();
		return key;
	}
	
	public static int idBorrar() {
		System.out.print ( "Escribe la referencia del contacto a borrar: " );
		int id= util.Input.scannInt();
		return id;
	}
	
	public static int idModificar() {
		System.out.print ( "\nEscribe la referencia del contacto a modificar: " );
		int id= util.Input.scannInt();
		return id;
	}

	/* public static void modifyName(String list int id) {
		// TODO Auto-generated method stub
		Person person=list[id];
		
		System.out.print ( "\nQuieres modificar el nombre : " +    "Pablo Marmol ?");
		String key= util.Input.scannLine();
		switch (key){
		case "Y": 
				System.out.print ( "Escribe el nuevo nombre y apellido");
				String nombre= util.Input.scannLine();
				if (nombre!=""){
					
				}else{
					key="";
					break;
				};
		case "N":  System.out.print ( "No cambios");break;
		default: break;			
		}}
		
		// return id;
	}*/
	
}
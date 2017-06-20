package main;

import util.FileHelper;

public class ContactApp {

	 private static final String FILE_NAME = "agenda.txt";

	/**
	 * Desarrolle una aplicacion para guardar contactos, la aplicacion
	 * debe permitir
	 * 		- Adidionar un contacto
	 * 		- Listar todos los contactos almacenados
	 * 		- Listar ordenados por nombre
	 * 		- Buscar por nombre
	 * 		- Buscar por email
	 * 		- Editar contacto
	 * 		- Eliminar un contacto
	 *  
	 *  Un contacto debe tener la siguiente informacion:
	 *  	- Nombre
	 *  	- Telefono
	 *  	- Email
	 *  
	 * @param args
	 */

	public static void main(String[] args) {
	
	    UserInterface.menu();
		String[] strContacts = FileHelper.readFile(FILE_NAME); 
		ListPerson list = new ListPerson(strContacts); 
		boolean exit=false; 

		do{
			String key = UserInterface.scannOption();

			switch (key) {
				case "menu":  											// Adidionar un contacto
				UserInterface.menu(); 
				break;
				
				case "a":  											// Adidionar un contacto
					
					list.add(UserInterface.scannPerson());
					//UserInterface.showList(list.getList() );		// Listar contactos	
					FileHelper.writeFile(list.toFileFormat(),FILE_NAME); 
					
					break;

				case "r":  											// Eliminar un contacto
					UserInterface.showList(list.getList() );		// Listar contactos
					int id = UserInterface.idBorrar();				// Preguntar referencia del contacto a borrar
					list.remove(id-1);								// Borrar contacto
					UserInterface.showList(list.getList() );		// Listar contactos		
					break;

				case "lc":											// Listar todos los contactos almacenados
					UserInterface.showList(list.getList() );
					break;

				case "lo":											// Listar ordenados por nombre
					UserInterface.showList(list.sort());
					break;
					
				case "bn":												// Buscar por nombre
					String name = UserInterface.findName();				// Pregunta el nombre a buscar	
					Person[] indexName= list.findByName(name);
					UserInterface.showList(indexName );
					break;
				
				case "be":												// Buscar por email
					// TODO
					String email = UserInterface.findEmail();			// Pregunta el E-mail a buscar
					Person[] indexMail= list.findByEmail(email);		// Buscar coincicencias
					UserInterface.showList(indexMail );					// Mostrar lista de E-mail encontrados
					break;
					
					
				case "e":										// Editar contacto
					// TODO
					UserInterface.showList(list.getList());		// Mostrar lista
					int id2= UserInterface.idModificar();		// Preguntar id a modificar
					System.out.print(list.get(id2-1));			// Mostrar lista
					
					// UserInterface.modifyName(list.toFileFormat(), id2-1 );		// Preguntar cambiar nombre
					
					//  mostrar el registro
					//  preguntar si cambiar name
					//  preguntar si cambiar phone
					//  preguntar si cambiar email
					//  preguntar si cambiar address
					break;
		
				case "Salir":
					FileHelper.writeFile(strContacts, "agenda.txt");
					exit = true; 
					break;
					
				case "salir":
					FileHelper.writeFile(strContacts, "agenda.txt");
					exit = true; 
					break;
					
				default:
					break;

				}

		}while(!exit);  
	}
}
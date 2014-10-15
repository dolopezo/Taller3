package forum
import java.lang.Object

class Forum {
	
    String name
    Date dateCreated
    String category

    static constraints = {

        name(minSize: 3, maxSize: 20, unique: true, blank: false)
        //Aqu� hay un problema, no se crea un campo para 
        //dateCreated, sino que autom�ticamente Grails le asigna
        //la fecha actual a la creaci�n del objeto de este tipo
        dateCreated(min: new Date())
        category(minSize: 3, maxSize: 15, blank: false)

    }
}

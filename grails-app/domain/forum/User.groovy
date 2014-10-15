package forum

class User {

    String name
    String lastName
    int age
    String username
    String password

    static constraints = {

	//By default Grails does not allow null values for properties
        name(blank: false, minSize: 3, maxSize: 50)
        lastName(blank: false, minSize: 3, maxSize: 50)
        age(blank: false,min: 13)
        username(blank: false, unique: true)
        password(blank: false, matches: "(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{8,}") //hacer un match con una expresión regular

    }
}

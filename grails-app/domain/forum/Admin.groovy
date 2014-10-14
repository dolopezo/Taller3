package forum

class Admin extends User {

    int level
    double rating

    static constraints = {

        level(range:1..5)
        rating(DoubleRange:0..100)
		

    }
}    


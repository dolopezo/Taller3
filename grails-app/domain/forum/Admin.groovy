package forum

class Admin extends User {

    int level
    double rating

    static constraints = {

        level(min: 1, max: 5)
        rating(min: 0 as double, max: 100 as double)

    }
}

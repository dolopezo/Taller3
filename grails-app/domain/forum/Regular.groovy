package forum

class Regular extends User{

    
    int postViews
    int strikesNumber
    int starsNumber

    static constraints = {
 
        postViews(min: 0)
        strikesNumber(min: 0, max: 3)
        starsNumber(min: 0, max: 5)

    }

}

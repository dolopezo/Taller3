package forum

class Post {

    String topic
    Date dateCreated
    Date lastUpdate
    boolean itsAllowed

    static constraints = {

        topic(size: 3..50)
        dateCreated(min: new Date())
        lastUpdate(min: new Date())

    }

}
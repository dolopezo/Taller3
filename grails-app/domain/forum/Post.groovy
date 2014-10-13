package forum

class Post {

    String topic
    Date dateCreated
    Date lastUpdate
    boolean itsAllowed

    static constraints = {

        topic(minSize: 3, maxSize: 50)
        dateCreated(min: new Date())
        lastUpdate(min: new Date())

    }

}

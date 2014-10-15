package forum

class File {

    String fileType
    Byte [] content
    double size

    static constraints = {

        //Falta el match con el MIME
        fileType(blank: false)

    }
}
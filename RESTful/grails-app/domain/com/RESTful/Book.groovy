package com.RESTful

class Book {
String tittle
String author
String isbn
Date dateBorrowed
Date dateReturned
String student


String toString(){
"$tittle, $author"
}


    static constraints = {
tittle()
author()
isbn()
dateBorrowed()
dateReturned()
student()

    }
}

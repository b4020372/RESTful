package com.RESTful

class Student {

String name
String email
String studentId
Course course
static hasMany=[books: Book]

String toString(){
"$name, $studentId"
}

    static constraints = {
name()
email()
studentId()
course()
    }
}

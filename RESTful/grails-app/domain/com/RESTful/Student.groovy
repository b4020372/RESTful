package com.RESTful

class Student {

String name
String email
String studentId
String course

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

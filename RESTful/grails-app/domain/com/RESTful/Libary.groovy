package com.RESTful

class Libary {
String location
String openingHours
String book
Student student
String librarian
static hasMany=[students: Student, librarians: Librarian, books: Book]


    static constraints = {
location()
openingHours()
book()
student()
librarian()
    }
}

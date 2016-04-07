package com.RESTful

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Student)
class StudentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void toString() {
       when:"A Student has name and studentId"

def student=new Student(name:'Alan Davis',
studentId:'b4020372')

then:"the to String method merge them."
student.toString()=='Alan Davis, b4020372'
    }
}

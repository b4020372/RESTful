package com.RESTful

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Course)
class CourseSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void toString() {
        when:"A Course has title,code and department"

def course=new Course(title:'Web Systems Design',
code:'WSD101',
department:'Computing')

then:"the to String method merge them."
course.toString()=='Web Systems Design, WSD101, Computing'
    }
}

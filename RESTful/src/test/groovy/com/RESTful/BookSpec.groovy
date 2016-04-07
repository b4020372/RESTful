package com.RESTful

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void toString() {
       when:"A Book has tittle and author"

def book=new Book(tittle:'Harry Potter',
author:'JKRowling')

then:"the to String method merge them."
book.toString()=='Harry Potter, JKRowling'
    }
}

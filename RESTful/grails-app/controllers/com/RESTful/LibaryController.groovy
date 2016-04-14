package com.RESTful

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LibaryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Libary.list(params), model:[libaryCount: Libary.count()]
    }

    def show(Libary libary) {
        respond libary
    }

    def create() {
        respond new Libary(params)
    }

    @Transactional
    def save(Libary libary) {
        if (libary == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (libary.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond libary.errors, view:'create'
            return
        }

        libary.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'libary.label', default: 'Libary'), libary.id])
                redirect libary
            }
            '*' { respond libary, [status: CREATED] }
        }
    }

    def edit(Libary libary) {
        respond libary
    }

    @Transactional
    def update(Libary libary) {
        if (libary == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (libary.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond libary.errors, view:'edit'
            return
        }

        libary.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'libary.label', default: 'Libary'), libary.id])
                redirect libary
            }
            '*'{ respond libary, [status: OK] }
        }
    }

    @Transactional
    def delete(Libary libary) {

        if (libary == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        libary.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'libary.label', default: 'Libary'), libary.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'libary.label', default: 'Libary'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

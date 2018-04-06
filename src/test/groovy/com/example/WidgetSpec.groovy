package com.example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WidgetSpec extends Specification implements DomainUnitTest<Widget> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:
            domain.name = "  "
        
        then:
            !domain.validate()
            domain.errors.allErrors[0].code == 'blank'
        
    }

    void "test something else"() {
        when:
        def widget = new Widget(name: "  ")

        then:
        !widget.validate()
        widget.errors.allErrors[0].code == 'blank'

    }
}

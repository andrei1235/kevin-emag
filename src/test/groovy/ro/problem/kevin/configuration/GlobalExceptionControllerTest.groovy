package ro.problem.kevin.configuration

import org.springframework.http.ResponseEntity
import spock.lang.Specification

class GlobalExceptionControllerTest extends Specification {

    def controller = new GlobalExceptionController()

    def 'handleException'() {
        when:
        def result = controller.handleException(new Exception())

        then:
        0 * _

        and:
        result == ResponseEntity.badRequest().body("The server could not process your request. Please contact your Administrator if the issue persists.");

    }
}

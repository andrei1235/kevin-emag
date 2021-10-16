package ro.problem.kevin.service

import spock.lang.Specification

import static ro.problem.kevin.data.TicketData.aSortedTicketData
import static ro.problem.kevin.data.TicketData.aTicketData

class TicketServiceTest extends Specification {

    def service = new TicketService()

    def "getCompleteItinerary"() {
        when:
        def result = service.getCompleteItinerary(tickets)

        then:
        0 * _

        and:
        result == expectedResult

        where:
        tickets       || expectedResult
        []            || []
        aTicketData() || aSortedTicketData()
    }
}

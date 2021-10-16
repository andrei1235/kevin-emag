package ro.problem.kevin.controller

import org.springframework.http.ResponseEntity
import ro.problem.kevin.service.TicketService
import spock.lang.Specification
import spock.lang.Unroll

import static ro.problem.kevin.data.TicketData.aSortedTicketData
import static ro.problem.kevin.data.TicketData.aTicketData

class TicketControllerTest extends Specification {

    def ticketService = Mock(TicketService)

    def controller = new TicketController(ticketService)

    def 'Required args constructor'() {
        when:
        new TicketController(null)

        then:
        thrown(NullPointerException)
    }

    @Unroll
    'sortTickets'() {
        when:
        def result = controller.sortTickets(tickets)

        then:
        1 * ticketService.getCompleteItinerary(tickets) >> sortedTickets
        0 * _

        and:
        result == ResponseEntity.ok(sortedTickets)

        where:
        tickets       || sortedTickets
        []            || []
        aTicketData() || aSortedTicketData()
    }

}

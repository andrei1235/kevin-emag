package ro.problem.kevin.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.problem.kevin.service.TicketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    @NonNull
    private final TicketService ticketService;

    @PostMapping("/sort_ticket")
    public ResponseEntity<Object> sortTickets(@RequestBody final List<String> tickets) {
        return ResponseEntity.ok(ticketService.getCompleteItinerary(tickets));
    }
}

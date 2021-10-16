package ro.problem.kevin.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class TicketService {

    public List<String> getCompleteItinerary(final List<String> tickets) {
        if (CollectionUtils.isEmpty(tickets)) {
            return Collections.emptyList();
        }
        
        final List<String> sortedTickets = sortTickets(tickets);

        sortedTickets.add(0, "Start");
        sortedTickets.add(sortedTickets.size(), "Last destination reached.");

        return sortedTickets;
    }

    private List<String> sortTickets(final List<String> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            final String destination = getDestination(tickets.get(i));
            for (int j = i + 1; j < tickets.size(); j++) {
                if (tickets.get(j).contains(destination)) {
                    final String temp = tickets.get(i + 1);
                    tickets.set(i + 1, tickets.get(j));
                    tickets.set(j, temp);
                    break;
                }
            }
        }

        return tickets;
    }

    private String getDestination(final String ticketValue) {
        final String[] ticketSplit = ticketValue.split(" to ");
        final String[] words = ticketSplit[ticketSplit.length - 1].split("\\W+");
        return words[0] + " " + words[1];
    }

}

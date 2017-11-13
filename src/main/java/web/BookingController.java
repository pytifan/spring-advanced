package web;

import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.AuditoriumService;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static java.time.ZoneId.*;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.util.stream.Collectors.toList;

/**
 * Created by oleksiiprokopenko on 06/11/2017.
 */

@Controller
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired BookingService bookingService;
    @Autowired UserService userService;
    @Autowired EventService eventService;
    @Autowired AuditoriumService auditoriumService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView bookTicket(@RequestParam(name = "email") String email,
                                   @RequestParam(name = "eventName") String eventName,
                                   @RequestParam(name = "seats") String seats) {
        User userByEmail = userService.getUserByEmail(email);

        List<Event> events = eventService.getByName(eventName);

        Event event = events.stream().filter(evt -> evt.getName().equals(eventName)).findAny().orElse(null);

        String[] strings = seats.split(",");
        List<Integer> seatsList = Arrays.stream(strings).mapToInt(Integer::parseInt).boxed().collect(toList());
        Ticket ticket = new Ticket(event, event.getDateTime(), seatsList, userByEmail, event.getBasePrice());
        Ticket bookedTicket = bookingService.bookTicket(userByEmail, ticket);

        ModelAndView booking = new ModelAndView("bookingPage");
        booking.addObject(bookedTicket);
        return booking;
    }

    private ZonedDateTime getZonedDateTime(String string) {
        return ZonedDateTime.parse(string, ISO_LOCAL_DATE_TIME).withZoneSameLocal(ZoneId.of("ECT"));
    }
//
//    @RequestMapping(value = "/price", method = RequestMethod.GET)
//    public String price() {
//        bookingService.getTicketPrice();
//        return "bookings";
//    }
//
//    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
//    public String ticketsForEvent() {
//        bookingService.getTicketsForEvent();
//        return "bookings";
//    }

}

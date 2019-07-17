package org.wcs.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SimpleHelloServlet", urlPatterns = {"/simple-hello"})
public class SimpleHelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String time = request.getParameter("time");
        String message = "";

        LocalTime localTime = LocalTime.now();
        LocalTime morning = LocalTime.of(6, 00);
        LocalTime afternoon = LocalTime.of(12, 00);
        LocalTime evening = LocalTime.of(18, 00);
        LocalTime night = LocalTime.of(22, 00);


        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH:mm");
        //String nowTime = localTime.format(formattedTime);


        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
    /*
        if (localTime.getHour() > morning.getHour() && localTime.getHour() < afternoon.getHour()) {
            message += "Good Morning !";
        } else if (localTime.getHour() > afternoon.getHour() && localTime.getHour() < evening.getHour()) {
            message += "Good Afternoon !";
        } else if (localTime.getHour() > evening.getHour() && localTime.getHour() < night.getHour()) {
            message += "Good Evening !";
        } else if (localTime.getHour() > night.getHour() && localTime.getHour() < morning.getHour()) {
            message += "Good Night !";
        }
*/
        if (localTime.isAfter(evening)) {
            if (localTime.isBefore(night)) {
                message += "The day is over, good evening honey, let's chill together !";
            }
        } else if (localTime.isAfter(night)) {
            if (localTime.isBefore(morning)) {
                message += "It's time to go to bed, have good night darling.";
            }
        } else if (localTime.isAfter(morning)) {
            if (localTime.isBefore(afternoon)) {
                message += "Did you sleep well ? Good morning little angel.";
            }
        } else if (localTime.isAfter(afternoon)) {
            if (localTime.isBefore(evening)) {
                message += "Good afternoon tiny worker, let's eat and go back to work !";
            }
        }


                /*
        if ((localTime.isAfter(evening)) && (localTime.isBefore(night))) {
            message += "Good Evening !";
        } else if ((localTime.isAfter(night)) && (localTime.isBefore(morning))) {
            message += "Good Night !";
        } else if ((localTime.isAfter(morning)) && (localTime.isBefore(afternoon))) {
            message += "Good Morning !";
        } else if ((localTime.isAfter(afternoon)) && (localTime.isBefore(evening))){
            message += "Good Afternoon !";
        }
                 */

        request.setAttribute("time", message);
        request.getRequestDispatcher("custom-hello.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Prepare messages.
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);

        // Get and validate firstName.
        String firstName = request.getParameter("firstName");
        if (firstName == null || firstName.trim().isEmpty()) {
            messages.put("firstName", "Please enter your first name");
        } else if (!firstName.matches("\\p{Alnum}+")) {
            messages.put("firstName", "Please enter alphanumeric characters only");
        }

        // Get and validate age.
        String lastName = request.getParameter("lastName");
        if (lastName == null || lastName.trim().isEmpty()) {
            messages.put("lastName", "Please enter your last name");
        }

        // No validation errors? Do the business job!
        if (messages.isEmpty()) {
            messages.put("success", String.format("Hello, your first name is %s and your last name is %s!", firstName, lastName));
        }

        request.getRequestDispatcher("hello-form.jsp").forward(request, response);
    }
}

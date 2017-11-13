package web;

import beans.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Created by oleksiiprokopenko on 06/11/2017.
 */

@Controller
public class AuditoriumController {

    @Autowired
    AuditoriumService auditoriumService;

    @RequestMapping(value = "/auditoriums", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("auditoriums", auditoriumService.getAuditoriums());
        return "auditoriums";
    }

}

package es.neesis.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/test")
    public String test(@RequestParam(name="name", required=false, defaultValue="World") String name,
            @RequestParam(name="surname", required=false, defaultValue="Surname") String surname
            , Model model) {
        model.addAttribute("name", name + " " + surname);
        return "test";
    }

    @GetMapping("/testModificado")
    public String testModificado(Model model) {
        model.addAttribute("name", "MiPropioTestModificado");
        return "test";
    }


}

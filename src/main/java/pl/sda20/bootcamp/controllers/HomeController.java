package pl.sda20.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value ="/strona-glowna", method = RequestMethod.GET)
    public String homePage(@RequestParam String firstName,
                           @RequestParam int age, Model model)

    {

        model.addAttribute("firstName", firstName);
        model.addAttribute("age", age);

//(@RequestParam (name = imię) String firstName)
        // w przegladarce jak wpisze : http://localhost:8080/strona-glowna?imie=Ania
        // to wyswietli mi w koncli ; Witaj, Ania
        //mozna rowniez nie dopisywac "(name="imie") tylko wtedy zeby wywolac w przegladarce to musimy
        //wpisac firstName (w tym przypadku)
//do przekierowanie wpisujemy alno redirect albo forward
//        return "forward:forward-page";

        return "home";
    }

//    @RequestMapping(value = "/przekierowanie", method = RequestMethod.GET)
//    public String redirectPage(){
//        return "redirect";
//    }
//
//    @RequestMapping(value = "/forward-page", method = RequestMethod.GET)
//    public String forwardPage(){
//        return "forward";
//    }



    @RequestMapping(value ="/kursy", method = RequestMethod.GET)
    public String listaKursow(){
        return "lista-kursow";
    }






}
//@RequestMapping(value ="/strona-glowna", method = RequestMethod.GET)
// metody GET i POST. POST wykorzystujemy przy logowaniu głownie, GET przy reszcie - powtorzyc


// public String homePage(){  // metoda zwraca nam widok naszego htmla


//redirect przekierowuje i zmienia adres w przegladarce, a forward przekierowuje i nie zmienia tego adres (robi to w tle)
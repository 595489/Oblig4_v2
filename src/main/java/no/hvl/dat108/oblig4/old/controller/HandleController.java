//package no.hvl.dat108.oblig4.old.controller;
//
//import no.hvl.dat108.oblig4.old.model.Handleliste;
//import no.hvl.dat108.oblig4.old.model.Vare;
//import no.hvl.dat108.oblig4.old.utils.LoginUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class HandleController {
//    @Value("${message.requireLogin}") private String REQUIRES_LOGIN_MESSAGE;
//    @Value("${url.loginURL}")   private String LOGIN_URL;
//    @Value("${url.handleURL}") private String HANDLELISTE_URL;
//
//    private Handleliste handleliste = new Handleliste();
//
//    @GetMapping(value = "/${url.handleURL}")
//    public String getHandleliste(Model model, HttpSession session, RedirectAttributes ra){
//        if (!LoginUtil.isUserLoggedIn(session)){
//            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
//            return "redirect:/";
//        }
//        model.addAttribute(handleliste);
//        return HANDLELISTE_URL;
//    }
//
//    @PostMapping(value = "add")
//    public String addVare(Model model, @RequestParam(name = "vare") String vare){
//        if (vare.isEmpty())
//            return "redirect:" + HANDLELISTE_URL;
//
//        handleliste.addVare(new Vare(vare));
//        return "redirect:" + HANDLELISTE_URL;
//    }
//
//    @PostMapping(value = "remove")
//    public String removeVare(Model model, @RequestParam(name = "slettetVare") String vareNavn){
//        handleliste.removeVare(vareNavn);
//        return "redirect:" + HANDLELISTE_URL;
//    }
//}

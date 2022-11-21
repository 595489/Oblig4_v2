//package no.hvl.dat108.oblig4.old.controller;
//
//import no.hvl.dat108.oblig4.old.utils.LoginUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class LogoutController {
//    @Value("${url.logoutURL}") private String LOGOUT_URL;
//    @Value("${url.loginURL}")   private String LOGIN_URL;
//
//    @GetMapping("logout")
//    public String logout(HttpSession session, @RequestParam("hiddenLogout") String hiddenLogout){
//        LoginUtil.logoutUser(session);
//        return LOGOUT_URL;
//    }
//
//    @GetMapping("loginAgain")
//    public String loginAgain(){
//        return "redirect:/";
//    }
//}

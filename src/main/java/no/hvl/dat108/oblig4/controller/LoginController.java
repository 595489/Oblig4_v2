package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.model.DeltagerJSON;
import no.hvl.dat108.oblig4.model.DeltakerDAO;
import no.hvl.dat108.oblig4.utils.LoginUtil;
import no.hvl.dat108.oblig4.utils.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {
    // URL verdier
    @Value("${url.listURL}") private String listeURL;
    @Value("${url.loginURL}") private String loginURL;
    @Value("${url.registerURL}") private String registerURL;
    @Value("${url.logoutURL}") private String logoutURL;
    @Value("${url.confirmURL}") private String confirmURL;

    // Melding verdier
    @Value("${message.noPasswordMatch}") private String noPassMatchMsg;
    @Value("${message.invalidPassword}") private String invalidPasswordMsg;
    @Value("${message.requireLogin}") private String requireLoginMsg;
    @Value("${message.logout}") private String logoutMsg;
    @Value("${message.registeredOk}") private String registrationOkMsg;

    // DAO
    @Autowired
    private DeltakerDAO dao;

    @GetMapping(value = "${url.loginURL}")
    public String login(Model model){
        return loginURL;
    }

    @PostMapping(value = "loggedIn")
    public String tryLogin(Model model, @RequestParam(name = "passord") String password,
                           HttpServletRequest request, RedirectAttributes ra,
                           @RequestParam(name = "mobil") String mobil,
                           @RequestParam(name = "passord") String passord) {
        Deltager d = dao.get(mobil);
        System.out.println(d);
        if (!(PassordUtil.validerMedSalt(passord, d.getPassordSalt(), d.getPassordHash()))){
            ra.addFlashAttribute("invalidPassword", invalidPasswordMsg);
            return "redirect:" + loginURL;
        }

        LoginUtil.loginUser(request, d);
        return "redirect:" + listeURL;
    }
}

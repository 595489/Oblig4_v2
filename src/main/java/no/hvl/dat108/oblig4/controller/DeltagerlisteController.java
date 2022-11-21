package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.model.DeltakerDAO;
import no.hvl.dat108.oblig4.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;

@Controller
public class DeltagerlisteController {
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

    @Autowired
    private DeltakerDAO json;
    private Deltager deltaker;

    @GetMapping(value = "${url.logoutURL}")
    public String loggout(Model model, HttpSession session) {
        LoginUtil.logoutUser(session);
        return loginURL;
    }

    @GetMapping(value = "${url.listURL}")
    public String guests(Model model, HttpSession session) {
        if (!LoginUtil.isUserLoggedIn(session)){
            return "redirect:" + loginURL;
        }

        deltaker = LoginUtil.getLoggedIn();

        List<Deltager> list = json.getAll();

        model.addAttribute("user", deltaker);
        model.addAttribute("list", list);

        return listeURL;
    }
}

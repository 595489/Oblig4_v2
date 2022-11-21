package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.model.DeltakerDAO;
import no.hvl.dat108.oblig4.utils.LoginUtil;
import no.hvl.dat108.oblig4.utils.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import java.util.Objects;

@Controller
public class PaameldingController {
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
    private DeltakerDAO json;

    @GetMapping
    public String standard(Model model){
        return registerURL;
    }

    @GetMapping(value = "${url.registerURL}")
    public String paamelding(Model model, HttpSession session) {
        if (LoginUtil.isUserLoggedIn(session)){
            return "redirect:" + listeURL;
        }
        return registerURL;
    }

    @PostMapping("registerUser")
    public String registerUser(Model model,
                               RedirectAttributes ra, HttpServletRequest request,
                               @RequestParam(name = "fornavn") String fornavn,
                               @RequestParam(name = "etternavn") String etternavn,
                               @RequestParam(name = "mobil") String mobil,
                               @RequestParam(name = "passord") String passord,
                               @RequestParam(name = "passordRep") String passordRep,
                               @RequestParam(name = "gender") String kjonn) {
//        if(bindingResult.hasErrors()) {
//            return registerURL;
//        }
        if (!(passord.equals(passordRep))){
            ra.addFlashAttribute("noPassMatch", noPassMatchMsg);
            return "redirect:" + registerURL;
        }
        if (json.get(mobil) != null){
            ra.addFlashAttribute("error", "Bruker allerede registrert med dette mobil nummeret");
            return "redirect:" + registerURL;
        }

        String salt = PassordUtil.genererTilfeldigSalt();
        String hash = PassordUtil.hashMedSalt(passord, salt);

        Deltager d = new Deltager(fornavn, etternavn, kjonn, mobil, hash, salt);
        json.save(d);

        LoginUtil.loginUser(request, d);

//        System.out.println(d + " Er logget inn?");
//        System.out.println(d.getFornavn() + " " + d.getEtternavn() + " " + d.getMobil() + " " + d.getKjonn());
//        System.out.println("Salt: " + d.getPassordSalt() + " Hash: " + d.getPassordHash());
//        System.out.println(LoginUtil.getLoggedIn());
        return "redirect:" + confirmURL;
    }
}


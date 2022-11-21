package no.hvl.dat108.oblig4.utils;

import no.hvl.dat108.oblig4.model.Deltager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {
    private final static int MAX_INTERACTIVE_INTERVAL = 100;
    private static boolean isLoggedIn = false;
    private static Deltager deltager = null;

    public static void logoutUser(HttpSession session){
        session.invalidate();
        deltager = null;
        isLoggedIn = false;
    }

    public static void loginUser(HttpServletRequest request){
        logoutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
//        session.setAttribute("handleliste", new Handleliste());

        isLoggedIn = true;
    }

    public static void loginUser(HttpServletRequest request, Deltager d){
        logoutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
//        session.setAttribute("handleliste", new Handleliste());

        isLoggedIn = true;
        deltager = d;
    }

    public static Deltager getLoggedIn(){
        return deltager;
    }

    public static boolean isUserLoggedIn(HttpSession session){
        if (session != null)
            return isLoggedIn;
        else return false;
    }
}

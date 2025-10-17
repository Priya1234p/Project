package in.ashokit.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // Show Login Page
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    // Handle Login
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        String validUser = "admin";
        String validPass = "123";

        if (username.equals(validUser) && password.equals(validPass)) {
            session.setAttribute("loggedUser", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        String user = (String) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("total", 256);
        model.addAttribute("enrolled", 84);
        model.addAttribute("lost", 172);

        return "dashboard";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    
}

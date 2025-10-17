package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    // ✅ Login Page
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    // ✅ Signup Page
    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }

    // ✅ Handle Signup (Simulated)
    @PostMapping("/signup")
    public String handleSignup(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phno,
            @RequestParam String password,
            Model model) {

        System.out.println("User Registered: " + email);
        // Simulate locked account (in real app, store temp password & status=LOCKED)
        // Send unlock link like: http://localhost:8080/unlock?email=user@gmail.com

        model.addAttribute("msg",
                "Signup successful! Please check your email to unlock your account.");
        return "login";
    }

    // ✅ Show Unlock Page (GET)
    @GetMapping("/unlock")
    public String unlockPage(@RequestParam(required = false) String email, Model model) {
        if (email != null) {
            model.addAttribute("email", email);
        }
        return "unlock"; // unlock.html
    }

    // ✅ Handle Unlock Form Submission (POST)
    @PostMapping("/unlock")
    public String unlockAccount(
            @RequestParam String tempPwd,
            @RequestParam String newPwd,
            @RequestParam String confirmPwd,
            @RequestParam(required = false) String email,
            Model model) {

        // ✅ Simulated verification logic
        String expectedTempPwd = "temp123"; // In real app, fetch from DB
        if (!tempPwd.equals(expectedTempPwd)) {
            model.addAttribute("email", email);
            model.addAttribute("error", "Invalid temporary password!");
            return "unlock";
        }

        if (!newPwd.equals(confirmPwd)) {
            model.addAttribute("email", email);
            model.addAttribute("error", "Passwords do not match!");
            return "unlock";
        }

        // ✅ Simulate password update & status change
        System.out.println("Account unlocked for: " + email);
        model.addAttribute("msg", "Account unlocked successfully! Please login now.");
        return "login";
    }

    // ✅ Forget Password
    @GetMapping("/forgetpwd")
    public String forgetPasswordPage() {
        return "forgetpwd";
    }
}

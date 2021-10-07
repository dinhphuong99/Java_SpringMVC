package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String convert(@RequestParam int usd, Model model) {
        int vnd = usd * 22800;
        model.addAttribute("vnd", vnd);
        return "convert";
    }
}
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator (@RequestParam int number, String mess, int number1, Model model) {
        int result = 0;
        if ("Addition".equals(mess)) {
            result = number + number1;
            model.addAttribute("mess", "addition");
            model.addAttribute("result", result);
            model.addAttribute("error","");
        } else if ("Subtraction".equals(mess)) {
            result = number - number1;
            model.addAttribute("mess", "subtraction");
            model.addAttribute("result", result);
            model.addAttribute("error","");
        } else if ("Multiplication".equals(mess)) {
            result = number * number1;
            model.addAttribute("mess", "multiplication");
            model.addAttribute("result", result);
            model.addAttribute("error","");
        } else if ("Division".equals(mess)) {
            model.addAttribute("mess", "division");
            if (number1 != 0){
                result = number / number1;
                model.addAttribute("result", result);
                model.addAttribute("error","");
            }else {
                model.addAttribute("error","Không thể chia cho 0");
            }
        }
        return "index";
    }
}

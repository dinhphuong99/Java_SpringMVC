package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    String[] vietnam = {"chữ", "vị trí"};
    String[] eng = {"word","location"};

    public String translate(String word){
        String result = "Không tìm thấy";
        int index;
        for ( index = 0; index < vietnam.length; index++) {
            if (eng[index].equals(word)){
                result = vietnam[index];
                break;
            }
        }
        return result;
    }

    @GetMapping("/translate")
    public String convert(@RequestParam String english, Model model) {
        String vietnamese = translate(english);
        model.addAttribute("vietnamese", vietnamese);
        return "translate";
    }
}
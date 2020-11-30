package com.codeup.blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RollDiceController {
    int sides = 6;
    @GetMapping("/roll-dice")
    public String rollDice(Model model){
        List<Integer> possibleResults = new ArrayList<>();
        for(int i = 1; i <= sides; i++){
            possibleResults.add(i);
        }
        model.addAttribute("possibleResults", possibleResults);
        return "roll-dice";
    }
    @PostMapping("roll-dice/{n}")
    public String guess(@PathVariable int n, Model model){
        model.addAttribute("guess",n);
        int roll = new Random().ints(1, sides + 1)
                .findFirst()
                .getAsInt();
        model.addAttribute("roll",roll);

        return "roll-dice";
    }
}

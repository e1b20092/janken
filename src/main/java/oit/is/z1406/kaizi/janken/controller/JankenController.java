package oit.is.z1406.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/Janken")
  public String Janken() {
    return "janken";
  }

  @PostMapping("/Janken")
  public String sample(@RequestParam String userName,ModelMap model) {
    model.addAttribute("userName", userName);
    return "janken.html";
  }
}

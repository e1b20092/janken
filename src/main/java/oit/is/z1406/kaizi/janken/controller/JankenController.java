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
  public String sample(@RequestParam String userName, ModelMap model) {
    model.addAttribute("userName", userName);
    return "janken.html";
  }

  @GetMapping("/gu")
  public String sample2(ModelMap model) {
    String gu = "Gu";
    String draw = "You Draw";
    model.addAttribute("te", gu);
    model.addAttribute("result", draw);
    return "janken.html";
  }

  @GetMapping("/cho")
  public String sample3(ModelMap model) {
    String cho = "Choki";
    String lose = "You Lose";
    model.addAttribute("te", cho);
    model.addAttribute("result", lose);
    return "janken.html";
  }

  @GetMapping("/pa")
  public String sample4(ModelMap model) {
    String pa = "Pa";
    String win = "You Win";
    model.addAttribute("te", pa);
    model.addAttribute("result", win);
    return "janken.html";
  }
}

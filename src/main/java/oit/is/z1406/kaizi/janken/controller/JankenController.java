package oit.is.z1406.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1406.kaizi.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry room;

  @GetMapping("/janken")
  public String sample1(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String sample2(@RequestParam String hand, @RequestParam String re, Principal prin, ModelMap model) {
    String res = "You " + re;
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    model.addAttribute("te", hand);
    model.addAttribute("result", res);
    return "janken.html";
  }
}

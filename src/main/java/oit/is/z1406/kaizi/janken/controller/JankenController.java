package oit.is.z1406.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1406.kaizi.janken.model.Entry;
import oit.is.z1406.kaizi.janken.model.User;
import oit.is.z1406.kaizi.janken.model.UserMapper;
import oit.is.z1406.kaizi.janken.model.Match;
import oit.is.z1406.kaizi.janken.model.MatchMapper;
import oit.is.z1406.kaizi.janken.model.MatchInfo;
import oit.is.z1406.kaizi.janken.model.MatchInfoMapper;

@Controller
public class JankenController {

  @Autowired
  private Entry room;
  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  MatchInfoMapper matchinfoMapper;

  @GetMapping("/janken")
  public String sample1(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    ArrayList<User> user = userMapper.selectAllUserName();
    model.addAttribute("users", user);

    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("Match", matches);

    ArrayList<MatchInfo> matchinfo = matchinfoMapper.selectActiveMatchInfo();
    model.addAttribute("MatchInfo", matchinfo);

    return "janken.html";
  }

  @GetMapping("/wait")
  public String sample2(@RequestParam Integer id, @RequestParam String hand, Principal prin, ModelMap model) {
    model.addAttribute("te", hand);

    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    User users = userMapper.selectById(id);
    model.addAttribute("users", users);

    MatchInfo matchinfo = new MatchInfo();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    matchinfo.setUser1(user1.getId());
    matchinfo.setUser2(user2.getId());
    matchinfo.setUser1Hand(hand);
    matchinfo.setIsActive(true);
    matchinfoMapper.insertMatchInfo(matchinfo);
    model.addAttribute("MatchInfo", matchinfo);

    return "wait.html";
  }

  @GetMapping("/match")
  public String sample3(@RequestParam Integer id, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    User users = userMapper.selectById(id);
    model.addAttribute("users", users);

    return "match.html";
  }
}

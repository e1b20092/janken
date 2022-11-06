package oit.is.z1406.kaizi.janken.model;

public class MatchInfo {
  int id;
  int user1;
  int user2;
  String user1hand;
  boolean isActive;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setUser1(int user1) {
    this.user1 = user1;
  }

  public int getUser1() {
    return user1;
  }

  public void setUser2(int user2) {
    this.user2 = user2;
  }

  public int getUser2() {
    return user2;
  }

  public void setUser1Hand(String user1Hand) {
    this.user1hand = user1Hand;
  }

  public String getUser1Hand() {
    return user1hand;
  }

  public void setisActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public boolean getisActive() {
    return isActive;
  }
}

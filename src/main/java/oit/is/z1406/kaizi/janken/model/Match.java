package oit.is.z1406.kaizi.janken.model;

public class Match {
  int id;
  int user1;
  int user2;
  String user1hand;
  String user2hand;
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

  public void setUser2Hand(String user2Hand) {
    this.user2hand = user2Hand;
  }

  public String getUser2Hand() {
    return user2hand;
  }

  public void setisActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public boolean getisActive() {
    return isActive;
  }
}

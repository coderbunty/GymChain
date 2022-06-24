package com.meesho.gym.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gym {

  private String name;
  private String id;
  private String location;
  private Integer maxAccommodation;
  private List<GymClass> classes;

  public Gym(String name, String location, Integer maxAccommodation) {
    this.name = name;
    this.location = location;
    this.maxAccommodation = maxAccommodation;
    this.id = String.valueOf(new Random().nextInt(10000));
    this.classes = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getMaxAccommodation() {
    return maxAccommodation;
  }

  public void setMaxAccommodation(Integer maxAccommodation) {
    this.maxAccommodation = maxAccommodation;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<GymClass> getClasses() {
    return classes;
  }

  public void setClasses(List<GymClass> classes) {
    this.classes = classes;
  }
}

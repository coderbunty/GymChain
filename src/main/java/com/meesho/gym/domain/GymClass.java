package com.meesho.gym.domain;

import java.util.Random;

public class GymClass {

  private String classId;
  private String classType;
  private String startTime;
  private String endTime;

  public GymClass(String classType, Integer maxLimit, String startTime, String endTime) {
    this.classType = classType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.classId = String.valueOf(new Random().nextInt(10000));
  }

  public String getClassType() {
    return classType;
  }

  public void setClassType(String classType) {
    this.classType = classType;
  }

  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
}

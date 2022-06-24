package com.meesho.gym.handler;

import com.meesho.gym.domain.Gym;
import com.meesho.gym.domain.GymClass;
import com.meesho.gym.exceptions.GymClassSizeLimitExceededException;
import java.util.HashMap;
import java.util.Map;

public class AdminCommandHandler {

  private Map<String, Gym> gyms = new HashMap<>();

  public String addGym(String name, String location, Integer maxAccommodation) {
    Gym newGym = new Gym(name, location, maxAccommodation);
    gyms.put(newGym.getId(), newGym);
    return newGym.getId();
  }

  public boolean removeGym(String gymId) {
    if (gymExists(gymId)) {
      gyms.remove(gymId);
      return true;
    }
    return false;
  }

  private boolean gymExists(String gymId) {
    if (gyms.containsKey(gymId)) {
      return true;
    }
    return false;
  }

  public String addClass(String gymId, String classType, Integer maxLimit, String startTime,
      String endTime) {
    if (gymExists(gymId)) {
      Gym gym = gyms.get(gymId);
      if (gym.getMaxAccommodation() < maxLimit) {
        throw new GymClassSizeLimitExceededException(
            "Class limit is more than the total Gym size.");
      }
      GymClass newClass = new GymClass(classType, maxLimit, startTime, endTime);
      gym.getClasses().add(newClass);
      return newClass.getClassId();
    }
    return null;
  }

  public void removeClass(String classId) {
    // TODO
  }

}

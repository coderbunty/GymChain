package com.meesho.gym.interaction.commands;

import com.meesho.gym.exceptions.GymClassSizeLimitExceededException;
import com.meesho.gym.exceptions.InvalidParameterException;
import com.meesho.gym.handler.AdminCommandHandler;
import com.meesho.gym.utils.StringUtils;

public class AddClassCommand implements Command {

  private AdminCommandHandler adminCommandHandler;

  public AddClassCommand(AdminCommandHandler adminCommandHandler) {
    this.adminCommandHandler = adminCommandHandler;
  }

  @Override
  public void execute(String[] params) throws InvalidParameterException {
    if (params.length != 5) {
      throw new InvalidParameterException("Expected five parameters.");
    }

    if (!StringUtils.isInteger(params[2])) {
      throw new InvalidParameterException("max limit must be an integer");
    }

    Integer maxLimit = Integer.parseInt(params[2]);
    try {
      String classId = this.adminCommandHandler.addClass(params[0], params[1], maxLimit, params[3],
          params[4]);
      if (classId == null) {
        System.out.println("Couldn't add class as gym with " + params[0] + " doesn't exist.");
        return;
      }
      System.out.println(
          "New class with id " + classId + " created successfully for gym " + params[0]);
    } catch (GymClassSizeLimitExceededException e) {
      System.out.println(e.getMessage());
    }
  }
}

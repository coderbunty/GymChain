package com.meesho.gym.interaction.commands;

import com.meesho.gym.exceptions.InvalidParameterException;
import com.meesho.gym.handler.AdminCommandHandler;
import com.meesho.gym.utils.MessageConstants;

public class RemoveGymCommand implements Command {

  private AdminCommandHandler adminCommandHandler;

  public RemoveGymCommand(AdminCommandHandler adminCommandHandler) {
    this.adminCommandHandler = adminCommandHandler;
  }

  @Override
  public void execute(String[] params) throws InvalidParameterException {
    if (params.length != 1) {
      throw new InvalidParameterException("Expected one parameter.");
    }

    boolean success = this.adminCommandHandler.removeGym(params[0]);
    if (success) {
      System.out.println("Gym with id " + params[0] + " removed successfully.");
    } else {
      System.out.println(MessageConstants.GYM_NAME_DOES_NOT_EXIST);
    }
  }
}

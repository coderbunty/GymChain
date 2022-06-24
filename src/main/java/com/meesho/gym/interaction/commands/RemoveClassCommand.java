package com.meesho.gym.interaction.commands;

import com.meesho.gym.exceptions.InvalidParameterException;
import com.meesho.gym.handler.AdminCommandHandler;

public class RemoveClassCommand implements Command {

  private AdminCommandHandler adminCommandHandler;

  public RemoveClassCommand(AdminCommandHandler adminCommandHandler) {
    this.adminCommandHandler = adminCommandHandler;
  }

  @Override
  public void execute(String[] params) throws InvalidParameterException {
    if (params.length != 1) {
      throw new InvalidParameterException("Expected one parameter.");
    }

    this.adminCommandHandler.removeClass(params[0]);
    System.out.println(
        "Class with id " + params[0] + " removed successfully.");
  }

}

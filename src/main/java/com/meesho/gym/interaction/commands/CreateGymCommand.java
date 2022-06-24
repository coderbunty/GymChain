package com.meesho.gym.interaction.commands;


import com.meesho.gym.exceptions.InvalidParameterException;
import com.meesho.gym.handler.AdminCommandHandler;
import com.meesho.gym.utils.StringUtils;

public class CreateGymCommand implements Command {

  private AdminCommandHandler adminCommandHandler;

  public CreateGymCommand(AdminCommandHandler adminCommandHandler) {
    this.adminCommandHandler = adminCommandHandler;
  }

  @Override
  public void execute(String[] params) throws InvalidParameterException {
    if (params.length != 3) {
      throw new InvalidParameterException("Expected three parameters.");
    }

    if (!StringUtils.isInteger(params[2])) {
      throw new InvalidParameterException("max accommodations must be an integer");
    }

    Integer maxAccommodations = Integer.parseInt(params[2]);
    String gymId = this.adminCommandHandler.addGym(params[0], params[1], maxAccommodations);
    System.out.println("New gym with id " + gymId + " created successfully.");
  }
}

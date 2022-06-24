package com.meesho.gym.interaction;

import com.meesho.gym.exceptions.CommandNotFoundException;
import com.meesho.gym.exceptions.InvalidParameterException;
import com.meesho.gym.handler.AdminCommandHandler;
import com.meesho.gym.handler.MemberCommandHandler;
import com.meesho.gym.interaction.commands.AddClassCommand;
import com.meesho.gym.interaction.commands.Command;
import com.meesho.gym.interaction.commands.CreateGymCommand;
import com.meesho.gym.interaction.commands.RemoveGymCommand;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

  private Map<String, Command> commands;

  private CommandFactory() {
    commands = new HashMap<>();
  }

  public void addCommand(String name, Command command) {
    commands.put(name, command);
  }

  public void executeCommand(String name, String[] params)
      throws CommandNotFoundException, InvalidParameterException {
    if (commands.containsKey(name)) {
      commands.get(name).execute(params);
    } else {
      throw new CommandNotFoundException(name);
    }
  }

  public Map<String, Command> getCommands() {
    return commands;
  }

  public static CommandFactory init(AdminCommandHandler adminCommandHandler,
      MemberCommandHandler memberCommandHandler) {
    final CommandFactory cf = new CommandFactory();

    cf.addCommand("addGym", new CreateGymCommand(adminCommandHandler));
    cf.addCommand("removeGym", new RemoveGymCommand(adminCommandHandler));
    cf.addCommand("addClass", new AddClassCommand(adminCommandHandler));
    return cf;
  }
}

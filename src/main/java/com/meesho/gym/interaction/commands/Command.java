package com.meesho.gym.interaction.commands;

import com.meesho.gym.exceptions.InvalidParameterException;

public interface Command {

  void execute(String[] params) throws InvalidParameterException;
}

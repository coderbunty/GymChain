package com.meesho.gym.application;

import com.meesho.gym.client.CLIClient;
import com.meesho.gym.handler.AdminCommandHandler;
import com.meesho.gym.handler.MemberCommandHandler;
import com.meesho.gym.interaction.CommandFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GymApplication {

  public static void main(String[] args) {
    AdminCommandHandler adminCommandHandler = new AdminCommandHandler();
    MemberCommandHandler memberCommandHandler = new MemberCommandHandler();
    CommandFactory commandFactory = CommandFactory.init(adminCommandHandler, memberCommandHandler);
    try {
      CLIClient client = new CLIClient(new BufferedReader(new InputStreamReader(System.in)),
          commandFactory);
      client.handleInput();
    } catch (IOException ex) {
      System.out.println("Something went wrong. Please try again!");
    }
  }

}

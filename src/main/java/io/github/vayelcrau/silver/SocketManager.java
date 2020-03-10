package io.github.vayelcrau.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SocketManager implements Runnable {
  private final Socket socket;

  public static SocketManager fromSocket(Socket socket) {
    return new SocketManager(socket);
  }

  private SocketManager(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try (socket) {
      Manipulator.GET.date(socket);

      Manipulator.INFO.printInfo(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

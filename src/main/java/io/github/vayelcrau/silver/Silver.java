package io.github.vayelcrau.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A simple web server that can serve HTML files that contain Javascript and other forms of non-code executing code.
 * Added complexity would be to try and implement streaming video, create a server-side language, or serve up other stream types.
 */

public class Silver {
  private static final int port = 8080;

  public static void main(String... args) throws IOException {
    final ServerSocket server = new ServerSocket(port);
    System.out.println("Listening for connection on port " + port + "...");

    while(true) {
      Socket socket = server.accept();
      new Thread(SocketManager.fromSocket(socket)).start();
    }
  }
}

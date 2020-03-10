package io.github.vayelcrau.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Manipulator {
  private Manipulator() {

  }

  public static final class INFO {
    public static void printInfo(Socket socket) throws IOException {
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );

      String line;

      do {
        line = reader.readLine();
        System.out.println(line);
      } while (!line.isEmpty());
    }
  }

  public static final class GET {
    public static void date(Socket socket) throws IOException {
      Date date = new Date();
      String response = "HTTP/1.1 200 OK\r\n\r\n" + date;

      socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
    }
  }
}

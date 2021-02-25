package com.ametekohy.app.services;

import org.fusesource.jansi.Ansi;

import java.io.*;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsolePrinterService {

    private static final String HTTP_LOGO = "http.txt";
    private static final Ansi.Color PRIMARY_COLOR = Ansi.Color.BLUE;
    private static final Ansi.Color SECONDARY_COLOR = Ansi.Color.MAGENTA;
    private static final String COLORED_VERT_BAR = ansi().fg(PRIMARY_COLOR).a("|").reset().toString();

    public void printLogo() {

        var file = new File(getClass().getClassLoader().getResource(HTTP_LOGO).getFile());

        InputStreamReader reader = null;

        try (var stream = new FileInputStream(file)) {
            reader = new InputStreamReader(stream, "UTF-8");
            var fin = new BufferedReader(reader);
            String s = null;

            while (true) {
                if (!((s = fin.readLine()) != null)) break;
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSelectionScreen() {
        printHorizontalLine();
        printOutputLine("Welcome to the HTTP-Client");
        printHorizontalLine();
        printOutputLine("Please select which request to send: ");
        printOutputLine("");
        printOutputLine("* Press 1 for a synchronous GET to https://github.com");
        printOutputLine("* Press 2 for a synchronous GET to the Readme.md of this exercise on GitHub");
        printOutputLine("* Press 3 for a asynchronous GET to https://jsonplaceholder.typicode.com/todos");
        printOutputLine("* Press 4 for a asynchronous GET to https://jsonplaceholder.typicode.com/todos with a callback v1");
        printOutputLine("* Press 5 for a asynchronous GET to https://jsonplaceholder.typicode.com/todos with a callback v2");
        printOutputLine("* Press 6 for creating a new Todo item at https://jsonplaceholder.typicode.com/todos");

        printOutputLine("* Press q to exit");
        printInputLine();
    }

    public void printResponse(String response) {
        printHorizontalLine();
        printOutputLine("Received response: ");
        System.out.println(COLORED_VERT_BAR.concat(response.replace("\n", "\n".concat(COLORED_VERT_BAR))));
    }

    private void printHorizontalLine() {
        System.out.println(ansi().fg(PRIMARY_COLOR).a("------------------------------------------------").reset());
    }

    public void printInputLine() {
        System.out.print(ansi().fg(PRIMARY_COLOR).a("| ").fg(SECONDARY_COLOR).a("> "));
    }

    public void printOutputLine(String text) {
        System.out.println(ansi().fg(PRIMARY_COLOR).a("| ").reset().a(text));
    }
}

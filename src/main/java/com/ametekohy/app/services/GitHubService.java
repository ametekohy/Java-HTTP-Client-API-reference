package com.ametekohy.app.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {
    private HttpClient httpClient;

    public GitHubService() {
        httpClient = HttpClient.newHttpClient();
    }

    public String getIndexHtml() {
        var request = HttpRequest.newBuilder().uri(URI.create("https://github.com")).build();

        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        return response.body();
    }

    public String getReadme() {
        var request = HttpRequest.newBuilder().uri(URI.create("https://raw.githubusercontent.com/ametekohy/HTTP-ClientAPI/master/README.md")).build();

        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

        return response.body();
    }
}

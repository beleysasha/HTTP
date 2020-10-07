package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.SECONDS;

public class App {
    private final static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=";
    public final static String secondPart="&date=20200302&";
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scr = new Scanner(System.in);
        String partOfURI = scr.nextLine();
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().header("accept134","application/json").uri(URI.create(url+partOfURI+secondPart)).
                GET().build();
        var response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }












    //    HttpClient client = HttpClient.newBuilder().build();
//
//    HttpRequest request = HttpRequest.newBuilder().
//            header("Accept", "Application/json").
//            GET().
//            uri(URI.create(url)).
//            timeout(Duration.of(10, SECONDS)).
//            build();
//    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
}

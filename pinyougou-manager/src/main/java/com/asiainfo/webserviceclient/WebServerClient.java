package com.asiainfo.webserviceclient;

public class WebServerClient {



    public static void main(String[] args) {
        WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
        WeatherInterfaceImpl weatherInterfaceImplPort = weatherInterfaceImplService.getWeatherInterfaceImplPort();
        String abc = weatherInterfaceImplPort.queryWeather("abc");
        System.out.println(abc);
    }
}

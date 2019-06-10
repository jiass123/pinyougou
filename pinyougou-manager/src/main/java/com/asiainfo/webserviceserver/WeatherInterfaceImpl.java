
package com.asiainfo.webserviceserver;

import javax.jws.WebService;


@WebService
public class WeatherInterfaceImpl implements WeatherInterface {


    @Override
    public String queryWeather(String name) {
        System.out.println(name);
        return "晴天";
    }
}

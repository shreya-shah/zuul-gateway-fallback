package com.prac.weatherservice.weather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class WeatherController {
   
    @GetMapping("/{city}")
    public String getWeatherForCity(@PathVariable("city") String city, HttpServletRequest request) throws IOException, ParseException {

//        Iterator itr = request.getHeaderNames().asIterator();
//
//        while (itr.hasNext()) {
//            log.info("HEADER RECEIVED IS -> " + itr.next());
//        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");

        Date date = df.parse(df.format(new Date()));

        log.info("Fetching Authorization Header: " +request.getHeader("Authorization"));
        return String.format("Weather in %s is cool at %s", city, new Date().getTime());
    }
}
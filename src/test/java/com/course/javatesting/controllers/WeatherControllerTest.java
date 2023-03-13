package com.course.javatesting.controllers;

import com.course.javatesting.models.Weather;
import com.course.javatesting.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // indicamos que va a utilizar mockito
public class WeatherControllerTest {

    @InjectMocks //mockeamos el objeto controller (dentro tiene objetos mockiados)
    private WeatherController controller;

    @Mock // simula que esta para ver como funciona
    private WeatherService service;

    @Test
    public void getWeather() {
        // creamos objeto que le pasaremos a la prueba
        Weather weatherMock = new Weather();
        weatherMock.setMaxTemp(10);
        weatherMock.setMinTemp(7);
        weatherMock.setStatus("Cloudy");

        //cuando service.getWeather sea llamado, devolverá un Objeto Weather
        when(service.getWeather()).thenReturn(weatherMock);
        Weather result1 = controller.getWeather(); // llamado al controlador 1
        Weather result2 = controller.getWeather(); // llamado al controlador 2

        // verificar que el servicio llamo por lo menos 2 vez al controlador
        verify(service, times(2)).getWeather();
    }
}

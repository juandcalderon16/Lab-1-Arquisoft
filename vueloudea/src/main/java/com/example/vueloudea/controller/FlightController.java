package com.example.vueloudea.controller;


import com.example.vueloudea.model.Flight;
import com.example.vueloudea.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate,
                                      @RequestParam(value= "origin", required = false) String origin,
                                      @RequestParam(value= "destination", required = false) String destination,
                                      @RequestParam(value= "maxPrice", required = false) Double maxPrice,
                                      @RequestParam(value= "maxPasajeros", required = false) Double maxPasajeros,
                                      @RequestParam(value= "clase", required = false) String clase,
                                      @RequestParam(value= "equipaje", required = false) Boolean equipaje){
        // Busca los vuelos dentro del rango de fechas, con origen, destino, precio máximo, clase y número máximo de pasajeros
        List<Flight> vuelos = flightService.findFlights(
                LocalDate.parse(startDate),
                LocalDate.parse(endDate),
                origin,
                destination,
                maxPrice,
                clase,
                maxPasajeros,
                equipaje
        );
        System.out.println("Equipaje: " + equipaje);  // Verifica el valor de equipaje
        System.out.println("Received startDate: " + startDate);
        System.out.println("Received endDate: " + endDate);


// Recorre todos los vuelos y ajusta el precio si la clase es "First Class"
        for (Flight vuelo : vuelos) {
            // Verifica si el vuelo es de clase "First Class"
            if ("Ejecutiva".equalsIgnoreCase(vuelo.getClase())) {
                System.out.println("Received endDate: " + clase);
                // Calcula el precio con base en la clase "First Class"
                vuelo.setPrice(flightService.calcularPrecio(vuelo.getPrice(), vuelo.getClase()));
            }
        }

// Puedes ahora trabajar con la lista de vuelos modificada

        return flightService.findFlights(LocalDate.parse(startDate), LocalDate.parse(endDate)
                , origin, destination, maxPrice, clase, maxPasajeros, equipaje);
    }
}
package com.example.vueloudea.service;

import com.example.vueloudea.model.Flight;
import com.example.vueloudea.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public double calcularPrecio(double precio, String clase){
        if(clase.equals("Ejecutiva")){
            precio = precio + 50;
        }
        return precio;
    }

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String clase, Double maxPasajeros, Boolean equipaje) {
        // Generar una clave de combinación de parámetros para usar en el switch
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (clase != null ? "1" : "0") +
                (maxPasajeros != null ? "1" : "0") +
                (equipaje != null ? "1" : "0");

        switch (key) {
            case "111000": // origin, destination, maxPrice no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, maxPrice);

            case "110000": // origin, destination no son nulos, maxPrice es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                        startDate, endDate, origin, destination);

            case "101000": // origin y maxPrice no son nulos, destination es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, maxPrice);

            case "011000": // destination y maxPrice no son nulos, origin es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, destination, maxPrice);

            case "100000": // solo origin no es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(startDate, endDate, origin);

            case "010000":// solo destination no es nulo
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate, destination);

            case "001000": // solo maxPrice no es nulo
                return flightRepository.findByDateBetweenAndPriceLessThanEqual(startDate, endDate, maxPrice);

            case "000100":
                return flightRepository.findByDateBetweenAndClaseContainingIgnoreCase(startDate, endDate, clase);

            case "000010":
                return flightRepository.findByDateBetweenAndPasajerosLessThanEqual(startDate, endDate, maxPasajeros);

            case "100100":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndClaseContainingIgnoreCase(startDate, endDate, origin, clase);

            case "100010":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPasajerosLessThanEqual(startDate, endDate, origin, maxPasajeros);

            case "010100":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase(startDate, endDate, destination, clase);

            case "010010":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual(startDate, endDate, destination, maxPasajeros);

            case "001100":
                return flightRepository.findByDateBetweenAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(startDate, endDate, maxPrice, clase);

            case "001010":
                return flightRepository.findByDateBetweenAndPriceIsLessThanEqualAndPasajerosLessThanEqual(startDate, endDate, maxPrice, maxPasajeros);

            case "000110":
                return flightRepository.findByDateBetweenAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(startDate, endDate, clase, maxPasajeros);

            case "111111": // origin, destination, maxPrice, clase, maxPasajeros, equipaje no son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, origin, destination, maxPrice, clase, maxPasajeros);

            case "111110": // origin, destination, maxPrice, clase, maxPasajeros no son nulos, equipaje es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                        startDate, endDate, origin, destination, maxPrice, clase, maxPasajeros);

            case "111101": // origin, destination, maxPrice, clase, equipaje no son nulos, maxPasajeros es nulo
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, equipaje, origin, destination, maxPrice, clase);

            case "111011": // origin, destination, maxPrice, maxPasajeros, equipaje no son nulos, clase es nulo
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, origin, destination, maxPrice, maxPasajeros);

            case "111001": // origin, destination, maxPrice, equipaje no son nulos, clase y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, equipaje, origin, destination, maxPrice);

            case "110111": // origin, destination, clase, maxPasajeros, equipaje no son nulos, maxPrice es nulo
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, origin, destination, clase, maxPasajeros);

            case "110110": // origin, destination, clase, maxPasajeros no son nulos, maxPrice y equipaje son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                        startDate, endDate, origin, destination, clase, maxPasajeros);

            case "110101": // origin, destination, clase, equipaje no son nulos, maxPrice y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase(
                        startDate, endDate, equipaje, origin, destination, clase);

            case "110011": // origin, destination, maxPasajeros, equipaje no son nulos, maxPrice y clase son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, origin, destination, maxPasajeros);


            case "101101": // origin, maxPrice, clase, equipaje no son nulos, destination y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, equipaje, origin, maxPrice, clase);

            case "101011": // origin, maxPrice, maxPasajeros, equipaje no son nulos, destination y clase son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, origin, maxPrice, maxPasajeros);

            case "011101": // destination, maxPrice, clase, equipaje no son nulos, origin y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                        startDate, endDate, equipaje, destination, maxPrice, clase);

            case "011011": // destination, maxPrice, maxPasajeros, equipaje no son nulos, origin y clase son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, destination, maxPrice, maxPasajeros);

            case "001001": // maxPrice, equipaje no son nulos, origin, destination, clase y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndPriceLessThanEqual(
                        startDate, endDate, equipaje, maxPrice);

            case "000101": // clase, equipaje no son nulos, origin, destination, maxPrice y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndClaseContainingIgnoreCase(
                        startDate, endDate, equipaje, clase);

            case "000011": // maxPasajeros, equipaje no son nulos, origin, destination, maxPrice y clase son nulos
                return flightRepository.findByDateBetweenAndEquipajeAndPasajerosLessThanEqual(
                        startDate, endDate, equipaje, maxPasajeros);

            case "000001": // equipaje no es nulo, origin, destination, maxPrice, clase y maxPasajeros son nulos
                return flightRepository.findByDateBetweenAndEquipaje(
                        startDate, endDate, equipaje);

            case "000000": // todos los parámetros son nulos
                return flightRepository.findByDateBetween(startDate, endDate);

            case "100001":
                return flightRepository.findByDateBetweenAndEquipajeAndOriginContainingIgnoreCase
                        (startDate, endDate, equipaje, origin);

            case "010001":
                return flightRepository.findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCase
                        (startDate, endDate, equipaje, destination);

                case "110100":
                    return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase
                            (startDate, endDate, origin, destination, clase);

            case "110010":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual
                        (startDate, endDate, origin, destination, maxPasajeros);

            case "101100":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase
                        (startDate, endDate, origin, maxPrice, clase);

            case "101010":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual
                        (startDate, endDate, origin, maxPrice, maxPasajeros);

            case "011100":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase
                        (startDate, endDate, destination, maxPrice, clase);

            case "011010":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual
                        (startDate, endDate, destination, maxPrice, maxPasajeros);

            case "111100":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase
                        (startDate, endDate, origin, destination, maxPrice, clase);

            case "111010":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual
                        (startDate, endDate, origin, destination, maxPrice, maxPasajeros);

            case "100101":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndClaseContainingIgnoreCaseAndEquipaje
                        (startDate, endDate, origin, clase, equipaje);

            case "100011":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje
                        (startDate, endDate, origin, maxPasajeros, equipaje);

            case "010101":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndEquipaje
                        (startDate, endDate, destination, clase, equipaje);

            case "010011":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje
                        (startDate, endDate, destination, maxPasajeros, equipaje);

            case "001101":
                return flightRepository.findByDateBetweenAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndEquipaje
                        (startDate, endDate, maxPrice, clase, equipaje);

            case "001011":
                return flightRepository.findByDateBetweenAndPriceIsLessThanEqualAndPasajerosLessThanEqualAndEquipaje
                        (startDate, endDate, maxPrice, maxPasajeros, equipaje);

            case "101001":
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndEquipaje
                        (startDate, endDate, origin, maxPrice, equipaje);

            case "011001":
                return flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndEquipaje
                        (startDate, endDate, destination, maxPrice, equipaje);

            default:
                return flightRepository.findByDateBetween(startDate, endDate);
        }
    }

}

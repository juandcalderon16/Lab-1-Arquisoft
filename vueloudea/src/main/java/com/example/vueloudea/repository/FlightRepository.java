package com.example.vueloudea.repository;

import com.example.vueloudea.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

        // Método para buscar vuelos entre dos fechas
        List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);

        // Método para buscar vuelos entre dos fechas, con origen específico
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin);

        // Método para buscar vuelos entre dos fechas, con destino específico
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination);

        // Método para buscar vuelos entre dos fechas, con precio máximo
        List<Flight> findByDateBetweenAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con clase específica
        List<Flight> findByDateBetweenAndClaseContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String clase);

        // Método para buscar vuelos entre dos fechas, con número máximo de pasajeros
        List<Flight> findByDateBetweenAndPasajerosLessThanEqual(LocalDate startDate, LocalDate endDate, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido
        List<Flight> findByDateBetweenAndEquipaje(LocalDate startDate, LocalDate endDate, boolean equipaje);

        // Método para buscar vuelos entre dos fechas, con origen y destino específicos
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String origin, String destination);

        // Método para buscar vuelos entre dos fechas, con origen específico y precio máximo
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con destino específico y precio máximo
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con origen específico y clase específica
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String origin, String clase);

        // Método para buscar vuelos entre dos fechas, con origen específico y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con destino específico y clase específica
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String destination, String clase);

        // Método para buscar vuelos entre dos fechas, con destino específico y número máximo de pasajeros
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String destination, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con precio máximo y clase específica
        List<Flight> findByDateBetweenAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con clase específica y número máximo de pasajeros
        List<Flight> findByDateBetweenAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String clase, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido y origen específico
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido y destino específico
        List<Flight> findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String destination);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido y precio máximo
        List<Flight> findByDateBetweenAndEquipajeAndPriceLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido y clase específica
        List<Flight> findByDateBetweenAndEquipajeAndClaseContainingIgnoreCase(
                LocalDate startDate,LocalDate endDate, boolean equipaje, String clase);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico y precio máximo
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico y clase específica
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String origin, String destination, String clase);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con origen específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String origin, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con origen específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con destino específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con destino específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico, clase específica y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, String destination, String clase, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con origen específico, destino específico, precio máximo, clase específica y número máximo de pasajeros
        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String clase, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico y precio máximo
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, double maxPrice);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico y clase específica
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, String clase);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, destino específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String destination, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, destino específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String destination, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico, precio máximo y clase específica
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCase(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, double maxPrice, String clase);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico, precio máximo y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, double maxPrice, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico, clase específica y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, String clase, double maxPasajeros);

        // Método para buscar vuelos entre dos fechas, con equipaje incluido, origen específico, destino específico, precio máximo, clase específica y número máximo de pasajeros
        List<Flight> findByDateBetweenAndEquipajeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndPasajerosLessThanEqual(
                LocalDate startDate, LocalDate endDate, boolean equipaje, String origin, String destination, double maxPrice, String clase, double maxPasajeros);

        // Combinations with 3 criteria

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndClaseContainingIgnoreCaseAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, String clase, boolean equipaje);

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndEquipaje(
                LocalDate startDate, LocalDate endDate, String destination, String clase, boolean equipaje);

        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String destination, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndEquipaje(
                LocalDate startDate, LocalDate endDate, double maxPrice, String clase, boolean equipaje);

        List<Flight> findByDateBetweenAndPriceIsLessThanEqualAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, double maxPrice, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, double maxPrice, boolean equipaje);

        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice, boolean equipaje);

// Combinations with 4 criteria

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, double maxPrice, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndEquipaje(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice, String clase, boolean equipaje);

        List<Flight> findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String destination, double maxPrice, double maxPasajeros, boolean equipaje);

// Combinations with 5 criteria

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndClaseContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, String destination, String clase, double maxPasajeros, boolean equipaje);

        List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceIsLessThanEqualAndClaseContainingIgnoreCaseAndPasajerosLessThanEqualAndEquipaje(
                LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice, String clase, double maxPasajeros, boolean equipaje);
}
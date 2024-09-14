import React, { useState } from 'react';
import axios from 'axios';
import './App.css'; // Importamos los estilos

function App() {
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [origin, setOrigin] = useState('');
    const [destination, setDestination] = useState('');
    const [maxPrice, setMaxPrice] = useState('');
    const [equipaje, setEquipaje] = useState(null);
    const [clase, setClase] = useState('economica');
    const [maxPasajeros, setmaxPasajeros] = useState('');
    const [flights, setFlights] = useState([]);

    const searchFlights = async () => {
        const filters = {
            startDate,
            endDate,
            origin: origin || null,
            destination: destination || null,
            maxPrice: maxPrice || null,
            maxPasajeros: maxPasajeros || null,
            clase: clase || null,
            equipaje: equipaje !== null ? equipaje : undefined,
        };

        try {
            const response = await axios.get('http://localhost:8080/api/flights/search', {
              params: filters,
            });
            setFlights(response.data);
            console.log('Datos que se enviarian:', filters);
          } catch (error) {
            console.error('Error al buscar vuelos', error);
            console.log('Datos que se enviarán:', filters);
          }
    };

    return (
        <div className="App">
            <div className="container">
                <h1>Búsqueda de Vuelos</h1>
                <div className="search-form">
                    <div className="filter-group">
                        <label>Fecha de inicio:</label>
                        <input type="date" value={startDate} onChange={e => setStartDate(e.target.value)} />
                    </div>
                    <div className="filter-group">
                        <label>Fecha de fin:</label>
                        <input type="date" value={endDate} onChange={e => setEndDate(e.target.value)} />
                    </div>
                    <div className="filter-group checkbox">
                        <input
                            type="checkbox"
                            onChange={e => setOrigin(e.target.checked ? prompt('Ingresa el origen:') : '')}
                        /> Filtrar por Origen
                    </div>
                    <div className="filter-group checkbox">
                        <input
                            type="checkbox"
                            onChange={e => setDestination(e.target.checked ? prompt('Ingresa el destino:') : '')}
                        /> Filtrar por Destino
                    </div>
                    <div className="filter-group">
                        <label>Equipaje Incluido:</label>
                        <select onChange={e => setEquipaje(e.target.value === 'true')}>
                            <option value="">Cualquier opción</option>
                            <option value="true">Incluido</option>
                            <option value="false">No Incluido</option>
                        </select>
                    </div>
                    <div className="filter-group">
                        <label>Clase de vuelo:</label>
                        <select value={clase} onChange={e => setClase(e.target.value)}>
                            <option value="economica">Económica</option>
                            <option value="ejecutiva">Ejecutiva</option>
                        </select>
                    </div>
                    <div className="filter-group">
                        <label>Precio maximo del vuelo:</label>
                        <input type="number" value={maxPrice} onChange={e => setMaxPrice(e.target.value)} />
                    </div>
                    <button onClick={searchFlights}>Buscar Vuelos</button>
                </div>
                <h2>Vuelos Disponibles</h2>
                {flights.length > 0 ? (
                    <ul>
                        {flights.map(flight => (
                            <li key={flight.id}>
                                {flight.origin} a {flight.destination} - ${flight.price} el {flight.date}
                                (Equipaje {flight.equipajeIncluded ? 'Incluido' : 'No Incluido'})
                            </li>
                        ))}
                    </ul>
                ) : (
                    <p>No hay vuelos disponibles para los filtros seleccionados.</p>
                )}
            </div>
        </div>
    );
}

export default App;
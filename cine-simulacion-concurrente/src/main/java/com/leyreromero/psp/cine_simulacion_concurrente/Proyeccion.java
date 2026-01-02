package com.leyreromero.psp.cine_simulacion_concurrente;

import java.util.concurrent.atomic.AtomicInteger;

public class Proyeccion {

    private final int id;
    private final Sala sala;
    private final Pelicula pelicula;
    private final long horaInicio;
    
    // Índice atómico para recordar dónde nos quedamos buscando
    private final AtomicInteger ultimoAsientoBuscado = new AtomicInteger(0);

    public Proyeccion(int id, Sala sala, Pelicula pelicula, long hora) {
        this.id = id;
        this.sala = sala;
        this.pelicula = pelicula;
        this.horaInicio = hora;
    }
    
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public long getHoraInicio() { return horaInicio; }
    public int getId() { return id; }

    /**
     * Busca el primer asiento libre de forma eficiente.
     * En lugar de O(n) empezando de 0, empieza desde el último éxito.
     */
    public Asiento buscarAsientoLibre() {
        // Obtenemos la lista de asientos una sola vez para eficiencia
        var asientos = sala.getAsientos();
        int totalAsientos = asientos.size();
        
        // Empezamos a buscar desde donde lo dejamos
        int inicio = ultimoAsientoBuscado.get();
        
        for (int i = 0; i < totalAsientos; i++) {
            // Calculamos el índice actual usando el operador módulo para volver al inicio si llegamos al final
            int indiceActual = (inicio + i) % totalAsientos;
            Asiento a = asientos.get(indiceActual);
            
            if (!a.isReservado()) {
                // Actualizamos el índice para la siguiente taquilla
                ultimoAsientoBuscado.set(indiceActual);
                return a; 
            }
        }
        return null; // Aforo completo
    }
}
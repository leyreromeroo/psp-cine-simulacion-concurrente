package com.leyreromero.psp.cine_simulacion_concurrente;

public class Proyeccion {

	private int id;
    private Sala sala;
    private Pelicula pelicula;
    private long horaInicio;

    public Proyeccion(int id, Sala sala, Pelicula pelicula, long hora) {
        this.id = id;
        this.sala = sala;
        this.pelicula = pelicula;
        this.horaInicio = hora;
    }
    
    
    public Pelicula getPelicula() {
		return pelicula;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	public long getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(long horaInicio) {
		this.horaInicio = horaInicio;
	}


	// Método para buscar el primer asiento libre de forma segura
    public Asiento buscarAsientoLibre() {
        for (Asiento a : sala.getAsientos()) {
            if (!a.isReservado()) return a; // Intento rápido
        }
        return null;
    }


}

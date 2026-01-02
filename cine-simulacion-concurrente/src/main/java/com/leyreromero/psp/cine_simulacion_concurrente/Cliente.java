package com.leyreromero.psp.cine_simulacion_concurrente;

public class Cliente {

	private String nombre;
    private boolean tieneReserva = false;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    public void setReservaExitosa(boolean exito) { this.tieneReserva = exito; }
    public boolean hasReserva() { return tieneReserva; }
    public String getNombre() { return nombre; }
}

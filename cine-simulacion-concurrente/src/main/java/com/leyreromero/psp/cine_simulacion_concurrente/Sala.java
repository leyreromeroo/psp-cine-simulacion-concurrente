package com.leyreromero.psp.cine_simulacion_concurrente;

import java.util.ArrayList;
import java.util.List;

public class Sala {

	private int numeroSala;
    private List<Asiento> asientos;

    public Sala(int numeroSala, int capacidad) {
        this.numeroSala = numeroSala;
        this.asientos = new ArrayList<>();
        for (int i = 0; i < capacidad; i++) {
            asientos.add(new Asiento(i));
        }
    }

    public List<Asiento> getAsientos() { return asientos; }
}

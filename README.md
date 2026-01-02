# Simulación de Taquilla de Cine - PSP

Proyecto desarrollado para la asignatura de **Programación de Servicios y Procesos (2º DAM)**. La aplicación simula el sistema de venta de entradas de un cine antiguo, enfrentando retos clásicos de programación concurrente y sincronización de hilos en Java.

##  El Problema: Condiciones de Carrera
El objetivo principal es gestionar la venta de **200 asientos** evitando que múltiples taquillas vendan la misma entrada simultáneamente (condiciones de carrera). El sistema debe ser capaz de manejar la llegada constante de clientes y su espera en colas con capacidad limitada.

##  Características
- **Concurrencia Real:** Cada taquilla funciona en su propio hilo de ejecución.
- **Sincronización:** Uso de mecanismos de exclusión mutua para proteger el recurso compartido (los asientos).
- **Gestión de Colas (V2):** Implementación de un sistema multicola con límite de capacidad (máximo 10 personas por cola).
- **Simulación en Tiempo Real:** Los clientes llegan a un ritmo de 10-15 por minuto y cada venta toma entre 20 y 30 segundos simulados.

##  Parámetros Configurables
El sistema permite ajustar los siguientes valores para observar diferentes comportamientos:
* Número de taquillas operativas.
* Número de asientos totales en el cine.
* Número de colas disponibles y capacidad máxima de cada una.
* Tasa de generación de clientes (compradores por minuto).
* Rango de tiempo (mínimo/máximo) para completar una venta.

##  Estadísticas Finales
Al finalizar la simulación, el programa genera un informe con:
1.  **Clientes atendidos:** Cuántos consiguieron su entrada.
2.  **Clientes rechazados:** Cuántos se quedaron fuera por falta de aforo.
3.  **Tiempo de operación:** Duración total del proceso de venta.

## 🛠️ Tecnologías utilizadas
* **Lenguaje:** Java 17+
* **Conceptos:** Threads (Hilos), `synchronized`, `Locks`, y gestión de colas bloqueantes.

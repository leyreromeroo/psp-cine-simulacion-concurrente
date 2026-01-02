# Simulación de Taquilla de Cine - Concurrencia en Java (PSP)

Proyecto desarrollado para la asignatura de **Programación de Servicios y Procesos (2º DAM)**. Esta aplicación simula el ecosistema de venta de entradas de un cine tradicional, resolviendo problemas críticos de **sincronización**, **exclusión mutua** y **gestión de recursos compartidos**.

##  Desafío Técnico: Condiciones de Carrera
El núcleo del proyecto es evitar que dos hilos (Taquillas) asignen el mismo recurso (Asiento) al mismo tiempo. Se ha implementado una solución de **bloqueo de grano fino** para maximizar la concurrencia sin comprometer la integridad de los datos.

##  Funcionalidades Principales

### 1. Gestión de Hilos y Ciclo de Vida
- **Taquillas (Consumers):** Hilos independientes que procesan clientes de forma rotativa entre múltiples colas.
- **Generador de Clientes (Producer):** Hilo dedicado a la creación constante de compradores basado en una tasa de llegada configurable.
- **Cierre Controlado:** Uso de `interrupt()` para una finalización limpia y `join()` para asegurar la consistencia de los datos antes de mostrar resultados.

### 2. Sincronización y Seguridad de Hilos (Thread-Safety)
- **Exclusión Mutua:** Uso de bloques `synchronized` a nivel de objeto `Asiento` para evitar la sobreventa.
- **Atomicidad:** Implementación de `AtomicInteger` para garantizar la generación de IDs de reserva únicos y correlativos en entornos concurrentes.
- **Colecciones Sincronizadas:** Uso de `Collections.synchronizedList` y bloques de sincronización para la lectura/escritura segura de estadísticas globales.

### 3. Sistema de Colas Avanzado (V2)
- **Capacidad Limitada:** Uso de `ArrayBlockingQueue` para limitar las colas a un máximo de 10 personas.
- **Multicola:** Soporte para múltiples colas simultáneas. Las taquillas utilizan métodos no bloqueantes (`poll()`) para pivotar entre colas y evitar la inanición de hilos.

##  Parámetros Configurables
El sistema es 100% parametrizable desde la clase `AppTaquilla`, permitiendo ajustar:
- **Aforo:** Número total de asientos.
- **Infraestructura:** Cantidad de taquillas y número de colas disponibles.
- **Tiempos de Negocio:** Rango de tiempo de venta (mínimo/máximo) y tasa de llegada de clientes.
- **Simulación:** Tiempo total de apertura del cine antes del cierre automático.

##  Estadísticas y Reportes
Al finalizar, el sistema emplea `StringBuilder` para generar un informe de rendimiento eficiente que incluye:
- **Métricas de Aforo:** Clientes con entrada vs. clientes rechazados.
- **Métrica de Tiempo Real:** Cálculo exacto de la duración de la actividad de venta (desde la apertura hasta la última reserva realizada).
- **Recaudación:** Sumatorio total basado en el precio dinámico de la película.
- **Libro de Reservas:** Detalle completo de cada ticket con ID único, nombre del cliente, asiento y timestamp formateado (HH:mm:ss).

##  Tecnologías y Conceptos PSP
- **Java Threads & Runnable Interface**
- **Sincronización:** `synchronized`, `AtomicInteger`.
- **Estructuras Concurrentes:** `BlockingQueue`, `SynchronizedList`.
- **Inyección de Dependencias:** Arquitectura limpia evitando el uso de "magic numbers" y constantes acopladas.

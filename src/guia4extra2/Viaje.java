
package guia4extra2;

public class Viaje {
    private String origen;
    private String destino;
    private double distancia;
    private String tipoCombustible;
    private Vehiculo vehiculo;
    private int cantidadPeajes;
    private boolean mismaRuta;
    private int kmCiudadOrigen;
    private int kmCiudadDestino;
    
    public Viaje(String origen, String destino, double distancia, String tipoCombustible, Vehiculo vehiculo) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tipoCombustible = tipoCombustible;
        this.vehiculo = vehiculo;
        this.cantidadPeajes = 0;
        this.mismaRuta = true;
        this.kmCiudadOrigen = 0;
        this.kmCiudadDestino = 0;
    }
    
    public Viaje(String origen, int kmCiudadOrigen, String destino, int kmCiudadDestino, String tipoCombustible, Vehiculo vehiculo) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = 0;
        this.tipoCombustible = tipoCombustible;
        this.vehiculo = vehiculo;
        this.cantidadPeajes = 0;
        this.mismaRuta = false;
        this.kmCiudadOrigen = kmCiudadOrigen;
        this.kmCiudadDestino = kmCiudadDestino;
    }
    
    public double calcularDistancia() {
        if (mismaRuta) {
            return distancia;
        } else {
            return Math.abs(kmCiudadDestino - kmCiudadOrigen);
        }
    }
    
    public double calcularCostoPeajes() {
        if (vehiculo instanceof Auto || vehiculo instanceof Camioneta) {
            return cantidadPeajes * 100;
        } else if (vehiculo instanceof Camion) {
            return cantidadPeajes * 200;
        } else {
           return 0;
        }
    }
    
    public double calcularCostoCombustible() {
        double consumoCombustible = 0;
        
        if (vehiculo instanceof Auto) {
            consumoCombustible = 7;
        } else if (vehiculo instanceof Camioneta) {
            consumoCombustible = 10;
        } else if (vehiculo instanceof Camion) {
            consumoCombustible = 12;
        }
        
        double distanciaViaje = calcularDistancia();
        return (distanciaViaje / 100) * consumoCombustible * vehiculo.getPrecioCombustible();
    }
    
    public double calcularCostoTotal() {
        double costoCombustible = calcularCostoCombustible();
        double costoPeajes = calcularCostoPeajes();
        return costoCombustible + costoPeajes;
    }
}
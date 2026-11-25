public class Influencer {

    private String nombre;
    private int seguidores;
    private double costo;

    public Influencer(String nombre, int seguidores, double costo) {
        this.nombre = nombre;
        this.seguidores = seguidores;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public double getCosto() {
        return costo;
    }

    // Costo por cada 1000 seguidores (para el desafío)
    public double calcularCostoPorMil() {
        if (seguidores == 0) {
            return 0;
        }
        return costo / (seguidores / 1000.0);
    }

    public String mostrarInformacion() {
        return nombre + " - " + seguidores + " seguidores - Costo: $" + String.format("%.2f", costo);
    }
}
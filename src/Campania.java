import java.util.ArrayList;

public class Campania {

    private String nombre;
    // Agregación: la campaña guarda referencias a influencers existentes
    private ArrayList<Influencer> influencers;

    public Campania(String nombre) {
        this.nombre = nombre;
        influencers = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregarInfluencer(Influencer influencer) {
        if (influencer == null || buscarInfluencer(influencer.getNombre()) != null) {
            return false;
        }
        influencers.add(influencer);
        return true;
    }

    public boolean eliminarInfluencer(String nombre) {
        Influencer encontrado = buscarInfluencer(nombre);
        if (encontrado != null) {
            influencers.remove(encontrado);
            return true;
        }
        return false;
    }

    public Influencer buscarInfluencer(String nombre) {
        for (Influencer influencer : influencers) {
            if (influencer.getNombre().equalsIgnoreCase(nombre)) {
                return influencer;
            }
        }
        return null;
    }

    public int calcularAlcanceTotal() {
        int alcance = 0;
        for (Influencer influencer : influencers) {
            alcance += influencer.getSeguidores();
        }
        return alcance;
    }

    public double calcularCostoTotal() {
        double total = 0;
        for (Influencer influencer : influencers) {
            total += influencer.getCosto();
        }
        return total;
    }

    public String mostrarResumen() {
        String resumen = "Campaña: " + nombre + "\n";
        if (influencers.isEmpty()) {
            resumen += "Sin influencers contratados.\n";
        } else {
            for (Influencer influencer : influencers) {
                resumen += "- " + influencer.mostrarInformacion() + "\n";
            }
        }
        resumen += "Influencers: " + influencers.size() + "\n";
        resumen += "Alcance total: " + calcularAlcanceTotal() + " seguidores\n";
        resumen += "Costo total: $" + String.format("%.2f", calcularCostoTotal());
        return resumen;
    }

    // Desafío: menor costo por cada 1000 seguidores
    public Influencer obtenerMejorCostoPorMil() {
        Influencer mejor = null;
        for (Influencer influencer : influencers) {
            if (mejor == null || influencer.calcularCostoPorMil() < mejor.calcularCostoPorMil()) {
                mejor = influencer;
            }
        }
        return mejor;
    }
}
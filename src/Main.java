public class Main {

    public static void main(String[] args) {

        Influencer i1 = new Influencer("ModaConVale", 120000, 1500.00);
        Influencer i2 = new Influencer("TecnoMax", 85000, 900.00);
        Influencer i3 = new Influencer("FitLaura", 200000, 3000.00);
        Influencer i4 = new Influencer("ChefDani", 45000, 400.00);
        Influencer i5 = new Influencer("ViajaConLeo", 150000, 1800.00);

        Campania campania = new Campania("Lanzamiento Navidad");
        campania.agregarInfluencer(i1);
        campania.agregarInfluencer(i2);
        campania.agregarInfluencer(i4);
        campania.agregarInfluencer(i5);

        System.out.println("=== RESUMEN ===");
        System.out.println(campania.mostrarResumen());
        System.out.println();

        System.out.println("Alcance total: " + campania.calcularAlcanceTotal() + " seguidores");
        System.out.println("Costo total: $" + String.format("%.2f", campania.calcularCostoTotal()));
        System.out.println();

        System.out.println("=== BUSCAR ===");
        Influencer encontrado = campania.buscarInfluencer("TecnoMax");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        }
        Influencer noEsta = campania.buscarInfluencer("FitLaura");
        if (noEsta == null) {
            System.out.println("FitLaura no está en esta campaña (retornó null)");
        }
        System.out.println();

        System.out.println("=== ELIMINAR ===");
        System.out.println("Eliminar ModaConVale: " + campania.eliminarInfluencer("ModaConVale"));
        System.out.println("Eliminar NoExiste: " + campania.eliminarInfluencer("NoExiste"));
        System.out.println(campania.mostrarResumen());
        System.out.println();

        System.out.println("=== DESAFÍO ===");
        Influencer mejor = campania.obtenerMejorCostoPorMil();
        if (mejor != null) {
            System.out.println("Menor costo por cada 1000 seguidores: " + mejor.getNombre()
                    + " ($" + String.format("%.2f", mejor.calcularCostoPorMil()) + " por mil)");
        }
        System.out.println();

        Campania otra = new Campania("Verano Fitness");
        otra.agregarInfluencer(i3);
        otra.agregarInfluencer(i1); // i1 fue eliminado de la primera, pero sigue existiendo
        otra.agregarInfluencer(i2); // i2 está en las dos campañas
        System.out.println("=== OTRA CAMPAÑA ===");
        System.out.println(otra.mostrarResumen());
    }
}
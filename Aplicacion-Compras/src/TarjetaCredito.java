import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TarjetaCredito {

    private double limite;
    private List<Compra> compras;

    public TarjetaCredito(double limite) {
        this.limite = limite;
        this.compras = new ArrayList<>();
    }

    public boolean agregarCompra(Compra compra) {
        if (compra.getMonto() <= limite) {
            compras.add(compra);
            limite -= compra.getMonto();
            return true;
        } else {
            System.out.println("Saldo insuficiente para esta compra");
            return false;
        }
    }

    public double getSaldoDisponible() {
        return limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DE COMPRAS ---");
        Collections.sort(compras, new Comparator<Compra>() {
            @Override
            public int compare(Compra o1, Compra o2) {
                return Double.compare(o2.getMonto(), o1.getMonto());
            }
        });
        for (Compra compra : compras) {
            System.out.println(compra);
        }
        System.out.println("Saldo Tarjeta: $" + limite);
    }
}

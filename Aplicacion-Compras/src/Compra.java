public class Compra {

    private String descripcion;
    private double monto;

    public Compra(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return descripcion + " - $" + monto;
    }
}


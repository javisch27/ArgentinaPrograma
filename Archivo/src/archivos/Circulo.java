package archivos;

public class Circulo {

    Punto centro;
    double radio;

    public Circulo(Punto centro, double radio) {
        if (radio <= 0)
            throw new Error("Radio inválido");
        this.centro = centro;
        this.radio = radio;
    }
    @Override
    public String toString() {
        return "[centro=" + centro + ", radio=" + radio + "]";
    }

}

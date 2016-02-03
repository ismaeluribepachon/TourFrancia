package Comunes;

public class Etapa {
    private int NumEtapa;
    private String CiudadSalida;
    private String CiudadEntrada;

    public Etapa(int NumEtapa, String CiudadSalida, String CiudadEntrada) {
        this.NumEtapa = NumEtapa;
        this.CiudadSalida = CiudadSalida;
        this.CiudadEntrada = CiudadEntrada;
    }

    public int getNumEtapa() {
        return NumEtapa;
    }

    public String getCiudadSalida() {
        return CiudadSalida;
    }

    public String getCiudadEntrada() {
        return CiudadEntrada;
    }

    public void setNumEtapa(int NumEtapa) {
        this.NumEtapa = NumEtapa;
    }

    public void setCiudadSalida(String CiudadSalida) {
        this.CiudadSalida = CiudadSalida;
    }

    public void setCiudadEntrada(String CiudadEntrada) {
        this.CiudadEntrada = CiudadEntrada;
    }

    @Override
    public String toString() {
        return "NumEtapa=" + NumEtapa + ", CiudadSalida=" + CiudadSalida + ", CiudadEntrada=" + CiudadEntrada;
    }
    
    
}

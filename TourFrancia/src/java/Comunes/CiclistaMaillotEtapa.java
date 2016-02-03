package Comunes;

public class CiclistaMaillotEtapa {
    private String Nombre;
    private int NumEtapa;
    private String Color;

    public CiclistaMaillotEtapa(String Nombre, int NumEtapa, String Color) {
        this.Nombre = Nombre;
        this.NumEtapa = NumEtapa;
        this.Color = Color;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getNumEtapa() {
        return NumEtapa;
    }

    public String getColor() {
        return Color;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setNumEtapa(int NumEtapa) {
        this.NumEtapa = NumEtapa;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "Nombre=" + Nombre + ", NumEtapa=" + NumEtapa + ", Color=" + Color;
    }
    
    
    
}

package Comunes;

public class Maillot {
    private String Codigo;
    private String Color;
    private String Tipo;

    public Maillot(String Codigo, String Color, String Tipo) {
        this.Codigo = Codigo;
        this.Color = Color;
        this.Tipo = Tipo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getColor() {
        return Color;
    }
    
    public String getTipo() {
        return Tipo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}

package Comunes;

public class Equipo {
    private int IdEquipo;
    private String Nombre;
    private String Director;

    public Equipo(int IdEquipo, String Nombre, String Director) {
        this.IdEquipo = IdEquipo;
        this.Nombre = Nombre;
        this.Director = Director;
    }

    public Equipo(String Nombre, String Director) {
        this.Nombre = Nombre;
        this.Director = Director;
    }

    public int getIdEquipo() {
        return IdEquipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDirector() {
        return Director;
    }

    public void setIdEquipo(int IdEquipo) {
        this.IdEquipo = IdEquipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    @Override
    public String toString() {
        return "IdEquipo=" + IdEquipo + ", Nombre=" + Nombre + ", Director=" + Director;
    }
    
    
}

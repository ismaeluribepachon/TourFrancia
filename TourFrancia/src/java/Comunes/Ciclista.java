package Comunes;

public class Ciclista {
    private int idCiclista;
    private String nombre;
    private int numDorsal;
    private int idEquipo;
    private String nEquipo;

    public Ciclista(int idCiclista, String nombre, int numDorsal, int idEquipo, String nEquipo) {
        this.idCiclista = idCiclista;
        this.nombre = nombre;
        this.numDorsal = numDorsal;
        this.idEquipo = idEquipo;
        this.nEquipo = nEquipo;
    }

    public Ciclista(String nombre, int numDorsal, int idEquipo) {
        this.nombre = nombre;
        this.numDorsal = numDorsal;
        this.idEquipo = idEquipo;
    }
    
    public int getIdCiclista() {
        return idCiclista;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumDorsal() {
        return numDorsal;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getnEquipo() {
        return nEquipo;
    }

    public void setIdCiclista(int idCiclista) {
        this.idCiclista = idCiclista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumDorsal(int numDorsal) {
        this.numDorsal = numDorsal;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setnEquipo(String nEquipo) {
        this.nEquipo = nEquipo;
    }

    @Override
    public String toString() {
        return "idCiclista=" + idCiclista + ", nombre=" + nombre + ", numDorsal=" + numDorsal + ", idEquipo=" + idEquipo + ", nEquipo=" + nEquipo;
    }

}

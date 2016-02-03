package Comunes;

public class Puerto {
    private int IdPuerto;
    private String Nombre;
    private int AltMax;
    private int IdCiclista;
    private int DorsalCiclista;
    private int IdCategoria;
    private String NombreCategoria;
    private int NumEtapa;

    public Puerto(int IdPuerto, String Nombre, int AltMax, int IdCiclista, int IdCategoria, int NumEtapa) {
        this.IdPuerto = IdPuerto;
        this.Nombre = Nombre;
        this.AltMax = AltMax;
        this.IdCiclista = IdCiclista;
        this.IdCategoria = IdCategoria;
        this.NumEtapa = NumEtapa;
    }

    public Puerto(int IdPuerto, String Nombre, int AltMax, int IdCiclista, int DorsalCiclista, int IdCategoria, String NombreCategoria, int NumEtapa) {
        this.IdPuerto = IdPuerto;
        this.Nombre = Nombre;
        this.AltMax = AltMax;
        this.IdCiclista = IdCiclista;
        this.DorsalCiclista = DorsalCiclista;
        this.IdCategoria = IdCategoria;
        this.NombreCategoria = NombreCategoria;
        this.NumEtapa = NumEtapa;
    }

    public int getIdPuerto() {
        return IdPuerto;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getAltMax() {
        return AltMax;
    }

    public int getIdCiclista() {
        return IdCiclista;
    }

    public int getNombreCiclista() {
        return DorsalCiclista;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public int getNumEtapa() {
        return NumEtapa;
    }

    public void setIdPuerto(int IdPuerto) {
        this.IdPuerto = IdPuerto;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setAltMax(int AltMax) {
        this.AltMax = AltMax;
    }

    public void setIdCiclista(int IdCiclista) {
        this.IdCiclista = IdCiclista;
    }

    public void setNombreCiclista(int DorsalCiclista) {
        this.DorsalCiclista = DorsalCiclista;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public void setNumEtapa(int NumEtapa) {
        this.NumEtapa = NumEtapa;
    }

    @Override
    public String toString() {
        return "IdPuerto=" + IdPuerto + ", Nombre=" + Nombre + ", AltMax=" + AltMax + ", IdCiclista=" + IdCiclista + ", DorsalCiclista=" + DorsalCiclista + ", IdCategoria=" + IdCategoria + ", NombreCategoria=" + NombreCategoria + ", NumEtapa=" + NumEtapa;
    }
    
}

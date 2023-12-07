package A_Clases;

public class Sala {

   private int NumeroSala;
    private int Capacidad;
    private String TipoSala;

    public Sala(int NumeroSala, int Capacidad, String TipoSala) {
        this.NumeroSala = NumeroSala;
        this.Capacidad = Capacidad;
        this.TipoSala = TipoSala;
    }

    public int getNumeroSala() {
        return NumeroSala;
    }

    public void setNumeroSala(int NumeroSala) {
        this.NumeroSala = NumeroSala;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public String getTipoSala() {
        return TipoSala;
    }

    public void setTipoSala(String TipoSala) {
        this.TipoSala = TipoSala;
    }

}

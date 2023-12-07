
package A_Clases;






public class Cines {
    
    private int RUC;
    private String Gerente;
    private String Distrito;
    private String Direccion;

    public Cines(int RUC, String Gerente, String Distrito, String Direccion) {
        this.RUC = RUC;
        this.Gerente = Gerente;
        this.Distrito= Distrito;
        this.Direccion = Direccion;
    }

    public int getRUC() {
        return RUC;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public String getGerente() {
        return Gerente;
    }

    public void setGerente(String Gerente) {
        this.Gerente = Gerente;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
}

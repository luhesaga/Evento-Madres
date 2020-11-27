package model;

public class Hijo extends Persona {
    private String colegio;
    private int grado;
    private String cedMad;

    public Hijo(String colegio, int grado, String cedMad, String identificacion, String nombre) {
        super(identificacion, nombre);
        this.colegio = colegio;
        this.grado = grado;
        this.cedMad = cedMad;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getCedMad() {
        return cedMad;
    }

    public void setCedMad(String cedMad) {
        this.cedMad = cedMad;
    }
    
    
    @Override
    public String mostrar() {
        String data = "Nombre: " + this.getNombre() +
                " - Id: " + this.getIdentificacion() + 
                " - Colegio: " + this.getColegio() +
                " - Grado: " + this.getGrado();        
        
        return data;
    }
    
    
}

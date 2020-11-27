package model;

import model.Persona;

public class Madre extends Persona {
    
    private String profesion;
    private String direccion;

    public Madre(String profesion, String direccion, String identificacion, String nombre) {
        super(identificacion, nombre);
        this.profesion = profesion;
        this.direccion = direccion;
    }

   
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String mostrar() {
                
        String data = "Nombre: " + this.getNombre() +
                " - Id: " + this.getIdentificacion() + 
                " - Profesion: " + this.getProfesion() +
                " - Direccion: " + this.getDireccion();
        
        
        return data;
    }
    
    
    
}

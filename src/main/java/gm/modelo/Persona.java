/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author herra
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.encontrarTodasPersonas",
            query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})


public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;
    
    private String nombre;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Personas{" + "idPersona=" + idPersona + ", nombre=" + nombre + '}';
    }        
}

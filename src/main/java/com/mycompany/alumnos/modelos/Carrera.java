/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alumnos.modelos;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author users
 */
@Entity
@Table(name = "carrera", catalog = "bdalumnos", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idCarrera"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.idCarrera = :idCarrera"),
    @NamedQuery(name = "Carrera.findByNombre", query = "SELECT c FROM Carrera c WHERE c.nombre = :nombre")})
public class Carrera implements Serializable {

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrera", nullable = false)
    private Integer idCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreraidCarrera")
    private Collection<Alumno> alumnoCollection;
    @JoinColumn(name = "Facultad_idFacultad", referencedColumnName = "idFacultad", nullable = false)
    @ManyToOne(optional = false)
    private Facultad facultadidFacultad;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }


    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    public Facultad getFacultadidFacultad() {
        return facultadidFacultad;
    }

    public void setFacultadidFacultad(Facultad facultadidFacultad) {
        this.facultadidFacultad = facultadidFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.alumnos.Carrera[ idCarrera=" + idCarrera + " ]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

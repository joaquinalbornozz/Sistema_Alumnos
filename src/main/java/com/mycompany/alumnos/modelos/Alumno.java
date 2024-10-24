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
@Table(name = "alumno", catalog = "bdalumnos", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idAlumno"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumno.findByRegistro", query = "SELECT a FROM Alumno a WHERE a.registro = :registro"),
    @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")})
public class Alumno implements Serializable {

    @Size(max = 45)
    @Column(name = "registro", length = 45)
    private String registro;
    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<MateriaHasAlumno> materiaHasAlumnoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlumno", nullable = false)
    private Integer idAlumno;
    @JoinColumn(name = "Carrera_idCarrera", referencedColumnName = "idCarrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera carreraidCarrera;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }


    public Carrera getCarreraidCarrera() {
        return carreraidCarrera;
    }

    public void setCarreraidCarrera(Carrera carreraidCarrera) {
        this.carreraidCarrera = carreraidCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.alumnos.Alumno[ idAlumno=" + idAlumno + " ]";
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<MateriaHasAlumno> getMateriaHasAlumnoCollection() {
        return materiaHasAlumnoCollection;
    }

    public void setMateriaHasAlumnoCollection(Collection<MateriaHasAlumno> materiaHasAlumnoCollection) {
        this.materiaHasAlumnoCollection = materiaHasAlumnoCollection;
    }
    
}

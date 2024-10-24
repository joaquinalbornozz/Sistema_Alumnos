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
import jakarta.persistence.ManyToMany;
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
@Table(name = "materia", catalog = "bdalumnos", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idMateria"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre")})
public class Materia implements Serializable {

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;
    @ManyToMany(mappedBy = "materiaCollection")
    private Collection<Docente> docenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<MateriaHasAlumno> materiaHasAlumnoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMateria", nullable = false)
    private Integer idMateria;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.alumnos.modelos.Materia[ idMateria=" + idMateria + " ]";
    }


    @XmlTransient
    public Collection<MateriaHasAlumno> getMateriaHasAlumnoCollection() {
        return materiaHasAlumnoCollection;
    }

    public void setMateriaHasAlumnoCollection(Collection<MateriaHasAlumno> materiaHasAlumnoCollection) {
        this.materiaHasAlumnoCollection = materiaHasAlumnoCollection;
    }


    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

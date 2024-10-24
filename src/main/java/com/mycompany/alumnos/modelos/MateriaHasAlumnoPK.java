/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alumnos.modelos;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author users
 */
@Embeddable
public class MateriaHasAlumnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Materia_idMateria", nullable = false)
    private int materiaidMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Alumno_idAlumno", nullable = false)
    private int alumnoidAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public MateriaHasAlumnoPK() {
    }

    public MateriaHasAlumnoPK(int materiaidMateria, int alumnoidAlumno, Date fecha) {
        this.materiaidMateria = materiaidMateria;
        this.alumnoidAlumno = alumnoidAlumno;
        this.fecha = fecha;
    }

    public int getMateriaidMateria() {
        return materiaidMateria;
    }

    public void setMateriaidMateria(int materiaidMateria) {
        this.materiaidMateria = materiaidMateria;
    }

    public int getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(int alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) materiaidMateria;
        hash += (int) alumnoidAlumno;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaHasAlumnoPK)) {
            return false;
        }
        MateriaHasAlumnoPK other = (MateriaHasAlumnoPK) object;
        if (this.materiaidMateria != other.materiaidMateria) {
            return false;
        }
        if (this.alumnoidAlumno != other.alumnoidAlumno) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.alumnos.MateriaHasAlumnoPK[ materiaidMateria=" + materiaidMateria + ", alumnoidAlumno=" + alumnoidAlumno + ", fecha=" + fecha + " ]";
    }
    
}

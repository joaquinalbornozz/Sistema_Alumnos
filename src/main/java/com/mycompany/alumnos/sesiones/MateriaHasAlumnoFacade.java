/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.alumnos.sesiones;

import com.mycompany.alumnos.modelos.MateriaHasAlumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author users
 */
@Stateless
public class MateriaHasAlumnoFacade extends AbstractFacade<MateriaHasAlumno> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaHasAlumnoFacade() {
        super(MateriaHasAlumno.class);
    }
    
}

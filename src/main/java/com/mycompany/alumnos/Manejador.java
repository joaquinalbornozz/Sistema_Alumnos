
package com.mycompany.alumnos;

import com.mycompany.alumnos.modelos.Alumno;
import com.mycompany.alumnos.modelos.Facultad;
import com.mycompany.alumnos.modelos.Carrera;
import com.mycompany.alumnos.modelos.Materia;
import com.mycompany.alumnos.modelos.MateriaHasAlumno;
import com.mycompany.alumnos.modelos.Docente;
import com.mycompany.alumnos.sesiones.FacultadFacade;
import com.mycompany.alumnos.sesiones.AlumnoFacade;
import com.mycompany.alumnos.sesiones.CarreraFacade;
import com.mycompany.alumnos.sesiones.MateriaFacade;
import com.mycompany.alumnos.sesiones.MateriaHasAlumnoFacade;
import com.mycompany.alumnos.sesiones.DocenteFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@WebServlet(name = "Manejador", 
            loadOnStartup = 1, //Para que el sevlet se  instancia e inicia cdo se depliega 
            urlPatterns = {"/",
                           "/SolicitarDatos",
                           "/AgregarAlumno",
                           "/SolicitarMateria",
                           "/AgregarMateria",
                           "/SolicitarCarrera",
                           "/AgregarCarrera",
                           "/SolicitarFacultad",
                           "/AgregarFacultad",
                           "/SolicitarMatAlumno",
                           "/Listar",
                           "/Facultad",
                           "/ListarCarreras",
                           "/ListarMaterias",
                           "/ListarAluMat",
                           "/RindioDocente"
            }
            )

public class Manejador extends HttpServlet {
    @EJB
    private AlumnoFacade alumnoF;
    @EJB
    private FacultadFacade facultadF;
    @EJB
    private CarreraFacade carreraF;
    @EJB
    private MateriaFacade materiaF;
    @EJB
    private DocenteFacade docenteF;
    @EJB
    private MateriaHasAlumnoFacade maF;
    @PersistenceUnit 
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;    
    
    @Override
    public void init() throws ServletException{
        getServletContext().setAttribute("facultades", facultadF.findAll());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                //response.setContentType("text/html;charset=UTF-8");
                String pathUsuario = request.getServletPath();
                System.out.println("path = "+ pathUsuario);	    
                String url = null;
                EntityManager em = null;
                switch (pathUsuario) {
                    case "/":
                        request.setAttribute("facultades", facultadF.findAll());
                        url="index.jsp";
                        break;
                    case "/SolicitarDatos":
                        // Obtener lista de carreras y enviarla a la vista

                        request.setAttribute("carreras", carreraF.findAll());
                        url = "/WEB-INF/vista/SolicitarDatos.jsp";
                        break;

                    case "/AgregarAlumno":
                        String registro = request.getParameter("registro");
                        String nombre = request.getParameter("nombre");
                        String carreraId = request.getParameter("carrera");

                        Carrera carrera = carreraF.find(Integer.valueOf(carreraId));

                        Alumno alumno = new Alumno();
                        alumno.setRegistro(registro);
                        alumno.setNombre(nombre);
                        alumno.setCarreraidCarrera(carrera);

                        utx.begin();
                        em = emf.createEntityManager();
                        em.persist(alumno);
                        utx.commit();

                        url = "index.jsp";
                        break;
                    case "/SolicitarMateria":
                        url = "/WEB-INF/vista/Solicitar_Materia.jsp";
                        break;
                    case "/AgregarMateria":
                        String nombreM = request.getParameter("nombre");


                        Materia materia = new Materia();
                        materia.setNombre(nombreM);

                        utx.begin();
                        em = emf.createEntityManager();
                        em.persist(materia);
                        utx.commit();

                        url = "index.jsp";
                        break;
                    case "/SolicitarCarrera":
                        request.setAttribute("facultades", facultadF.findAll());
                        url = "/WEB-INF/vista/Solicitar_Carrera.jsp";
                        break;
                    case "/AgregarCarrera":
                        String nombreC = request.getParameter("nombre");
                        String facultadId= request.getParameter("facultad");

                        carrera = new Carrera();
                        carrera.setNombre(nombreC);
                        Facultad facultad=facultadF.find(Integer.parseInt(facultadId));
                        carrera.setFacultadidFacultad(facultad);

                        utx.begin();
                        em = emf.createEntityManager();
                        em.persist(carrera);
                        utx.commit();

                        url = "index.jsp";
                        break;
                    case "/SolicitarFacultad":
                        url = "/WEB-INF/vista/Solicitar_Facultad.jsp";
                        break;
                    case "/AgregarFacultad":
                        String nombreF = request.getParameter("nombre");


                        facultad = new Facultad();
                        facultad.setNombre(nombreF);

                        utx.begin();
                        em = emf.createEntityManager();
                        em.persist(facultad);
                        utx.commit();

                        url = "index.jsp";
                        break;
                    case "/Listar":
                        
                        request.setAttribute("lista",alumnoF.findAll());
                        url = "/WEB-INF/vista/" + pathUsuario + ".jsp";
                        break;
                    case "/ListarCarreras":
                        request.setAttribute("lista", carreraF.findAll());
                        url = "/WEB-INF/vista/Carreras.jsp";
                        break;
                    case "/ListarMaterias":
                        request.setAttribute("lista", materiaF.findAll());
                        url = "/WEB-INF/vista/Materias.jsp";
                        break;
                    case "/ListarAluMat":
                        request.setAttribute("lista", maF.findAll());
                        url = "/WEB-INF/vista/Alumat.jsp";
                        break;
                    case "/SolicitarMatAlumno":
                        String numeroRegistro = request.getParameter("numeroRegistro"); // Recibir el número de registro del alumno
                        em = emf.createEntityManager();
                        if (numeroRegistro != null && !numeroRegistro.trim().isEmpty()) {

                            CriteriaBuilder cb = em.getCriteriaBuilder();
                            jakarta.persistence.criteria.CriteriaQuery<Alumno> cqAlumno = cb.createQuery(Alumno.class);
                            Root<Alumno> c = cqAlumno.from(Alumno.class);
                            cqAlumno.select(c);
                            cqAlumno.where(cb.equal(c.get("registro"), numeroRegistro));

                            Query qAlumno = em.createQuery(cqAlumno); 

                            System.out.println("Buscando materias para el alumno con registro: " + numeroRegistro);

                            alumno = null;
                            try {
                                alumno = (Alumno) qAlumno.getSingleResult();
                            } catch (jakarta.persistence.NoResultException e) {
                                System.out.println("No se encontró ningún alumno con ese registro");
                            } catch (jakarta.persistence.NonUniqueResultException e) {
                                System.out.println("Se encontraron múltiples alumnos con ese registro");
                            }

                            if (alumno != null) {
                                jakarta.persistence.criteria.CriteriaQuery<MateriaHasAlumno> cqMateria = cb.createQuery(MateriaHasAlumno.class);
                                Root<MateriaHasAlumno> a = cqMateria.from(MateriaHasAlumno.class);
                                cqMateria.select(a);
                                cqMateria.where(cb.equal((a.get("alumno")).get("idAlumno"), alumno.getIdAlumno()));

                                Query qMaterias = em.createQuery(cqMateria);
                                List<MateriaHasAlumno> materiasAlumno = qMaterias.getResultList();

                                if (materiasAlumno != null && !materiasAlumno.isEmpty()) {
                                    request.setAttribute("materias", materiasAlumno);
                                    request.setAttribute("alumno", alumno);
                                } else {
                                    System.out.println("No se encontraron materias para el alumno con registro: " + numeroRegistro);
                                    request.setAttribute("error", "No se encontró ningún alumno con materias para ese número de registro.");
                                }
                            } else {
                                request.setAttribute("error", "No se encontró ningún alumno con ese número de registro.");
                            }

                        } else {
                            request.setAttribute("error", "Debe proporcionar un número de registro.");
                        }

                        url = "/WEB-INF/vista/Solicitar_Mat_Alumno.jsp";
                        break;

                    case "/Facultad":
                        Integer nroFacultad= Integer.parseInt(request.getParameter("codigoFacu"));
                        Facultad mifacu = facultadF.find(nroFacultad);
                        getServletContext().setAttribute("facultad",mifacu);
                        url="/WEB-INF/vista/ListarCarreras.jsp";
                        break;
                    case "/RindioDocente":
                        request.setAttribute("docentes", docenteF.findAll());
                        String doc= request.getParameter("docente");
                        if(doc!=null && !doc.trim().isEmpty())
                        {
                            Docente docente= docenteF.find(Integer.parseInt(doc));
                            Collection<Materia> materias=docente.getMateriaCollection();
                            List<MateriaHasAlumno> mha = new ArrayList<>();
                            List<Alumno> alumnos = new ArrayList<>();

                            for (Materia mat : materias) {
                                Collection<MateriaHasAlumno> mhaPorMateria = mat.getMateriaHasAlumnoCollection();

                                mha.addAll(mhaPorMateria);
                            }
                            /*for(MateriaHasAlumno m :mha){
                                alumnos.add(m.getAlumno());
                            }
                            request.setAttribute("alumnos", alumnos);*/
                            request.setAttribute("mha", mha);
                        }
                        
                        url="/WEB-INF/vista/Docente.jsp";
                        break;
                }
                
                // usa RequestDispatcher para reTransmitir el requerimiento
                try {
                    request.getRequestDispatcher(url).forward(request, response);
                } catch (ServletException | IOException ex) {
                }
                
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Manejador.class.getName()).log(Level.SEVERE, null, ex);
            }	    

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

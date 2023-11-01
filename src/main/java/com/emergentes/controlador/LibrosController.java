package com.emergentes.controlador;

import com.emergentes.dao.LibrosDAO;
import com.emergentes.dao.LibrosDAOimpl;
import com.emergentes.modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibrosController", urlPatterns = {"/LibrosController"})
public class LibrosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LibrosDAO dao = new LibrosDAOimpl();
        Libros lib = new Libros();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("libro", lib);
                request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                 {
                    try {
                        //obtener el objeto que corresponde al regristro
                        lib = dao.getById(id);
                    } catch (Exception ex) {
                        System.out.println("Error al obtener registro" + ex.getMessage());
                    }
                }
                //colocar como atributo
                request.setAttribute("libro", lib);
                //tranferir el control a frmaviso.jps
                request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                 {
                    try {
                        dao.delete(id);
                    } catch (Exception ex) {
                        System.out.println("Error al eliminar:" + ex.getMessage());
                    }
                }
                response.sendRedirect("LibrosController");

                break;

            case "view":
                List<Libros> lista = new ArrayList<Libros>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar: " + ex.getMessage());
                }
                request.setAttribute("libro", lista);
                request.getRequestDispatcher("libros.jsp").forward(request, response);
                break;
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria");

        Libros lib = new Libros();
        lib.setId(id);
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setDisponible(disponible);
        lib.setCategoria(categoria);

       LibrosDAO dao = new LibrosDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(lib);
            } catch (Exception ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
            }
        } else {
            try {
                dao.update(lib);
            } catch (Exception ex) {
                System.out.println("Error al editar: " + ex.getMessage());
            }
        }
        response.sendRedirect("LibrosController");

    }

}

/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.webapp.cine;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class cineServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        cineDAO dao = new cineDAO();

        String action = request.getParameter("action");

        if (action == null) {   

            request.setAttribute("movieList", dao.getall());
            request.getRequestDispatcher("cine.jsp").forward(request, response);

            return;

        }
        
        

        if (action.equals("Delete")) {

            int id = Integer.parseInt(request.getParameter("id"));

            dao.delete(id);
            
             request.getSession().setAttribute("mensajeExito", "¡Película eliminada con éxito!");

            response.sendRedirect("cineServlet");

            return;
        }

        if (action.equals("edit")) {

            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("PeliculaObject", dao.getallbyId(id));
            request.getRequestDispatcher("cine-edit.jsp").forward(request, response);

            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("txtid");
        int txtid = (idParam != null && !idParam.trim().isEmpty()) ? Integer.parseInt(idParam) : 0;
        cineDAO dao = new cineDAO();
        if (txtid == 0) {

            dao.save(new ClasePelicula(0,
                    request.getParameter("txttitle"),
                    request.getParameter("txtdirector"),
                    Integer.parseInt(request.getParameter("txtyear")),
                    request.getParameter("txtimageUrl")));

        } else {

            dao.update(new ClasePelicula(txtid,
                    request.getParameter("txttitle"),
                    request.getParameter("txtdirector"),
                    Integer.parseInt(request.getParameter("txtyear")),
                    request.getParameter("txtimageUrl")));

        }
        request.getSession().setAttribute("mensajeExito", "¡Operación realizada con éxito!");
        response.sendRedirect("cineServlet");

    }

}

<%-- 
    Document   : cine
    Created on : Oct 31, 2026, 2:13:41 PM
    Author     : Administrador
--%>

<%@page import="java.util.List"%>
<%@page import="my.webapp.cine.ClasePelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cine online</title>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
        <script type="module" src="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-1a/pXj49ZQ1aHEmrJ+gMw1otqoVsYwlEnlD8mIfY2TV03r20Y0CN7uqx1tQogjPL" crossorigin="anonymous"></script>


    </head>

    <body>  
        <%
            List<ClasePelicula> movieList = (List<ClasePelicula>) request.getAttribute("movieList");
        %>


        <div class="container mt-4">

            <%
                String msg = (String) session.getAttribute("mensajeExito");
                if (msg != null) {
                    session.removeAttribute("mensajeExito");
            %>
           
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <%= msg%>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <% } %>


            <h1 class="mb-4">Cartelera de películas</h1> 

            <button type="button" onclick="window.location.href = 'cine-edit.jsp'" class="btn-solid theme-primary mb-4">Add new</button>


            <div class="row row-cols-1 md:row-cols-3 g-4">
                <% for (ClasePelicula pelicula : movieList) {%>
                <div class="col">
                    <div class="card h-100 shadow-sm">

                        <img src="<%= pelicula.getImageUrl()%>" class="card-img-top" alt="<%= pelicula.getTitle()%>" style="height: 350px; object-fit: cover;">

                        <div class="card-body">
                            <h4 class="card-title"><%= pelicula.getTitle()%></h4>
                            <p class="card-text mb-1"><strong>Director:</strong> <%= pelicula.getDirector()%></p>
                            <p class="card-text mb-3"><strong>Year:</strong> <%= pelicula.getYear()%></p>

                            <div class="d-flex gap-2">
                                <button onclick="window.location.href = 'cineServlet?action=edit&id=<%= pelicula.getId()%>'" class="btn-solid theme-success flex-grow-1">Edit</button>
                                <button onclick="window.location.href = 'cineServlet?action=Delete&id=<%= pelicula.getId()%>'" class="btn-solid theme-danger flex-grow-1">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
                <% }%>  
            </div>    
        </div>
    </body>
</html>

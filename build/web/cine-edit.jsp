<%-- 
    Document   : cine-edit
    Created on : Oct 31, 2026, 7:48:41 PM
    Author     : Administrador
--%>

<%@page import="my.webapp.cine.ClasePelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit-movie</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe" crossorigin="anonymous">
        <script type="module" src="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-1a/pXj49ZQ1aHEmrJ+gMw1otqoVsYwlEnlD8mIfY2TV03r20Y0CN7uqx1tQogjPL" crossorigin="anonymous"></script>

    </head>
    <body>

        <%
            ClasePelicula peliculaobject = (ClasePelicula) request.getAttribute("PeliculaObject");
        %>


        <div class="container">

            <h1>Add/Edit a new movie </h1> 

            <button type="button" onclick="window.location.href = 'cine-edit.jsp'" class="btn-solid theme-primary">Add new</button>

            <div class="card">
                <div class="card-body">
                    <form method="Post"action="cineServlet">                                         
                        <input name="txtid" type="number"id="txtid" value="<%=(peliculaobject != null) ? peliculaobject.getId() : ""%>" hidden="hidden">

                        <div class="form-floating m-b3">
                            <label for="txttitle">Title</label>
                            <input name="txttitle" type="text" class="form-control" id="txttitle" placeholder="Song of the Sea" value="<%=(peliculaobject != null) ? peliculaobject.getTitle() : ""%>">
                        </div>
                        <div class="form-floating m-b">
                            <label for="txtdirector">Director</label>
                            <input name="txtdirector" type="text" class="form-control" id="txtdirector" placeholder="Dean DeBlois"Value="<%=(peliculaobject != null) ? peliculaobject.getDirector() : ""%>">
                        </div>  
                        <div class="form-floating m-b">
                            <label for="txtyear">Year</label>
                            <input name="txtyear" type="number" class="form-control" id="txtyear" placeholder="2015" Value="<%=(peliculaobject != null) ? peliculaobject.getYear() : ""%>">
                        </div>  
                        <div class="form-floating m-b">
                            <label for="txtimageUrl">URL image</label>
                            <input name="txtimageUrl" type="text" class="form-control" id="txtimageUrl" placeholder=" https:"Value="<%=(peliculaobject != null) ? peliculaobject.getImageUrl() : ""%>">
                        </div>                                                                  
                        <button class="btn-solid theme-primary"type="submit"><%=(peliculaobject != null) ? "Edit" : "Save"%></button>
                    </form>   
                </div>
            </div>    
        </div>    
    </body>
</html>

<%@page import="chem.ristorante.objects.MesaObj"%>
<%@page import="chema.ristorante.objects.ClienteObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Mesa</title>
    </head>
    <%
        MesaObj CMesa = 
                (MesaObj)request.getSession().getAttribute("mesa");
        
    %>
    <body>
        <h1>Actualizar Mesa</h1>
        <br><br>
        
        <form id="myform" name="myform" action="MesaServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CMesa.getId() %>" disabled/>
            <br><br>
            
            <label>Estado:</label><br>
            <input type="number" id="estado" name="estado" value="<%= CMesa.getEstado() %>" />
            <br><br>
            
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CMesa.getId() %>" />
        </form>
    </body>
</html>

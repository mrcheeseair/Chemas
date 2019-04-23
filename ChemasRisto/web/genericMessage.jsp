<%-- 
    Document   : genericMessage
    Created on : Mar 29, 2019, 8:45:35 PM
    Author     : balbi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
    background-image: url("Images/9.jpg");
     background-repeat: no-repeat;
     background-size: cover;
}
.button {
    background-color: rgba(250, 128, 114, 0.9);
    border: none;
    color: black;
   padding: 20px 35px;
    text-align: center;
    font-size: 20px;
    cursor: pointer;
    margin:10px;
    margin-bottom:50px;
    font-weight: bold;
    font-family: "Calibri";
    border-radius: 25px;
    border: 5px solid  #122b02;
    
    
    
}

.button:hover {
    background-color: rgba(144,238,144,0.8);
}
            
            
            
            
            
        </style>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Confirmacion</title>
    </head>
    <%
        Integer iRowsObj = (Integer)request.getSession().getAttribute("rows");
        int iRows = iRowsObj.intValue();
    %>
    <body>
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
        <br><br>
        <center><h1 style="border-radius: 20px;font-family:arial;font-size:60px;color:white;font-weight: bold;padding: 15px; display:inline;  background-color: black;">¡Exito!</h1> <br> 
            <br><br><br>
        
        <center><p style="border-radius: 20px; font-family:arial;font-size:60px;color:white;font-weight: bold;padding: 15px; display:inline;  background-color: black;"><%= iRows %> registro fue actualizado</p></center>
        <br><br><br><br>
        <a href="index.html" class="button" >Menu principal</a>
    </body>
</html>

<%@page import="chem.ristorante.objects.DetalleObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
        
            
           body {
    background-image: url("Images/7.jpg");
     background-repeat: repeat-y;
     background-size: cover;}

input[type=submit] {
   background-color: rgba(250, 128, 114, 0.9);
  border: 0;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
  font-size:18px;
  font-family: arial;
  font-weight: bold;
  line-height: 1.4;
  padding: 10px;
  width: 180px;
  
}
input[type="submit"]:hover {
    background-color: rgb(220,20,60);
}
    
    
    input[type=text] {
    width: 200px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url("Images/2.png");
    background-position: 10px 10px; 
    background-size: 25px;
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
    font-family: "Arial";
    }
    
input[type=text]:focus {
    width: 30%;
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
    font-family: "Arial";
    border-radius: 25px;
   border: 5px solid  	#5F0000;
    
    
    
}

.button:hover {
    background-color: rgba(144,238,144,0.8);
}    
      
input[type=number] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url("Images/2.png");
    background-position: 10px 10px; 
    background-size: 25px;
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
    font-family: "Arial";
    }


input[type=number]:focus {
    width: 20%;
}
            
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/detalleUpdateScript.js" type="text/javascript"></script>
        <title>Update Detalle</title>
    </head>
    <%
        DetalleObj CDetalle = 
                (DetalleObj)request.getSession().getAttribute("detalle");
        
    %>
    <body>
        <a href="detalleForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">  Actualizar detalle  </h1></center>
       <br><br>
        
       <center><form style="font-family:arial;font-size:22px" autocomplete="off" id="myform" name="myform" action="DetalleServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="id" name="id" value="<%= CDetalle.getId() %>" />
            <br><br>
            
            
            <label>Orden Id:</label><br>
            <input type="number" id="ordenId" name="ordenId" value="<%= CDetalle.getOrdenId() %>" />
            <br><br>
            
            <label>Producto Id:</label><br>
            <input type="number" id="productoId" name="productoId" value="<%= CDetalle.getProductoId() %>" />
            <br><br>
            
             <label>Cantidad:</label><br>
            <input type="number" id="cantidad" name="cantidad" value="<%= CDetalle.getCantidad() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Actualizar"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            
           </form></center>
    </body>
</html>

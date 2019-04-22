<%@page import="chem.ristorante.objects.OrdenObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            
           body {
    background-image: url("Images/4.jpg");
     background-repeat: repeat-y;
     background-size: cover;}

input[type=submit] {
   background-color: rgba(250, 128, 114, 0.9);
  border: 0;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
  font-size:16px;
  font-weight: bold;
  line-height: 1.4;
  padding: 10px;
  width: 180px
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
      text-align: center;
    }
    
input[type=text]:focus {
    width: 20%;
      text-align: center;
}

input[type=number] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
      text-align: center;
    
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
    font-family: "Arial";
    }
    
input[type=number]:focus {
    width: 20%;
      text-align: center;
}

input[type=date] {
    width: 140px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    
    
   
    
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
    font-family: "Arial";
    }
    
input[type=date]:focus {
    width: 20%;
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
            
            
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/ordenUpdateScript.js" type="text/javascript"></script>
        <title>Update Orden</title>
    </head>
    <%
        OrdenObj COrden = 
                (OrdenObj)request.getSession().getAttribute("orden");
        
    %>
    <body>
        <a href="ordenForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       
        <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:7px; background-color: white;">Actualizar orden</h1></center>
        <br><br><br>
        <center><form id="myform" style="font-size:20pt;font-family:arial;"name="myform" action="OrdenServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= COrden.getId() %>" disabled/>
            <br><br>
            
             <label>Pago Id:</label><br>
            <input type="number" id="pago_id" name="pago_id" value="<%= COrden.getPagoId() %>" />
            <br><br>
            
             <label>Empleado Id:</label><br>
            <input type="number" id="empleado_id" name="empleado_id" value="<%= COrden.getEmpleadoId() %>" />
            <br><br>
            
            <label>Fecha:</label><br>
            <input type="date" id="fecha" name="fecha" value="<%= COrden.getFecha() %>" />
            <br><br>
            
            <label>Mesa Id:</label><br>
            <input type="number" id="mesa_id" name="mesa_id" value="<%= COrden.getMesaId() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Update"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= COrden.getId() %>" />
        </form>
    </body>
</html>

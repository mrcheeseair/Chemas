<%@page import="chem.ristorante.objects.EmpleadoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            
           body {
    background-image: url("Images/11.jpg");
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
    }
    
input[type=text]:focus {
    width: 20%;
}

input[type=number] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
    font-family: "Arial";
    }
    
input[type=number]:focus {
    width: 20%;
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
        <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/empleadoUpdateScript.js" type="text/javascript"></script>
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
        <title>Update Empleado</title>
    </head>
    <%
        EmpleadoObj CEmpleado = 
                (EmpleadoObj)request.getSession().getAttribute("empleado");
        
    %>
    <body>
        <a href="empleadoForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       
        <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:7px; background-color: white;">Actualizar empleado</h1></center>
       <br>
        <center><form id="myform" style="font-size:20pt;font-family:arial;"name="myform" action="EmpleadoServlet" method="get">
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Numero de empleado:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CEmpleado.getId() %>" disabled/>
            <br><br>
            
             <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= CEmpleado.getName() %>"/>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Apellido:</label><br>
            <input type="text" id="apellido" name="apellido" value="<%= CEmpleado.getApellido() %>"/>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Fecha nacimiento:</label><br>
            <input type="date" id="fechaNac" name="fechaNac" value="<%= CEmpleado.getFechaNac() %>"/>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Sexo:</label><br>
            <select id="sexo" name="sexo">
    <option id="sexo" name="sexo" ></option> 
    <option value="M">M</option>
    <option value="F">F</option>
    <option value="O">Otro</option>
   
</select>
             <br><br>
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Email:</label><br>
            <input type="text" id="email" name="email" value="<%= CEmpleado.getEmail() %>"/>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">DUI:</label><br>
            <input type="text" id="dui" name="dui" value="<%= CEmpleado.getDUI() %>"/>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Usuario:</label><br>
            <input type="text" id="usuario" name="usuario" value="<%= CEmpleado.getUsuario() %>"/>
            <br><br>
            
            
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Actualizar"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CEmpleado.getId() %>" />
        </form>
    </body>
</html>

<%-- 
    Document   : productoNew
    Created on : Apr 19, 2019, 4:01:49 PM
    Author     : josemejia
--%>

<%@page import="chem.ristorante.objects.CategoriaObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="chem.ristorante.objects.ProductoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo Producto</title>
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
       <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
         <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <script src="Scripts/productoNewScript.js" type="text/javascript"></script>
    </head>
    <style>
            
        
            
           body {
    background-image: url("Images/5.png");
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
      text-align: center;
    }
    
input[type=text]:focus {
    width: 20%;
      text-align: center;
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
      text-align: center;
    
    
    
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
      text-align: center;
    }


input[type=number]:focus {
    width: 20%;
      text-align: center;
}
            
        </style>
     <%
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCategoriaArray = CArray.iterator();
    %>
    
    <body>
        <a href="productoForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">  Agregar producto  </h1></center>
       <br><br>
        <center><form style="font-family:arial;font-size:22px" autocomplete="off" id="myform" name="myform" action="ProductoServlet" method="get">
            <label>Categoria</label><br>
            <select id="categoria_id" name="categoria_id">
                <option id="categoria_id" name="categoria_id" ></option>                
                <%
                    if(iteCategoriaArray!=null)
                    {
                        CategoriaObj CCategoriaFromTemp;
                        while(iteCategoriaArray.hasNext())
                        {
                            CCategoriaFromTemp = iteCategoriaArray.next();
                %>
                            <option id="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    name="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    value="<%= CCategoriaFromTemp.getId() %>">
                                <%= CCategoriaFromTemp.getName() %>
                            </option>
                <%
                        }
                    }
                %>
                
                
                
            </select>
            <br><br>
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" />
            <br><br>
            
            <label>Precio:</label><br>
            <input  type="number" id="precio" name="precio" step="0.01" />
           
            <br><br>
            
            <label>Descripcion:</label><br>
            <input type="text" id="descripcion" name="descripcion" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/>
            <input type="hidden" id="formid" name="formid" value="1" />
        </form>
        <br><br><br><br><br>
    </body>
</html>


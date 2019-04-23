<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="chem.ristorante.objects.CategoriaObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chem.ristorante.objects.ProductoObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
  text-align: center;
  
}
input[type="submit"]:hover {
    background-color: rgb(220,20,60);
    text-align: center;
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
    width: 30%;
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
    border: 5px solid  #122b02;
    
    
    
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
        <script src="Scripts/productoUpdateScript.js" type="text/javascript"></script>
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Producto</title>
    </head>
    <%
        ProductoObj CProducto = 
                (ProductoObj)request.getSession().getAttribute("producto");
        
 
        ArrayList<CategoriaObj> CArray = 
                (ArrayList<CategoriaObj>)request.getSession().getAttribute("categorias");
        Iterator<CategoriaObj> iteCategoriaArray = CArray.iterator();
    
    %>
    <body>
        <a href="productoForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">  Actualizar producto  </h1></center>
       <br><br>
        <center><form style="font-family:arial;font-size:22px" autocomplete="off" id="myform" name="myform" action="ProductoServlet" method="get">
            <label>Id:</label><br>
            <input type="number" id="nonId" name="nonId" value="<%= CProducto.getId() %>" disabled/>
            <br><br>
            
            <label>Categoria</label><br>
            <select id="categoria_id" name="categoria_id" >
                
                
                <option id="categoria_id" name="categoria_id" ></option>                
                
                <%
                    if(iteCategoriaArray!=null)
                    {
                        CategoriaObj CCategoriaFromTemp;
                        while(iteCategoriaArray.hasNext())
                        {
                            CCategoriaFromTemp = iteCategoriaArray.next();
                            if(CProducto.getIdCategoria() != CCategoriaFromTemp.getId())
                            {
                %>
                            <option id="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    name="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    value="<%= CCategoriaFromTemp.getId() %>">
                                <%= CCategoriaFromTemp.getName()%>
                            </option>
                <%
                            } 
                            else 
                            {
                                
                %>
                            <option id="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    name="categoria_id<%= CCategoriaFromTemp.getId() %>" 
                                    value="<%= CCategoriaFromTemp.getId() %>"
                                    selected>
                                <%= CCategoriaFromTemp.getName() %>
                            </option>
                            <%
                            }
                        }
                    }
                %>
                
                
                
            </select>
            <br><br>
            
            
            <label>Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<%= CProducto.getNombre() %>" />
            <br><br>
            
            <label>Precio:</label><br>
            <input type="number" id="precio" name="precio" step="0.01" value="<%= CProducto.getPrecio() %>" />
            <br><br>
            
            <label>Descripcion:</label><br>
            <input type="text" id="descripcion" name="descripcion" value="<%= CProducto.getDescripcion() %>" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Actualizar"/>
            <input type="hidden" id="formid" name="formid" value="5" />
            <input type="hidden" id="id" name="id" value="<%= CProducto.getId() %>" />
        </form>
    </body>
</html>

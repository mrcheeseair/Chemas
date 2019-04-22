<%@page import="java.util.Iterator"%>
<%@page import="chema.ristorante.objects.ProductoObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Producto</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
               
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

body {
    background-image: url("Images/5.png");
     background-repeat: no-repeat;
     background-size: cover;
}



    #inventario {
    font-family: "Calibri";
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

#inventario td, #inventario th {
    border: 1px solid #ddd;
    padding: 8px;
}

#inventario tr:nth-child(even){background-color: #f2f2f2;}
#inventario tr:nth-child(odd){background-color: white;}

#inventario tr:hover {background-color: #ddd;}


#inventario th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: center;
    background-color: rgba(250, 128, 114, 0.9);
    color: white;
}
            
            
            
        </style>
    <%
        ArrayList<ProductoObj> CArray = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("productos");
        Iterator<ProductoObj> iteArray = CArray.iterator();
    %>
    <body>
     <a href="productoNew.jsp" class="button" style="position: absolute; right: 0;">Agregar producto</a>
    <a href="index.html" class="button" style="position: absolute; left: 0;">Regresar</a> 
             
    <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:215px;height:125px;"></a></h2></center>
        
        <center><h1 style="font-family:arial;font-size:30px;color:black;font-weight: bold;">Productos</h1> <br> 
        
    <center><table id="inventario" style="font-family: arial; width:70%" border="1">
        <tr>
            <th>#</th>
            <th>Categoria</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Descripcion</th>
             <th colspan="2">Acciones</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                ProductoObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getIdCategoria() %></td>
                    <td><%= CTemp.getNombre() %></td>
                    <td>$ <%= CTemp.getPrecio() %></td>
                    <td><%= CTemp.getDescripcion() %></td>
                    <td>
                        <a href="ProductoServlet?formid=4&id=<%= CTemp.getId() %>">
                            Actualizar
                        </a>
                    </td>
                    <td>
                        <a href="ProductoServlet?formid=3&id=<%= CTemp.getId() %>">
                            Eliminar
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table></center>
    </body>
</html>

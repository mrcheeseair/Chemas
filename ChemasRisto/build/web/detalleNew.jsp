<%@page import="chem.ristorante.objects.ProductoObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="chem.ristorante.objects.OrdenObj"%>
<%@page import="java.util.ArrayList"%>

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
  font-size:16px;
  font-weight: bold;
  line-height: 1.4;
  padding: 10px;
  width: 180px
}
input[type="submit"]:hover {
    background-color: rgb(220,20,60);
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
        
         <%
        ArrayList<OrdenObj> CArray = 
                (ArrayList<OrdenObj>)request.getSession().getAttribute("ordenes");
        Iterator<OrdenObj> iteOrdenArray = CArray.iterator();
        
        ArrayList<ProductoObj> CArray1 = 
                (ArrayList<ProductoObj>)request.getSession().getAttribute("productos");
        Iterator<ProductoObj> iteProductoArray = CArray1.iterator();
    %>
    
        <title>Detalle Nuevo</title>
        <meta charset="UTF-8">
        <meta name="viewport" 
              content="width=device-width, initial-scale=1.0">
       <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/detalleNewScript.js" type="text/javascript"></script>
    </head>
    <body>
        <a href="detalleForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">  Agregar un nuevo detalle  </h1></center>
       <br><br>
        
       <center><form autocomplete="off" id="myform" style="font-size:17pt;font-family:arial;" name="myform" action="DetalleServlet" method="get">
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;"># de orden:</label><br>
           <select id="ordenId" name="ordenId">
                <option id="ordenId" name="ordenId" ></option>                
                <%
                    if(iteOrdenArray!=null)
                    {
                        OrdenObj COrdenFromTemp;
                        while(iteOrdenArray.hasNext())
                        {
                            COrdenFromTemp = iteOrdenArray.next();
                %>
                            <option id="categoria_id<%= COrdenFromTemp.getId() %>" 
                                    name="categoria_id<%= COrdenFromTemp.getId() %>" 
                                    value="<%= COrdenFromTemp.getId() %>">
                                <%= COrdenFromTemp.getId() %>
                            </option>
                <%
                        }
                    }
                %>
                
                
                
            </select>
            <br><br>
            
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Producto:</label><br>
            <select id="productoId" name="productoId">
                <option id="productoId" name="productId" ></option>                
                <%
                    if(iteOrdenArray!=null)
                    {
                        ProductoObj CProductoFromTemp;
                        while(iteProductoArray.hasNext())
                        {
                            CProductoFromTemp = iteProductoArray.next();
                %>
                            <option id="productoId<%= CProductoFromTemp.getId() %>" 
                                    name="productoId<%= CProductoFromTemp.getId() %>" 
                                    value="<%= CProductoFromTemp.getId() %>">
                                <%= CProductoFromTemp.getNombre() %>
                            </option>
                <%
                        }
                    }
                %>
            </select>
            <br><br>
            <label style="border-radius: 10px;padding: 5px; display:inline;  background-color: white;">Cantidad:</label><br>
            <input type="number" id="cantidad" name="cantidad" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/>
            <input type="hidden" id="formid" name="formid" value="1" />
           </form></center>
        
    </body>
</html>
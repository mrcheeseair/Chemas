<%@page import="chem.ristorante.objects.ProductoDetalleOrdenMesaJoinObj"%>
<%@page import="chem.ristorante.objects.DetalleProductoJoinObj"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            body {
    background-image: url("Images/7.jpg");
     background-repeat: repeat-y;
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
    border: 5px solid  	#5F0000;
    
    
    
}

.button:hover {
    background-color: rgba(144,238,144,0.8);
}

    #detalle {
    font-family: "Arial";
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

#detalle td, #detalle th {
    border: 1px solid #ddd;
    padding: 8px;
}

#detalle tr:nth-child(even){background-color: #f2f2f2;}
#detalle tr:nth-child(odd){background-color: white;}

#detalle tr:hover {background-color: #ddd;}


#detalle th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: center;
    background-color: rgba(250, 128, 114, 0.9);
    color: white;
}
            
            
            
        </style>
        
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Detalle</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        
        ArrayList<ProductoDetalleOrdenMesaJoinObj> CArray = 
                (ArrayList<ProductoDetalleOrdenMesaJoinObj>)request.getSession().getAttribute("detalles");
        Iterator<ProductoDetalleOrdenMesaJoinObj> iteArray = CArray.iterator();
    %>
    <body>
       
    <a href="index.html" class="button" style="position: absolute; left: 0;">Regresar</a>    
    <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:215px;height:125px;"></a></h2></center>
        <br><br>
        <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">Detalles</h1>  
            <br><br>
        <table id="detalle" style="font-family: arial; width:70%" border="1">
        <tr>
            <th>Id</th>
            <th>Orden Id</th>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio ($)</th>
        </tr>
        <%
            if(iteArray!=null)
            {
                ProductoDetalleOrdenMesaJoinObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getM_iDetalleId()%></td>
                    <td><%= CTemp.getM_iOrdenId()%></td>
                    <td><%= CTemp.getM_strNombre() %></td>
                    <td><%= CTemp.getM_iCantidad() %></td>
                    <td><%= CTemp.getM_dPrecio() %></td>
                    
                </tr>
        <%
                }
            }
        %>
        
        </table>
        <br><br>
      
    </body>
</html>

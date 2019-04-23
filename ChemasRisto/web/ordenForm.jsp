<%@page import="java.util.Iterator"%>
<%@page import="chem.ristorante.objects.OrdenObj"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            
            body {
    background-image: url("Images/10.jpg");
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

    #inventario {
    font-family: "Arial";
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
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Orden</title>
        <link href="styles/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<OrdenObj> CArray = 
                (ArrayList<OrdenObj>)request.getSession().getAttribute("ordenes");
        Iterator<OrdenObj> iteArray = CArray.iterator();
    %>
    <body>
        <a href="ordenNew.jsp" class="button" style="position: absolute; right: 0;">Agregar orden</a>
    <a href="index.html" class="button" style="position: absolute; left: 0;">Regresar</a>    
    <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:215px;height:125px;"></a></h2></center>
        <br><br>
        <center><h1 style="border-radius: 15px;font-family:arial;font-size:35px; display:inline; padding:10px; background-color: white;">Ordenes</h1>  
            <br><br>
        
    <center><table id="inventario" style="width:70%" border="1">
        <tr>
            <th>Id</th>
            <th>Pago Id</th>
            <th>Numero de empleado</th>
            <th>Fecha</th>
            <th>Numero de mesa</th>
            <th colspan="2">Acciones</th>
        </tr>
        <%
        
            if(iteArray!=null)
            {
                OrdenObj CTemp;
                while(iteArray.hasNext())
                {
                    CTemp = iteArray.next();
        %>
                <tr>
                    <td><%= CTemp.getId() %></td>
                    <td><%= CTemp.getPagoId() %></td>
                    <td><%= CTemp.getEmpleadoId() %></td>
                    
                    <td><%= CTemp.getFecha() %></td>
                    <td><%= CTemp.getMesaId() %></td>
                    <td>
                        <a href="OrdenServlet?formid=4&id=<%= CTemp.getId() %>">
                            Actualizar
                        </a>
                    </td>
                    <td>
                        <a href="OrdenServlet?formid=3&id=<%= CTemp.getId() %>">
                            Eliminar
                        </a>
                    </td>
                </tr>
        <%
                }
            }
        %>
        
        </table>
    </body>
</html>

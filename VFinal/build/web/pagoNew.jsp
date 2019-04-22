<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="chema.ristorante.objects.ClienteObj"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS Style/MainMenuStyle.css" rel="stylesheet" type="text/css"/>
         <script src="Scripts/jquery-3.4.0.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.js" type="text/javascript"></script>
        
        <script src="Scripts/pagoNewScript.js" type="text/javascript"></script>
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
        ArrayList<ClienteObj> CArray = 
                (ArrayList<ClienteObj>)request.getSession().getAttribute("clientes");
        Iterator<ClienteObj> iteClienteArray = CArray.iterator();
    %>
        <title>Nuevo metodo de pago</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
    </head>
    
    <body>
       
        <a href="pagoForm.jsp" class="button" style="position: absolute; left: 0;">Regresar</a> 
        
        <center><h2><a href="index.html"><img src="Images/1.png" alt="Logo" style="margin-top:0px;width:225px;height:150px;"></a></h2></center>
       
        <center><h1 style="font-family:arial;font-size:35px;">  Agregar metodo de pago  </h1></center>
       <br>
        <center><form id="myform" style="font-size:20pt;font-family:arial;" name="myform" action="PagoServlet" method="get">
            <label>Dui:</label><br>
            <select id="cliente_id" name="cliente_id">
                <option id="cliente_id" name="cliente_id" ></option>                
                <%
                    if(iteClienteArray!=null)
                    {
                        ClienteObj CClienteFromTemp;
                        while(iteClienteArray.hasNext())
                        {
                            CClienteFromTemp = iteClienteArray.next();
                %>
                            <option id="categoria_id<%= CClienteFromTemp.getId() %>" 
                                    name="categoria_id<%= CClienteFromTemp.getId() %>" 
                                    value="<%= CClienteFromTemp.getId() %>">
                                <%= CClienteFromTemp.getDui() %>
                            </option>
                <%
                        }
                    }
                %>
            <br><br>
            </select>
                <br><br>
            <label>Tipo de Pago:</label><br>
            <select id="tippo" name="tipo">
    <option id="tipo" name="tipo" ></option> 
    <option value="Credito">Credito</option>
    <option value="Debito">Debito</option>
    <option value="Cheque">Cheque</option>
    <option value="Efectivo">Efectivo</option>
   
</select>
            <br><br>
            <label style="border-radius: 10px;padding: 4px; display:inline;  background-color: white;">Numero (Tarjeta: 4 ultimos digitos, Cheque: 6 digitos, Efectivo: 0)</label><br>
            <input  type="number" id="numero" name="numero" value="0" />
            <br><br>
            
            <input type="submit" id="mysubmit" name="mysubmit" value="Agregar"/>
            <input type="hidden" id="formid" name="formid" value="1" />
            </form></center>
        
       
       
    </body>
</html>

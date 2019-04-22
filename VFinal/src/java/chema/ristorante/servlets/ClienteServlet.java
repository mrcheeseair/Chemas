package chema.ristorante.servlets;

import chema.ristorante.logic.ClienteLogic;
import chema.ristorante.objects.ClienteObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* your code */
            String strFormId = request.getParameter("formid");
            
            if(strFormId.equals("1"))
            {
                //get parameters
                String strNombre = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strDui = request.getParameter("dui");
                
                
                //access logic
                ClienteLogic CLogic = new ClienteLogic();
                int iRows = CLogic.insertClienteRows(strNombre, strApellido, strDui);
                System.out.println("insert cliente rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                ClienteLogic CLogic = new ClienteLogic();
                ArrayList<ClienteObj> CArray = CLogic.getAllClientes();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("clientes", CArray);
                response.sendRedirect("clienteForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ClienteLogic CLogic = new ClienteLogic();
                int iRows = CLogic.deleteClienteRows(iId);
                
                //send to frontend
                request.getSession().setAttribute("rows", iRows);
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("4"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ClienteLogic CLogic = new ClienteLogic();
                ClienteObj CCliente = CLogic.getClienteById(iId);
                
                //send to frontend
                request.getSession().setAttribute("cliente", CCliente);
                response.sendRedirect("clienteUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strNombre = request.getParameter("nombre");
                String strApellido = request.getParameter("apellido");
                String strDui = request.getParameter("dui");
                int iId = Integer.parseInt(strId);
                
                
                //access logic
                ClienteLogic CLogic = new ClienteLogic();
                int iRows = CLogic.updateClienteRows(iId,strNombre, strApellido, strDui);
                System.out.println("update cliente rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

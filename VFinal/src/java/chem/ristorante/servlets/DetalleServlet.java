package chem.ristorante.servlets;

import chem.ristorante.logic.DetalleLogic;
import chem.ristorante.objects.DetalleObj;
import chem.ristorante.objects.DetalleProductoJoinObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Detalle", urlPatterns = {"/DetalleServlet"})
public class DetalleServlet extends HttpServlet 
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
                
                String strOrdenId = request.getParameter("ordenId");
                String strProductoId = request.getParameter("productoId");
                String strCantidad = request.getParameter("cantidad");
                
                int iOrdenId = Integer.parseInt(strOrdenId);
                int iProductoId = Integer.parseInt(strProductoId);
                int iCantidad = Integer.parseInt(strCantidad);
                
                //access logic
                DetalleLogic CLogic = new DetalleLogic();
                int iRows = CLogic.insertDetalleRows(iOrdenId, iProductoId, iCantidad);
                System.out.println("inser meal rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                DetalleLogic CLogic = new DetalleLogic();
                ArrayList<DetalleProductoJoinObj> CArray = CLogic.getAllDetalles();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("detalles", CArray);
                response.sendRedirect("detalleForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                DetalleLogic CLogic = new DetalleLogic();
                int iRows = CLogic.deleteClientRows(iId);
                
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
                DetalleLogic CLogic = new DetalleLogic();
                DetalleObj CDetalle = CLogic.getDetalleById(iId);
                
                //send to frontend
                request.getSession().setAttribute("detalle", CDetalle);
                response.sendRedirect("detalleUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strOrdenId = request.getParameter("ordenId");
                String strProductoId = request.getParameter("productoId");
                String strCantidad = request.getParameter("cantidad");
                int iId = Integer.parseInt(strId);
                int iOrdenId = Integer.parseInt(strOrdenId);
                int iProductoId = Integer.parseInt(strProductoId);
                int iCantidad = Integer.parseInt(strCantidad);
                
                
                //access logic
                DetalleLogic CLogic = new DetalleLogic();
                int iRows = CLogic.updateDetalleRows(iId,iOrdenId, iProductoId, iCantidad);
                System.out.println("update client rows: " + iRows);
                
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

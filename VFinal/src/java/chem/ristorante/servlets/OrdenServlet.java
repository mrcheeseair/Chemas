package chem.ristorante.servlets;

import chem.ristorante.logic.OrdenLogic;
import chem.ristorante.objects.OrdenObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Orden", urlPatterns = {"/OrdenServlet"})
public class OrdenServlet extends HttpServlet 
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
                
                String strPagoId = request.getParameter("pago_id");
                String strEmpleadoId = request.getParameter("empleado_id");
                String strFecha = request.getParameter("fecha");
                String strMesaId = request.getParameter("mesa_id");
                
                int iPagoId = Integer.parseInt(strPagoId);
                int iEmpleadoId = Integer.parseInt(strEmpleadoId);
                int iMesaId = Integer.parseInt(strMesaId);
                
                //access logic
                OrdenLogic CLogic = new OrdenLogic();
                int iRows = CLogic.insertOrdenRows(iPagoId, iEmpleadoId, strFecha, iMesaId);
                System.out.println("inser meal rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                OrdenLogic CLogic = new OrdenLogic();
                ArrayList<OrdenObj> CArray = CLogic.getAllOrdenes();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("ordenes", CArray);
                response.sendRedirect("ordenForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                OrdenLogic CLogic = new OrdenLogic();
                int iRows = CLogic.deleteOrdenRows(iId);
                
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
                OrdenLogic CLogic = new OrdenLogic();
                OrdenObj CCategoria = CLogic.getOrdenById(iId);
                
                //send to frontend
                request.getSession().setAttribute("orden", CCategoria);
                response.sendRedirect("ordenUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strPagoId = request.getParameter("pago_id");
                String strEmpleadoId = request.getParameter("empleado_id");
                String strFecha = request.getParameter("fecha");
                String strMesaId = request.getParameter("mesa_id");
                int iId = Integer.parseInt(strId);
                int iPagoId = Integer.parseInt(strPagoId);
                int iEmpleadoId = Integer.parseInt(strEmpleadoId);
                int iMesaId = Integer.parseInt(strMesaId);
                
                //access logic
                OrdenLogic CLogic = new OrdenLogic();
                int iRows = CLogic.updateOrdenRows(iId, iPagoId, iEmpleadoId, strFecha, iMesaId);
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

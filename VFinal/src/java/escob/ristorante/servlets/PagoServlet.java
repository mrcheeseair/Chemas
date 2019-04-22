package escob.ristorante.servlets;

import escob.ristorante.logic.PagoLogic;
import escob.ristorante.objects.PagoObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PagoServlet", urlPatterns = {"/PagoServlet"})
public class PagoServlet extends HttpServlet 
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
                String strTipo = request.getParameter("tipo");
                String strClienteId = request.getParameter("cliente_id");
                String strNumero = request.getParameter("numero");
                int iNumero = Integer.parseInt(strNumero);
                int iClienteId = Integer.parseInt(strClienteId);
                
                //access logic
                PagoLogic CLogic = new PagoLogic();
                int iRows = CLogic.insertPagoRows(strTipo, iClienteId, iNumero);
                System.out.println("insert pago rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                PagoLogic CLogic = new PagoLogic();
                ArrayList<PagoObj> CArray = CLogic.getAllPagos();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("pagos", CArray);
                response.sendRedirect("pagoForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                PagoLogic CLogic = new PagoLogic();
                int iRows = CLogic.deletePagoRows(iId);
                
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
                PagoLogic CLogic = new PagoLogic();
                PagoObj CPago = CLogic.getPagoById(iId);
                
                //send to frontend
                request.getSession().setAttribute("pago", CPago);
                response.sendRedirect("pagoUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strClienteId = request.getParameter("cliente_id");
                String strTipo = request.getParameter("tipo");
                String strNumero = request.getParameter("numero");
                int iId = Integer.parseInt(strId);
                int iClienteId = Integer.parseInt(strClienteId);
                int iNumero = Integer.parseInt(strNumero);
                
                //access logic
                PagoLogic CLogic = new PagoLogic();
                int iRows = CLogic.updatePagoRows(iId, strTipo, iClienteId, iNumero);
                System.out.println("update pago rows: " + iRows);
                
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

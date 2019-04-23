package chem.ristorante.servlets;

import chem.ristorante.logic.MesaLogic;
import chem.ristorante.objects.ProductoDetalleOrdenMesaJoinObj;
import chem.ristorante.objects.DetalleProductoJoinObj;
import chem.ristorante.objects.MesaObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Mesa", urlPatterns = {"/MesaServlet"})
public class MesaServlet extends HttpServlet 
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
                String strEstado = request.getParameter("estado");
                int iEstado = Integer.parseInt(strEstado);
                
                
                
                //access logic
                MesaLogic CLogic = new MesaLogic();
                int iRows = CLogic.insertMesaRows(iEstado);
                
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                MesaLogic CLogic = new MesaLogic();
                ArrayList<ProductoDetalleOrdenMesaJoinObj> CArray = CLogic.getAllMesas();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("mesas", CArray);
                response.sendRedirect("mesaForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                MesaLogic CLogic = new MesaLogic();
                int iRows = CLogic.deleteMesaRows(iId);
                
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
                MesaLogic CLogic = new MesaLogic();
                ProductoDetalleOrdenMesaJoinObj CMesa = CLogic.getMesaById(iId);
                
                //send to frontend
                request.getSession().setAttribute("mesa", CMesa);
                response.sendRedirect("mesaUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strEstado = request.getParameter("estado");
                int iId = Integer.parseInt(strId);
                int iEstado = Integer.parseInt(strEstado);
                
                //access logic
                MesaLogic CLogic = new MesaLogic();
                int iRows = CLogic.updateMesaRows(iId, iEstado);
                System.out.println("update client rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
                
            }
            
            if(strFormId.equals("6"))
                {
                    String strMesaId = request.getParameter("mesaid");
                    int iMesaId = Integer.parseInt(strMesaId);
                    
                MesaLogic CLogic = new MesaLogic();
                ProductoDetalleOrdenMesaJoinObj CArray = CLogic.getMesaById(iMesaId);
                
                int estado = CArray.getM_iEstado();
                
                System.out.println(estado);
                        
                if(estado != 0)
                {
                    MesaLogic C2Logic = new MesaLogic();
                    ArrayList<ProductoDetalleOrdenMesaJoinObj> C2Array = C2Logic.getOrdenIdJoin(iMesaId);
                    
                    int iOrdenId = C2Array.get(0).getM_iOrdenIdT2();
                    System.out.println(iOrdenId);
                    
                    
                    ArrayList<ProductoDetalleOrdenMesaJoinObj> C3Array = C2Logic.getMesaEsp(iOrdenId);
                    System.out.println();
                    
                    request.getSession().setAttribute("detalles", C3Array);
                    response.sendRedirect("detalleFormJoin.jsp");
                    
                } else
                {
                    response.sendRedirect("noOrden.html");
                }
                
                
                
                }
                
        
        
        
        }}

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

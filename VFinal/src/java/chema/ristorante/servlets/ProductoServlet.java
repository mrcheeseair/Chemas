package chema.ristorante.servlets;

import chem.ristorante.logic.CategoriaLogic;
import chem.ristorante.objects.CategoriaObj;
import chema.ristorante.logic.ProductoLogic;
import chema.ristorante.objects.ProductoObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet 
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
                String strIdCategoria = request.getParameter("categoria_id");
                String strNombre = request.getParameter("nombre");
                String strPrecio = request.getParameter("precio");
                String strDescripcion = request.getParameter("descripcion");
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                double dPrecio = Double.parseDouble(strPrecio);
                
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.insertProductoRows(iIdCategoria,strNombre,dPrecio,strDescripcion);
                System.out.println("insert producto rows: " + iRows);
                
                //send to frontend
                request.getSession().setAttribute("rows", new Integer(iRows) );
                response.sendRedirect("genericMessage.jsp");
            }
            
            if(strFormId.equals("2"))
            {
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                ArrayList<ProductoObj> CArray = CLogic.getAllProductos();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("productos", CArray);
                response.sendRedirect("productoForm.jsp");
            }
            
            if(strFormId.equals("3"))
            {
                //get parameters
                String strId = request.getParameter("id");
                int iId = Integer.parseInt(strId);
                
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.deleteProductoRows(iId);
                
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
                ProductoLogic CLogic = new ProductoLogic();
                ProductoObj CClient = CLogic.getProductoById(iId);
                
                //access logic
                CategoriaLogic CLogic1 = new CategoriaLogic();
                ArrayList<CategoriaObj> CArray = CLogic1.getAllCategorias();
                
                //envair un correo
                
                //send to frontend
                request.getSession().setAttribute("categorias", CArray);
                
                
                //send to frontend
                request.getSession().setAttribute("producto", CClient);
                
                response.sendRedirect("productoUpdateForm.jsp");
            }   
            
            if(strFormId.equals("5"))
            {
                //get parameters
                String strId = request.getParameter("id");
                String strIdCategoria = request.getParameter("categoria_id");
                String strNombre = request.getParameter("nombre");
                String strPrecio = request.getParameter("precio");
                String strDescripcion = request.getParameter("descripcion");
                int iId = Integer.parseInt(strId);
                int iIdCategoria = Integer.parseInt(strIdCategoria);
                double dPrecio = Double.parseDouble(strPrecio);
                
                
                //access logic
                ProductoLogic CLogic = new ProductoLogic();
                int iRows = CLogic.updateProductoRows(iId,iIdCategoria,strNombre,dPrecio,strDescripcion);
                System.out.println("update producto rows: " + iRows);
                
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

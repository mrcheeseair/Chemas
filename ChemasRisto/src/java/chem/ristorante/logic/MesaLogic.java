package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.ProductoDetalleOrdenMesaJoinObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MesaLogic extends Logic
{
    
    
    //metodo2
    public int insertMesaRows(int p_iEstado)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.mesa(id,estado) "
                + "VALUES(0,"+p_iEstado+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    /*public int insertJoinRows(int p_iOrdenId)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.mesa(id,estado) "
                + "VALUES(0,"+p_iEstado+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }*/

    //metodo3
    public ArrayList<ProductoDetalleOrdenMesaJoinObj> getAllMesas() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.producto inner join chemas.detalle on producto.id = detalle.producto_id "
                + "inner join chemas.orden on detalle.orden_id = orden.id "
                + "inner join chemas.mesa on mesa.id = orden.mesa_id;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoDetalleOrdenMesaJoinObj> CArray = null;
        
        if(CResult!=null)
        {
             int iProductoId;
             int iCategoriaId;
             String strNombre;
             double dPrecio;
             String strDescripcion;
            
             int iDetalleId;
             int iOrdenId;
             int iProductIdT2;
             int iCantidad;
             int iOrdenIdT2;
             int iPagoId;
             int iEmpleadoId;
             String strFecha;
             int iMesaId;
             int iMesaIdT2;
             int iEstado;

            ProductoDetalleOrdenMesaJoinObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iProductoId = CResult.getInt("producto.id");
                    iCategoriaId = CResult.getInt("categoria_id");
                    strNombre = CResult.getString("nombre");
                    dPrecio = CResult.getDouble("precio");
                    strDescripcion = CResult.getString("descripcion");
                    iDetalleId = CResult.getInt("detalle.id");
                    iOrdenId = CResult.getInt("orden_id");
                    iProductIdT2 = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    iOrdenIdT2 = CResult.getInt("orden.id");
                    iPagoId = CResult.getInt("pago_id");
                    iEmpleadoId = CResult.getInt("empleado_id");
                    strFecha = CResult.getString("fecha");
                    iMesaIdT2 = CResult.getInt("mesa_id");
                    iMesaId = CResult.getInt("mesa.id");
                    iEstado = CResult.getInt("estado");
                    
                    CTemp = new ProductoDetalleOrdenMesaJoinObj(iProductoId,iCategoriaId,strNombre,dPrecio,strDescripcion,iDetalleId,iOrdenId,iProductIdT2,iCantidad,iOrdenIdT2,iPagoId,iEmpleadoId,strFecha,iMesaIdT2,iMesaId,iEstado);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MesaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteMesaRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "mesa");
        return iRows;
    }

    public ProductoDetalleOrdenMesaJoinObj getMesaById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.producto inner join chemas.detalle on producto.id = detalle.producto_id "
                + "inner join chemas.orden on detalle.orden_id = orden.id "
                + "inner join chemas.mesa on mesa.id = orden.mesa_id where mesa.id = "+p_iId+" ;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProductoDetalleOrdenMesaJoinObj CTemp = null;
        
        if(CResult!=null)
        {
            int iProductoId;
             int iCategoriaId;
             String strNombre;
             double dPrecio;
             String strDescripcion;
            
            int iDetalleId;
            int iOrdenId;
            int iProductIdT2;
            int iCantidad;
            int iOrdenIdT2;
            int iPagoId;
            int iEmpleadoId;
            String strFecha;
            int iMesaIdT2;
            int iMesaId;
            int iEstado;
            
            
            try 
            {
                while(CResult.next())
                {
                     iProductoId = CResult.getInt("producto.id");
                    iCategoriaId = CResult.getInt("categoria_id");
                    strNombre = CResult.getString("nombre");
                    dPrecio = CResult.getDouble("precio");
                    strDescripcion = CResult.getString("descripcion");
                    iDetalleId = CResult.getInt("detalle.id");
                    iOrdenId = CResult.getInt("orden_id");
                    iProductIdT2 = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    iOrdenIdT2 = CResult.getInt("orden.id");
                    iPagoId = CResult.getInt("pago_id");
                    iEmpleadoId = CResult.getInt("empleado_id");
                    strFecha = CResult.getString("fecha");
                    iMesaIdT2 = CResult.getInt("mesa_id");
                    iMesaId = CResult.getInt("mesa.id");
                    iEstado = CResult.getInt("estado");
                    
                    
                    CTemp = new ProductoDetalleOrdenMesaJoinObj(iProductoId,iCategoriaId,strNombre,dPrecio,strDescripcion,iDetalleId,iOrdenId,iProductIdT2,iCantidad,iOrdenIdT2,iPagoId,iEmpleadoId,strFecha,iMesaIdT2,iMesaId,iEstado);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MesaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateMesaRows(int p_iId, int p_iEstado) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.mesa "
                + "set estado = '"+p_iEstado+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    
    public ArrayList<ProductoDetalleOrdenMesaJoinObj> getOrdenIdJoin(int iMesaId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT id FROM chemas.orden WHERE mesa_id = "+iMesaId+" ORDER BY id DESC LIMIT 1";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoDetalleOrdenMesaJoinObj> CArray = null;
        
        if(CResult!=null)
        {
            
             int iOrdenIdT2;

            ProductoDetalleOrdenMesaJoinObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iOrdenIdT2 = CResult.getInt("orden.id");
                    
                    
                    CTemp = new ProductoDetalleOrdenMesaJoinObj(iOrdenIdT2);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MesaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    
     public ArrayList<ProductoDetalleOrdenMesaJoinObj> getMesaEsp(int p_iIdOrden) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.producto inner join chemas.detalle on producto.id = detalle.producto_id "
                + "inner join chemas.orden on detalle.orden_id = orden.id "
                + "inner join chemas.mesa on mesa.id = orden.mesa_id where orden.id = "+p_iIdOrden+" ;";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoDetalleOrdenMesaJoinObj> CArray = null;
        
        if(CResult!=null)
        {
            int iProductoId;
             int iCategoriaId;
             String strNombre;
             double dPrecio;
             String strDescripcion;
            
            int iDetalleId;
            int iOrdenId;
            int iProductIdT2;
            int iCantidad;
            int iOrdenIdT2;
            int iPagoId;
            int iEmpleadoId;
            String strFecha;
            int iMesaIdT2;
            int iMesaId;
            int iEstado;
            
            ProductoDetalleOrdenMesaJoinObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iProductoId = CResult.getInt("producto.id");
                    iCategoriaId = CResult.getInt("categoria_id");
                    strNombre = CResult.getString("nombre");
                    dPrecio = CResult.getDouble("precio");
                    strDescripcion = CResult.getString("descripcion");
                    iDetalleId = CResult.getInt("detalle.id");
                    iOrdenId = CResult.getInt("orden_id");
                    iProductIdT2 = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    iOrdenIdT2 = CResult.getInt("orden.id");
                    iPagoId = CResult.getInt("pago_id");
                    iEmpleadoId = CResult.getInt("empleado_id");
                    strFecha = CResult.getString("fecha");
                    iMesaIdT2 = CResult.getInt("mesa_id");
                    iMesaId = CResult.getInt("mesa.id");
                    iEstado = CResult.getInt("estado");
                    
                    
                    CTemp = new ProductoDetalleOrdenMesaJoinObj(iProductoId,iCategoriaId,strNombre,dPrecio,strDescripcion,iDetalleId,iOrdenId,iProductIdT2,iCantidad,iOrdenIdT2,iPagoId,iEmpleadoId,strFecha,iMesaIdT2,iMesaId,iEstado);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MesaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    
}

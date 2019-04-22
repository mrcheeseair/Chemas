package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.DetalleObj;
import chem.ristorante.objects.DetalleProductoJoinObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleLogic extends Logic
{
    //metodo1
    public boolean insertDetalleBool(int p_iOrdenId, int p_iProductoId, int p_iCantidad)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.detalle(id,orden_id,producto_id,cantidad) "
                + "VALUES(0,"+p_iOrdenId+","+p_iProductoId+","+p_iCantidad+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertDetalleRows(int p_iOrdenId, int p_iProductoId, int p_iCantidad)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.detalle(id,orden_id,producto_id,cantidad) "
                + "VALUES(0,"+p_iOrdenId+","+p_iProductoId+","+p_iCantidad+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<DetalleProductoJoinObj> getAllDetalles() // este metodo ocupa el objeto del Join
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.detalle " +
                        "inner join chemas.producto "
                        + "on detalle.producto_id = producto.id";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<DetalleProductoJoinObj> CArray = null;
        
        if(CResult!=null)
        {
            
             int iIdDetalle;
             int iOrdenId;
             int iIdProducto;
             int iCantidad;
             int iIdProductoT2;
             int iIdCategoria;
             String strNombreProd;
             double dPrecioProd;
             String strDesc;
            
            
            DetalleProductoJoinObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iIdDetalle = CResult.getInt("detalle.id");
                    iOrdenId = CResult.getInt("orden_id");
                    iIdProducto = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    iIdProductoT2 = CResult.getInt("producto.id");
                    iIdCategoria = CResult.getInt("categoria_id");
                    strNombreProd = CResult.getString("nombre");
                    dPrecioProd = CResult.getDouble("precio");
                    strDesc = CResult.getString("descripcion");
                    
                    CTemp = new DetalleProductoJoinObj(iIdDetalle, iOrdenId, iIdProducto, iCantidad, iIdProductoT2, iIdCategoria, strNombreProd, dPrecioProd, strDesc);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DetalleLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteClientRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "detalle");
        return iRows;
    }

    public DetalleObj getDetalleById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.detalle where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        DetalleObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iOrdenId;
            int iProductoId;
            int iCantidad;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iOrdenId = CResult.getInt("orden_id");
                    iProductoId = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    
                    CTemp = new DetalleObj(iId, iOrdenId, iProductoId, iCantidad);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DetalleLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateDetalleRows(int p_iId, int p_iOrdenId, int p_iProductoId, int p_iCantidad) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.detalle "
                + "set orden_id = "+p_iOrdenId+",producto_id = "+p_iProductoId+",cantidad = "+p_iCantidad+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    public ArrayList<DetalleObj> getDetallesMesa1() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.detalle ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<DetalleObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iOrdenId;
            int iProductoId;
            int iCantidad;
            
            
            DetalleObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iOrdenId = CResult.getInt("orden_id");
                    iProductoId = CResult.getInt("producto_id");
                    iCantidad = CResult.getInt("cantidad");
                    
                    CTemp = new DetalleObj(iId, iOrdenId, iProductoId, iCantidad);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DetalleLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
}

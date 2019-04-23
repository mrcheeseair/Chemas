package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.ProductoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoLogic extends Logic
{
    //metodo1
    public boolean insertClientBool(int p_iIdCategoria, String p_strNombre, double p_dPrecio, String p_strDescripcion)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.producto(id, categoria_id, nombre, precio, descripcion) "
                + "VALUES(0,"+p_iIdCategoria+",'"+p_strNombre+"',"+p_dPrecio+",'"+p_strDescripcion+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertProductoRows(int p_iIdCategoria, String p_strNombre, double p_dPrecio, String p_strDescripcion)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.producto(id, categoria_id, nombre, precio, descripcion) "
                + "VALUES(0,"+p_iIdCategoria+",'"+p_strNombre+"',"+p_dPrecio+",'"+p_strDescripcion+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<ProductoObj> getAllProductos() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.producto ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProductoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iIdCategoria;
            String strNombre;
            double dPrecio;
            String strDescripcion;
            
            ProductoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdCategoria = CResult.getInt("categoria_id");
                    strNombre = CResult.getString("nombre");
                    dPrecio = CResult.getDouble("precio");
                    strDescripcion = CResult.getString("descripcion");
                    
                    CTemp = new ProductoObj(iId, iIdCategoria, strNombre, dPrecio, strDescripcion);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteProductoRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "producto");
        return iRows;
    }

    public ProductoObj getProductoById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.producto where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProductoObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iIdCategoria;
            String strNombre;
            double dPrecio;
            String strDescripcion;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iIdCategoria = CResult.getInt("categoria_id");
                    strNombre = CResult.getString("nombre");
                    dPrecio = CResult.getDouble("precio");
                    strDescripcion = CResult.getString("descripcion");
                    
                    CTemp = new ProductoObj(iId, iIdCategoria, strNombre, dPrecio, strDescripcion);
                    System.out.println("LOGIC");
                    System.out.println(CTemp.getDescripcion());
                    System.out.println(CTemp.getId());
                    System.out.println(CTemp.getIdCategoria());
                    System.out.println(CTemp.getNombre());
                    System.out.println(CTemp.getPrecio());
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProductoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateProductoRows(int p_iId, int p_iIdCategoria, String p_strNombre, double p_dPrecio, String p_strDescripcion) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.producto "
                + "set categoria_id = "+p_iIdCategoria+",nombre = '"+p_strNombre+"',precio = "+p_dPrecio+",descripcion = '"+p_strDescripcion+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.CategoriaObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaLogic extends Logic
{
    //metodo1
    public boolean insertClientBool(String p_strName, int p_strDescripcion)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.categoria(id,name,age) "
                + "VALUES(0,'"+p_strName+"','"+p_strDescripcion+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertCategoriaRows(String p_strName, String p_strDescripcion)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.categoria(id,nombre,descripcion) "
                + "VALUES(0,'"+p_strName+"','"+p_strDescripcion+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<CategoriaObj> getAllCategorias() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.categoria ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<CategoriaObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescripcion;
            
            CategoriaObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strDescripcion = CResult.getString("descripcion");
                    
                    CTemp = new CategoriaObj(iId, strName, strDescripcion);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CategoriaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteClientRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "categoria");
        return iRows;
    }

    public CategoriaObj getCategoriaById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.categoria where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        CategoriaObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strDescrpcion;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strDescrpcion = CResult.getString("descripcion");
                    
                    CTemp = new CategoriaObj(iId, strName, strDescrpcion);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CategoriaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateCategoriaRows(int p_iId, String p_strName, String p_strDescripcion) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.categoria "
                + "set nombre = '"+p_strName+"',descripcion = '"+p_strDescripcion+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

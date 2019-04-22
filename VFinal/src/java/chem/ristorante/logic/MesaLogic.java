package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.CategoriaObj;
import chem.ristorante.objects.MesaObj;
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

    //metodo3
    public ArrayList<MesaObj> getAllMesas() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.mesa ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<MesaObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iEstado;
            
            MesaObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iEstado = CResult.getInt("estado");
                    
                    
                    CTemp = new MesaObj(iId, iEstado);
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

    public MesaObj getMesaById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.mesa where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        MesaObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iEstado;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iEstado = CResult.getInt("estado");
                    
                    
                    CTemp = new MesaObj(iId, iEstado);
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
    
    
     public ArrayList<MesaObj> getMesaEsp(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.mesa where id = "+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<MesaObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iEstado;
            
            MesaObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iEstado = CResult.getInt("estado");
                    
                    
                    CTemp = new MesaObj(iId, iEstado);
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

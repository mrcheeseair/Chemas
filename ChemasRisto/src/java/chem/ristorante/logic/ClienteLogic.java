package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.ClienteObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteLogic extends Logic
{
    //metodo1
    public boolean insertClienteBool(String p_strNombre, String p_strApellido)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.cliente(id, nombre, apellido) "
                + "VALUES(0,'"+p_strNombre+"','"+p_strApellido+"')";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertClienteRows(String p_strNombre, String p_strApellido, String p_strDui)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.cliente(id, nombre, apellido, dui) "
                + "VALUES(0,'"+p_strNombre+"','"+p_strApellido+"','"+p_strDui+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<ClienteObj> getAllClientes() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select*from chemas.cliente ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ClienteObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strDui;
            
            ClienteObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strDui = CResult.getString("dui");
                    
                    CTemp = new ClienteObj(iId, strNombre, strApellido, strDui);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteClienteRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "cliente");
        return iRows;
    }

    public ClienteObj getClienteById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.cliente where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ClienteObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strNombre;
            String strApellido;
            String strDui;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strNombre = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strDui = CResult.getString("dui");
                    
                    CTemp = new ClienteObj(iId, strNombre, strApellido, strDui);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateClienteRows(int p_iId, String p_strNombre, String p_strApellido, String p_strDui) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        //select*from chemas.cliente
        DatabaseX database = getDatabase();
        String strSql = "update chemas.cliente "
                + "set nombre = '"+p_strNombre+"',apellido = '"+p_strApellido+"',dui = '"+p_strDui+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

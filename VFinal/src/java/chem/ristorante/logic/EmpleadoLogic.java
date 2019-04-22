package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.EmpleadoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpleadoLogic extends Logic
{
    //metodo1
    public boolean insertEmpleadoBool(String p_strName, String p_strApellido, String p_strFechaNac, String p_strSexo, String p_strEmail, String p_strDUI, String p_strUsuario, String p_strContrasenia)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.empleado(id,name,apellido,fechaNac,sexo,email,dui,usuario,contrasenia) "
                + "VALUES(0,'"+p_strName+"','"+p_strApellido+"','"+p_strFechaNac+"','"+p_strSexo+"','"+p_strEmail+"','"+p_strDUI+"','"+p_strUsuario+"','"+p_strContrasenia+"');";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertEmpleadoRows(String p_strName, String p_strApellido, String p_strFechaNac, String p_strSexo, String p_strEmail, String p_strDUI, String p_strUsuario, String p_strContrasenia)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.empleado(id,nombre,apellido,fechaNac,sexo,email,dui,usuario,contrasenia) "
                + "VALUES(0,'"+p_strName+"','"+p_strApellido+"','"+p_strFechaNac+"','"+p_strSexo+"','"+p_strEmail+"','"+p_strDUI+"','"+p_strUsuario+"','"+p_strContrasenia+"')";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<EmpleadoObj> getAllEmpleados() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.empleado ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<EmpleadoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strApellido;
            String strFechaNac;
            String strSexo;
            String strEmail;
            String strDUI;
            String strUsuario;
            String strContrasenia;
            
            EmpleadoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strFechaNac = CResult.getString("fechaNac");
                    strSexo = CResult.getString("sexo");
                    strEmail = CResult.getString("email");
                    strDUI = CResult.getString("dui");
                    strUsuario = CResult.getString("usuario");
                    strContrasenia = CResult.getString("contrasenia");
                    
                    CTemp = new EmpleadoObj(iId, strName, strApellido, strFechaNac, strSexo, strEmail, strDUI, strUsuario, strContrasenia);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpleadoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteEmpleadoRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "empleado");
        return iRows;
    }

    public EmpleadoObj getEmpleadoById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.empleado where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        EmpleadoObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            String strApellido;
            String strFechaNac;
            String strSexo;
            String strEmail;
            String strDUI;
            String strUsuario;
            String strContrasenia;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("nombre");
                    strApellido = CResult.getString("apellido");
                    strFechaNac = CResult.getString("fechaNac");
                    strSexo = CResult.getString("sexo");
                    strEmail = CResult.getString("email");
                    strDUI = CResult.getString("dui");
                    strUsuario = CResult.getString("usuario");
                    strContrasenia = CResult.getString("contrasenia");
                    
                    CTemp = new EmpleadoObj(iId, strName, strApellido, strFechaNac, strSexo, strEmail, strDUI, strUsuario, strContrasenia);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(EmpleadoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateEmpleadoRows(int p_iId, String p_strName,  String p_strApellido, String p_strFechaNac, String p_strSexo, String p_strEmail, String p_strDUI, String p_strUsuario, String p_strContrasenia) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.empleado "
                + "set nombre = '"+p_strName+"',apellido = '"+p_strApellido+"',fechaNac = '"+p_strFechaNac+"',sexo = '"+p_strSexo+"',email = '"+p_strEmail+"',dui = '"+p_strDUI+"',usuario = '"+p_strUsuario+"',contrasenia = '"+p_strContrasenia+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

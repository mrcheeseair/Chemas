package chem.ristorante.logic;

import chem.ristorante.database.DatabaseX;
import chem.ristorante.objects.OrdenObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdenLogic extends Logic
{
    //metodo1
    public boolean insertOrdenBool(int p_iPagoId, int p_iEmpleadoId, String p_strFecha, int p_iMesaId)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.orden(id,pago_id,empleado_id,fecha,mesa_id) "
                + "VALUES(0,"+p_iPagoId+","+p_iEmpleadoId+",'"+p_strFecha+"',"+p_iMesaId+");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertOrdenRows(int p_iPagoId, int p_iEmpleadoId, String p_strFecha, int p_iMesaId)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.orden(id,pago_id,empleado_id,fecha,mesa_id) "
                + "VALUES(0,"+p_iPagoId+","+p_iEmpleadoId+",'"+p_strFecha+"',"+p_iMesaId+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<OrdenObj> getAllOrdenes() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.orden ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<OrdenObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iPagoId;
            int iEmpleadoId;
            String strFecha;
            int iMesaId;
            
            OrdenObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iPagoId = CResult.getInt("pago_id");
                    iEmpleadoId = CResult.getInt("empleado_id");
                    strFecha = CResult.getString("fecha");
                    iMesaId = CResult.getInt("mesa_id");
                    
                    CTemp = new OrdenObj(iId, iPagoId, iEmpleadoId, strFecha, iMesaId);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OrdenLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deleteOrdenRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "orden");
        return iRows;
    }

    public OrdenObj getOrdenById(int p_iId) 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "SELECT * FROM chemas.orden where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        OrdenObj CTemp = null;
        
        if(CResult!=null)
        {
           int iId;
            int iPagoId;
            int iEmpleadoId;
            String strFecha;
            int iMesaId;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iPagoId = CResult.getInt("pago_id");
                    iEmpleadoId = CResult.getInt("empleado_id");
                    strFecha = CResult.getString("fecha");
                    iMesaId = CResult.getInt("mesa_id");
                    
                    CTemp = new OrdenObj(iId, iPagoId, iEmpleadoId, strFecha, iMesaId);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(OrdenLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateOrdenRows(int p_iId, int p_iPagoId, int p_iEmpleadoId, String p_strFecha, int p_iMesaId) 
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.orden "
                + "set pago_id = "+p_iPagoId+",empleado_id = "+p_iEmpleadoId+",fecha = '"+p_strFecha+"',mesa_id = "+p_iMesaId+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    
    
}

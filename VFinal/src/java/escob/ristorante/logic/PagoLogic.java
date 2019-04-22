package escob.ristorante.logic;

import escob.ristorante.database.DatabaseX;
import escob.ristorante.objects.PagoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagoLogic extends Logic
{
    //metodo1
    public boolean insertPagoBool(String p_strTipo, int p_iClienteId, int p_iNumero)
    {
        //INSERT INTO chemas.pago(id,cliente_id,tipo,numero) VALUES(0,1,´Credit´,1234);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.pago(id,cliente_id,tipo,numero) "
                + "VALUES(0,"+p_iClienteId+",'"+p_strTipo+"',"+p_iNumero+");";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertPagoRows(String p_strTipo, int p_iClienteId, int p_iNumero)
    {
        //INSERT INTO chemas.pago(id,cliente_id,tipo,numero) VALUES(0,2,'Debit',1233);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO chemas.pago(id, cliente_id, tipo, numero) "
                + "VALUES(0,"+p_iClienteId+",'"+p_strTipo+"',"+p_iNumero+");";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    //metodo3
    public ArrayList<PagoObj> getAllPagos() 
    {
        //select * from chemas.pago;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.pago ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<PagoObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iClienteId;
            String strTipo;
            int iNumero;
            
            PagoObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iClienteId = CResult.getInt("cliente_id");
                    strTipo = CResult.getString("tipo");
                    iNumero = CResult.getInt("numero");
                    
                    CTemp = new PagoObj(iId, iClienteId, strTipo, iNumero);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PagoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }

    public int deletePagoRows(int p_iId) 
    {
        int iRows = deleteTableRows(p_iId, "pago");
        return iRows;
    }

    public PagoObj getPagoById(int p_iId) 
    {
        //select * from chemas.pago;
        DatabaseX database = getDatabase();
        String strSql = "select * from chemas.pago where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        PagoObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            int iClienteId;
            String strTipo;
            int iNumero;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iClienteId = CResult.getInt("cliente_id");
                    strTipo = CResult.getString("tipo");
                    iNumero = CResult.getInt("numero");
                    
                    CTemp = new PagoObj(iId, iClienteId, strTipo, iNumero);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PagoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updatePagoRows(int p_iId, String p_strTipo, int p_iClienteId, int p_iNumero) 
    {
        //update chemas.pagos set cliente_id = 01, tipo = 'Credit', numero = 123 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update chemas.pago "
                + "set cliente_id = "+p_iClienteId+",tipo = '"+p_strTipo+"',numero = "+p_iNumero+" "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

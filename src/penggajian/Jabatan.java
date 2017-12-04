/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daksa
 */
public class Jabatan extends Koneksi
{
    private String vkd;
    private String vket;
    private double vgp;
    private double vtjabatan;
    private double vtransport;
    private double vtmakan;
    
    public Jabatan() throws SQLException
    {
        vkd         = "";
        vket        = "";
        vgp         = 0;
        vtjabatan   = 0;
        vtransport  = 0;
        vtmakan     = 0;
        koneksi();
    }
    
    public void setKd(String kode)
    {
        vkd = kode;
        
    }
    
    public String getKd()
    {
        return vkd;
    }
    
    public void setKet(String ket)
    {
        vket = ket;
        
    }
    
    public String getKet()
    {
        return vket;
    }
    
    public void setGp(double gapok)
    {
        vgp = gapok;
        
    }
    
    public double getGp()
    {
        return vgp;
    }
    
    public void setJb(double tjabatan)
    {
        vtjabatan = tjabatan;
        
    }
    
    public double getJb()
    {
        return vtjabatan;
    }
    
    public void setTransport(double transport)
    {
        vtransport = transport;
        
    }
    
    public double getTransport()
    {
        return vtransport;
    }
    
    public void setMakan(double tmakan)
    {
        vtmakan = tmakan;
        
    }
    
    public double getMakan()
    {
        return vtmakan;
    }
    
    public ResultSet ViewById()
    {
        ResultSet rs;
        String sql;
        sql = "select * from jabatan where kodejabatan = '" + vkd + "' ";
        try
        {
          rs = QuerySql(sql);
        } catch(SQLException ex)
        {
            rs = null;
            Logger.getLogger(Jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ViewByAll() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select * from jabatan ";
        rs = QuerySql(sql);
        return rs;
    }
    
    public boolean Insert() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "insert into jabatan(kodejabatan, keterangan, gapok, tjabatan, transport, tmakan)";
        sql +=" values('" + vkd +"','" + vket + "','" + vgp + "','" + vtjabatan + "','" + vtransport + "', " + vtmakan + ")";
        h = Executesql(sql);
        return h;
    }
    
    public boolean Update() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "update jabatan set keterangan = '" + vket + "', gapok ='" + vgp + "', tjabatan = '"
                + vtjabatan + "', transport = '"+ vtransport +  "', tmakan ='" + vtmakan + "'";
        sql += " where kodejabatan = '" + vkd + "' ";
        h = Executesql(sql);
        
        return h;
        
    }
    
    public boolean Delete () throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "delete from jabatan ";
        sql += " where kodejabatan = '" + vkd + "' ";
        h = Executesql(sql);
        return h;
    }

}

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
public class Karyawan extends Koneksi
{
    private String vnip;
    private String vnama;
    private int vjkel;
    private String vtmplahir;
    private String vtgl;
    private String vkd;
    
    public Karyawan() throws SQLException
    {
        vnip        = "";
        vnama       = "";
        vjkel       = 1;
        vtmplahir   = "";
        vtgl        = "";
        vkd         = "";
        koneksi();
    }
    
    public void setNip(String nip)
    {
        vnip = nip;
        
    }
    
    public String getNip()
    {
        return vnip;
    }
    
    public void setNama(String nama)
    {
        vnama = nama;
        
    }
    
    public String getNama()
    {
        return vnama;
    }
    
    public void setSt(int st)
    {
        vjkel = st;
        
    }
    
    public int getSt()
    {
        return vjkel;
    }
    
    public void setTmp(String tmp)
    {
        vtmplahir = tmp;
        
    }
    
    public String getTmp()
    {
        return vtmplahir;
    }
    
    public void setTgl(String tgl)
    {
        vtgl = tgl;
        
    }
    
    public String getTgl()
    {
        return vtgl;
    }
    
    public void setKd(String kd)
    {
        vkd = kd;
        
    }
    
    public String getKd()
    {
        return vkd;
    }
    
    public ResultSet ViewByKode()
    {
        ResultSet rs;
        String sql;
        sql = "select * from karyawan where nip = '" + vnip + "' ";
        try
        {
          rs = QuerySql(sql);
        } catch(SQLException ex)
        {
            rs = null;
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet ViewByNama() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select * from karyawan where nama like '" + vnama + "%' ";
        rs = QuerySql(sql);
        return rs;
    }
    
    public ResultSet ViewByAll() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select * from karyawan ";
        rs = QuerySql(sql);
        return rs;
    }
    
    public ResultSet ViewKd() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select kodejabatan,keterangan from jabatan ";
        rs = QuerySql(sql);
        return rs;
    }
    
    public boolean Insert() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "insert into karyawan(nip, nama, jekel, tmplahir, tgl_lahir, kodejabatan)";
        sql +=" values('" + vnip +"','" + vnama + "','" + vjkel + "','" + vtmplahir + "','" + vtgl + "','" + vkd +"')";
        h = Executesql(sql);
        return h;
    }
    
    public boolean Update() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "update karyawan set nama = '" + vnama + "', jekel ='" + vjkel + "', tmplahir = '"
                + vtmplahir + "', tgl_lahir = '"+ vtgl +  "', kodejabatan ='" + vkd + "'";
        sql += " where nip = '" + vnip + "' ";
        h = Executesql(sql);
        return h;
    }
    
    public boolean Delete () throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "delete from karyawan ";
        sql += " where nip = '" + vnip + "' ";
        h = Executesql(sql);
        return h;
    }
}

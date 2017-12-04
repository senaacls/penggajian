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
public class Penggajian extends Koneksi
{
    
    private String vno;
    private String vtgl;
    private String vbln;
    private String vthn;
    private String vnip;
    private int vjml;
    private double vpph;
    private double vpj;
    private double vpjk;
    
    public Penggajian() throws SQLException
    {
        vno        = "";
        vtgl       = "";
        vbln       = "";
        vthn       = "";
        vnip       = "";
        vjml       = 0;
        vpph       = 0;
        vpj        = 0;
        vpjk       = 0;
        koneksi();
    }
    
    public void setNo(String no)
    {
        vno = no;
        
    }
    
    public String getNo()
    {
        return vno;
    }
    
    public void setTgl(String tgl)
    {
        vtgl = tgl;
        
    }
    
    public String getTgl()
    {
        return vtgl;
    }
    
    public void setBln(String bln)
    {
        vbln = bln;
        
    }
    
    public String getBln()
    {
        return vbln;
    }
    
    public void setThn(String thn)
    {
        vthn = thn;
        
    }
    
    public String getThn()
    {
        return vthn;
    }
    
    public void setNip(String nip)
    {
        vnip = nip;
        
    }
    
    public String getNip()
    {
        return vnip;
    }
    
    public void setJml(int jml)
    {
        vjml = jml;
        
    }
    
    public int getJml()
    {
        return vjml;
    }
    
    public void setPph(double pph)
    {
        vpph = pph;
        
    }
    
    public double getPph()
    {
        return vpph;
    }
    
    public void setPj(double pj)
    {
        vpj = pj;
        
    }
    
    public double getPj()
    {
        return vpj;
    }
    
    public void setPjk(double pjk)
    {
        vpjk = pjk;
        
    }
    
    public double getPjk()
    {
        return vpjk;
    }
    
    public ResultSet ViewById()
    {
        ResultSet rs;
        String sql;
        sql = "select * from gajian where notransaksi = '" + vno + "' ";
        try
        {
          rs = QuerySql(sql);
        } catch(SQLException ex)
        {
            rs = null;
            Logger.getLogger(Penggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
 
    public ResultSet ViewByAll() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select * from gajian ";
        rs = QuerySql(sql);
        return rs;
    }
    
    public ResultSet ViewNip() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "select nip from karyawan order by nip asc";
        rs = QuerySql(sql);
        return rs;
    }
    
    public ResultSet GetByNip() throws SQLException
    {
        ResultSet rs;
        String sql;
        sql = "SELECT karyawan.nama, jabatan.kodejabatan, jabatan.keterangan, jabatan.gapok, "
                + "jabatan.tjabatan, jabatan.tmakan, jabatan.transport "
                + "FROM jabatan INNER JOIN karyawan "
                + "ON jabatan.kodejabatan = karyawan.kodejabatan  WHERE karyawan.nip = '" + vnip + "' ";
        rs = QuerySql(sql);
        return rs;
    }
    
    
    
    public boolean Insert() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "insert into gajian(notransaksi, tanggal, periodebulan, periodetahun, nip, jmljamkerja, potongan_pph, potongan_pinjaman, potongan_jamkerja)";
        sql +=" values('" + vno +"','" + vtgl + "','" + vbln + "','" + vthn + "','" + vnip + "','" + 0 +"','" + vpph +"','" + vpj +"','" + vpjk +"')";
        h = Executesql(sql);
        return h;
    }
    
    public boolean Update() throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "update gajian set tanggal = '" + vtgl + "', periodebulan ='" + vbln + "', periodetahun = '"
                + vthn + "', nip = '"+ vnip +  "', jmljamkerja ='" + vjml + "', potongan_pph ='" + vpph + "' , potongan_pinjaman ='" + vpj + ""
                + "', potongan_jamkerja ='" + vpjk + "' ";
        sql += " where notransaksi = '" + vno + "'";
        h = Executesql(sql);
        return h;
    }
    
    
    public boolean Delete () throws SQLException
    {
        boolean h = false;
        String sql;
        sql = "delete from gajian ";
        sql += " where notransaksi = '" + vno + "' ";
        h = Executesql(sql);
        return h;
    }
}

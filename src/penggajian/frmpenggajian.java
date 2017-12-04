/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author daksa
 */
public class frmpenggajian extends javax.swing.JFrame {
    private boolean databaru;
    private Penggajian cl;
    
    

    /**
     * Creates new form frmpenggajian
     */
    public frmpenggajian() throws SQLException {
        initComponents();
        databaru = true;
        cl = new Penggajian();
        GetData();
        date();
        getnip();
    }
    
    private void GetData()  throws SQLException
    {
        Object[] kolom = {"No", "Tanggal", "Bulan", "Tahun", "Nip", "JmlJamKerja", "pph", "p_pinjaman", "p_jamkerja"};
        DefaultTableModel tabmode = new DefaultTableModel(null, kolom);
        ResultSet rs = cl.ViewByAll();
        while(rs.next())
        {
            String data[]={rs.getString("notransaksi"),rs.getString("tanggal"),rs.getString("periodebulan"),rs.getString("periodetahun"), 
                rs.getString("nip"), rs.getString("jmljamkerja"), rs.getString("potongan_pph"), rs.getString("potongan_pinjaman"), rs.getString("potongan_jamkerja")};
            tabmode.addRow(data);
        }
        jTable1.setModel(tabmode);
    }
    
    private void date()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.txtgl.setText(dateFormat.format(date.getTime()));
        this.txtgl.setEditable(false);
    }
    
    private void getnip() throws SQLException
    {
        ResultSet rs = cl.ViewNip();
        while(rs.next())
        {
           String nip    = rs.getString("nip");
           this.cmbnip.addItem(nip);
        }
        
        rs.close();
    }
    
    private void getbynip() throws SQLException
    {
        double totalgaji = 0;
        double pph       = 0;
        double p_pinjam  = 0;
        double pjk       = 0;
        double tp        = 0;
        double gb        = 0;
        cl.setNip(this.cmbnip.getSelectedItem().toString());
        p_pinjam = parseDouble(this.txpp.getText());
        ResultSet rs = cl.GetByNip();
        while (rs.next()) {
           String nama    = rs.getString("nama");
           String kode    = rs.getString("kodejabatan");
           String ket     = rs.getString("keterangan");
           String gp      = rs.getString("gapok");
           String tj      = rs.getString("tjabatan");
           String tm      = rs.getString("tmakan");
           String ts      = rs.getString("transport");
           
           totalgaji = Double.valueOf(gp) + Double.valueOf(tj) + Double.valueOf(tm) + Double.valueOf(ts);
           pph       = (0.2 * Double.valueOf(gp));
           pjk       = 0.1 * (parseDouble(ts) + parseDouble(tm));
           tp        = pph + pjk + p_pinjam ;
           gb        = totalgaji - tp;
           
           this.txtnama.setText(nama);
           this.txtkd.setText(kode);
           this.txtjb.setText(ket);
           this.txtgp.setText(gp);
           this.txjabatan.setText(tj);
           this.txtmakan.setText(tm);
           this.txtranpsort.setText(ts);
           this.txtotalgaji.setText(String.format("%.2f", totalgaji));
           this.txtpph.setText(String.format("%.2f", pph));
           this.txtpjk.setText(String.format("%.2f", pjk));
           this.txpotongan.setText(String.format("%.2f", tp));
           this.txtgb.setText(String.format("%.2f", gb));
            //txtharga.setText(formatter.format(harga));
        }
        
        rs.close();
    }
    
    private double parseDouble(String s)
    {
        if(s == null || s.isEmpty()) 
            return 0.0;
        else
            return Double.parseDouble(s);
    }
    
    private void hp()
    {
        double pph, p_pinjam, pjk, tp, tg, gb;
        pph      = parseDouble(this.txtpph.getText());
        p_pinjam = parseDouble(this.txpp.getText());
        pjk      = parseDouble(this.txtpjk.getText());
        tg       = Double.valueOf(this.txtotalgaji.getText());
        
        tp       = pph + p_pinjam + pjk;
        gb       = tg  - tp;
        this.txpotongan.setText(String.format("%.2f", tp));
        this.txtgb.setText(String.format("%.2f", gb));
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtgl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbnip = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtkd = new javax.swing.JTextField();
        txtjb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtgp = new javax.swing.JTextField();
        txjabatan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtmakan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtranpsort = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtotalgaji = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtpph = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txpp = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txpotongan = new javax.swing.JTextField();
        txtgb = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnselesai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtpjk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Form Gaji");
        jLabel7.setToolTipText("");
        jLabel7.setOpaque(true);

        jLabel1.setText("No Transaksi");

        jLabel2.setText("Tanggal");

        jLabel3.setText("Nip");

        cmbnip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnipActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama");

        jLabel5.setText("Kode Jabatan");

        jLabel6.setText("Jabatan");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("A. Komponen Gaji");
        jLabel8.setToolTipText("");
        jLabel8.setOpaque(true);

        jLabel9.setText("Gaji Pokok");

        jLabel10.setText("Tunjangan Jabatan");

        jLabel11.setText("Tunjangan Makan");

        jLabel12.setText("Tunjangan Transport");

        jLabel13.setText("Total Gaji");

        jLabel17.setText("pph");

        jLabel14.setText("Potongan Pinjam");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("B. Komponen Potongan");
        jLabel15.setToolTipText("");
        jLabel15.setOpaque(true);

        jLabel16.setText("Total Potongan");

        txpp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txppKeyReleased(evt);
            }
        });

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnselesai.setText("Selesai");
        btnselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselesaiActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel19.setText("Gaji Bersih");

        jLabel18.setText("Potongan Jam Kerja");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtno)
                                    .addComponent(txtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbnip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtjb, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtkd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel19))
                                                    .addGap(28, 28, 28)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtgp)
                                                            .addComponent(txjabatan)
                                                            .addComponent(txtmakan)
                                                            .addComponent(txtranpsort)
                                                            .addComponent(txtpph)
                                                            .addComponent(txpp)
                                                            .addComponent(txpotongan)
                                                            .addComponent(txtgb, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                                        .addComponent(txtotalgaji, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(btntambah)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnsimpan)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btnbatal)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnhapus)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btnselesai)))
                                            .addComponent(jLabel17))
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtpjk, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtjb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtgp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtmakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtranpsort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtotalgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtpph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtpjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txpotongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtgb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnsimpan)
                    .addComponent(btnbatal)
                    .addComponent(btnhapus)
                    .addComponent(btnselesai))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselesaiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnselesaiActionPerformed

    private void cmbnipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnipActionPerformed
        try {
            // TODO add your handling code here:
            getbynip();
        } catch (SQLException ex) {
            Logger.getLogger(frmpenggajian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbnipActionPerformed

    private void txppKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txppKeyReleased
        // TODO add your handling code here:
        hp();
    }//GEN-LAST:event_txppKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        databaru = false;
        int row = jTable1.getSelectedRow();
        String tabel_klik =(jTable1.getModel().getValueAt(row, 0).toString());
        cl.setNo(tabel_klik);
        try
        {           
                ResultSet rs = cl.ViewById();
                if(rs.next())
                {
                    cl.setNo(rs.getString("notransaksi"));
                    cl.setTgl(rs.getString("tanggal"));
                    cl.setNip(rs.getString("nip"));
                    cl.setPph(Double.valueOf(rs.getString("potongan_pph")));
                    cl.setPj(Double.valueOf(rs.getString("potongan_pinjaman")));
                    cl.setPjk(Double.valueOf(rs.getString("potongan_jamkerja")));
                    
                    this.txtno.setText(cl.getNo());
                    this.txtgl.setText(cl.getTgl());;
                    this.cmbnip.setSelectedItem(cl.getNip());
                    this.txtpph.setText(String.format("%.2f", cl.getPph()));
                    this.txpp.setText(String.format("%.2f", cl.getPj()));
                    this.txtpjk.setText(String.format("%.2f",cl.getPjk()));
                    
                    hp();
                    this.txtno.setEditable(false);
                }
        }catch(SQLException ex)
                {
                    Logger.getLogger(frmpenggajian.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        if("".equals(this.txtno.getText()))
        {
            JOptionPane.showMessageDialog(null, "Silahkan klik pada grid untuk pilih data");
        }
        else
        {
            boolean h = false;
            try
            {
                cl.setNo(this.txtno.getText());
                h = cl.Delete();
                JOptionPane.showMessageDialog(null, "Penghapusan data berhasil");
                GetData();
                this.txtno.grabFocus();
            } catch(SQLException ex)
            {
                Logger.getLogger(frmpenggajian.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
            Date date= new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);

            cl.setNo(this.txtno.getText());
            cl.setTgl(this.txtgl.getText());
            cl.setBln(Integer.toString(month));
            cl.setThn(Integer.toString(year));
            cl.setNip(this.cmbnip.getSelectedItem().toString());
            cl.setPph(Double.valueOf(txtpph.getText()));
            cl.setPj(Double.valueOf(txpp.getText()));
            cl.setPjk(Double.valueOf(txtpjk.getText()));
            
            boolean h = false;
            try
            {
                if(databaru == true)
                {
                    h = cl.Insert();
                }
                else
                {
                    h = cl.Update();
                }
                JOptionPane.showMessageDialog(null,"Penyimpanan berhasil");
                this.GetData();
                
                
            } catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Penyimpanan gagal" + ex.getMessage());
            }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        databaru = true;
        this.txtno.setEditable(true);
        this.txtno.setText("");
        this.txtnama.setText("");
        this.txtkd.setText("");
        this.txtjb.setText("");
        this.txtgp.setText("");
        this.txjabatan.setText("");
        this.txtmakan.setText("");
        this.txtranpsort.setText("");
        this.txtotalgaji.setText("");
        this.txtpph.setText("");
        this.txpp.setText("");
        this.txtpjk.setText("");
        this.txpotongan.setText("");
        this.txtgb.setText("");
        this.txtno.grabFocus();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        this.txtno.setText("");
        this.txtnama.setText("");
        this.txtkd.setText("");
        this.txtjb.setText("");
        this.txtgp.setText("");
        this.txjabatan.setText("");
        this.txtmakan.setText("");
        this.txtranpsort.setText("");
        this.txtotalgaji.setText("");
        this.txtpph.setText("");
        this.txpp.setText("");
        this.txtpjk.setText("");
        this.txpotongan.setText("");
        this.txtgb.setText("");
        this.txtno.grabFocus();
    }//GEN-LAST:event_btnbatalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmpenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpenggajian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmpenggajian().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmpenggajian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnselesai;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbnip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txjabatan;
    private javax.swing.JTextField txpotongan;
    private javax.swing.JTextField txpp;
    private javax.swing.JTextField txtgb;
    private javax.swing.JTextField txtgl;
    private javax.swing.JTextField txtgp;
    private javax.swing.JTextField txtjb;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtmakan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtotalgaji;
    private javax.swing.JTextField txtpjk;
    private javax.swing.JTextField txtpph;
    private javax.swing.JTextField txtranpsort;
    // End of variables declaration//GEN-END:variables
}

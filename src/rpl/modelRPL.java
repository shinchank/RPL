/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author R16
 */
public class modelRPL {

    private ArrayList<Penghuni> aryPenghuni;
    private String query;
    private ResultSet rs;
    private Database db;
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public modelRPL() {
        
        this.aryPenghuni = new ArrayList<>();
        db = new Database();
        try {
            db.connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Penghuni cariPenghuni(String nama) {
      query = "SELECT * FROM penghuni";
        try {
            rs=db.getData(query);
            while (rs.next()) {               
                int idPg = Integer.parseInt(rs.getString("idpenghuni"));
                String nmPg = rs.getString("namapenghuni");
                String nokm = rs.getString("nokamar");
                Kamar k = new Kamar();
                k.setNoKamar(nokm);
                String asal = rs.getString("asalpenghuni");
                String nohp = rs.getString("nohp");
                Date date = formatter.parse(rs.getString("tanggalmasuk"));
                Penghuni p = new Penghuni(nmPg, idPg, k, nohp, date);
                aryPenghuni.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelRPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        Penghuni ps = null;
        for (Penghuni px : aryPenghuni) {
            if (px.getNama().equals(nama)) {
                ps = px;
            }
        }
        aryPenghuni.clear();
        return ps;
    }

    public void addPenghuni(Penghuni p) {
        queryadd(p);
    }

    public void hapusPenghuni(Penghuni p) {
        queryhps(p);
    }

    public String crikamar(String noKamar) {
        String hasil = null;
        query = "SELECT nokamar FROM kamar where nokamar=" + noKamar;
        try {
            db.execute(query);
            while (rs.next()) {
                hasil = rs.getString("noKamar");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasil;
    }

    public void queryadd(Penghuni p) {
        query = "INSERT INTO penghuni( namaPenghuni, noKamar, asalPenghuni, noHp, tanggalMasuk) VALUES ('"
                + p.getNama() + "','"
                + p.getNoKam().getNoKamar() + "','"
                + p.getAsal() + "','"
                + p.getNoHP() + "','"
                + new java.sql.Date(p.getTgl().getTime())+"')";
        String query2 = "UPDATE kamar SET namaPenghuni='" + p.getNama() + "'WHERE noKamar='" + p.getNoKam().getNoKamar()+"'";
        db.execute(query);
        db.execute(query2);

    }

    public void queryhps(Penghuni p) {
        query = "DELETE FROM penghuni WHERE namaPenghuni='" + p.getNama()+"'";
        String query2 = "UPDATE kamar SET namaPenghuni=''WHERE noKamar='" + p.getNoKam().getNoKamar()+"'";
        db.execute(query);
    }

    public String[] queryviewhapus() {
        query = "SELECT namaPenghuni FROM penghuni";
        String hasil[];
        ArrayList<String> aryz = new ArrayList();
        
        try {
            rs=db.getData(query);
            while (rs.next()) {
                String nmPg = rs.getString("namapenghuni");
                aryz.add(nmPg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hasil = new String[aryz.size()];
        int i = 0;
        for (String s : aryz) {
            hasil[i] = s;
            i++;
        }
        aryz.clear();
        return hasil;
       
    }

    public String[][] queryview() {
        query = "SELECT * FROM penghuni";
        try {
            rs=db.getData(query);
            while (rs.next()) {               
                int idPg = Integer.parseInt(rs.getString("idpenghuni"));
                String nmPg = rs.getString("namapenghuni");
                String nokm = rs.getString("nokamar");
                Kamar k = new Kamar();
                k.setNoKamar(nokm);
                String asal = rs.getString("asalpenghuni");
                String nohp = rs.getNString("nohp");
                Date date = formatter.parse(rs.getString("tanggalmasuk"));
                Penghuni p = new Penghuni(nmPg, idPg, k, nohp, date);
                aryPenghuni.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modelRPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Data[][] = new String[aryPenghuni.size()][6];
        int i = 0;
        for (Penghuni p : aryPenghuni) {
            Data[i][0] = "" + p.getIdPenghuni();
            Data[i][1] = p.getNama();
            Data[i][2] = p.getAsal();
            Data[i][3] = p.getNoHP();
            Data[i][4] = p.getNoKam().getNoKamar();
            Data[i][5] = formatter.format(p.getTgl());
            i++;
        }
        return Data;

    }
}

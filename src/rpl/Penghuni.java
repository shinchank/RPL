/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpl;

import java.util.Date;

/**
 *
 * @author R16
 */
public class Penghuni {

    private String nama;
    private int idPenghuni;
    private Kamar k;
    private String noHP;
    private String Asal;
    private Date tgl;

    public String getNama() {
        return nama;
    }

    public Kamar getNoKam() {
        return k;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getAsal() {
        return Asal;
    }

    public int getIdPenghuni() {
        return idPenghuni;
    }

    public Date getTgl() {
        return tgl;
    }
    public Penghuni(){}
    public Penghuni(String nama, Kamar k, String noHP, String Asal) {
        this.nama = nama;
        this.k=k;
        this.noHP = noHP;
        this.Asal = Asal;
        this.tgl= new Date();
    }

    public Penghuni(String nama, int idkamar, Kamar k, String noHP, Date tgl) {
        this.nama = nama;
        this.idPenghuni = idkamar;
        this.k = k;
        this.noHP = noHP;
        this.Asal = Asal;
        this.tgl= tgl;
    }
    
}

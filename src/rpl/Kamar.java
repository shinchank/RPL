/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpl;

/**
 *
 * @author R16
 */
public class Kamar {
    private String noKamar;
    private Penghuni p;
    private String jKamar;
    private String desc;
    public Kamar(){}

    public void setNoKamar(String noKamar) {
        this.noKamar = noKamar;
    }
    public Kamar(String noKamar, Penghuni p, String jKamar, String desc) {
        this.noKamar = noKamar;
        this.p = p;
        this.jKamar = jKamar;
        this.desc = desc;
    }

    public Kamar(String noKamar) {
        this.noKamar = noKamar;
    }

    public String getNoKamar() {
        return noKamar;
    }

    public Penghuni getP() {
        return p;
    }

    public String getjKamar() {
        return jKamar;
    }

    public String getDesc() {
        return desc;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2_ktr3;

/**
 *
 * @author Admin
 */
public class ThuVien implements Comparable<ThuVien>{
    private String ma,tennhaXB;
    private int soban;

    public ThuVien() {
    }

    public ThuVien(String ma, String tennhaXB, int soban) {
        this.ma = ma;
        this.tennhaXB = tennhaXB;
        this.soban = soban;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTennhaXB() {
        return tennhaXB;
    }

    public void setTennhaXB(String tennhaXB) {
        this.tennhaXB = tennhaXB;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }



    @Override
    public int compareTo(ThuVien o) {
        return ma.compareToIgnoreCase(o.ma);
    }
  
    
}

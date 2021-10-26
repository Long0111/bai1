/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2_ktr3;

import java.util.Calendar;
/**
 *
 * @author Admin
 */
public class Sach extends ThuVien{
    private String tenTG,tenSach;
    private int sotrang;

    public Sach() {
    }

    public Sach(String ma, String tennhaXB, int soban, String tenTG, String tenSach, int sotrang) {
        super(ma, tennhaXB, soban);
        this.tenTG = tenTG;
        this.tenSach = tenSach;
        this.sotrang = sotrang;
    }



    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

        public String toString(){
        return super.getMa()+"\t"+super.getTennhaXB()+"\t"+super.getSoban()+"\t"+tenTG+"\t\t"+tenSach+"\t"+sotrang;
    }

    
}

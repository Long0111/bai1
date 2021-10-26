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
public class Bao extends ThuVien{
    private int ngayPH;

    public Bao() {
    }

    public Bao(String ma, String tennhaXB, int soban, int ngayPH) {
        super(ma, tennhaXB, soban);
        this.ngayPH = ngayPH;
    }



    public int getNgayPH() {
        return ngayPH;
    }

    public void setNgayPH(int ngayPH) {
        this.ngayPH = ngayPH;
    }
    
    public String toString(){
        return super.getMa()+"\t"+super.getTennhaXB()+"\t"+super.getSoban()+"\t"+ngayPH;
    }
}

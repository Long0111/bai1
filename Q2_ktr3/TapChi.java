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
public class TapChi extends ThuVien{
    private int soPH,thangPH;

    public TapChi() {
    }

    public TapChi(String ma, String tennhaXB, int soban, int soPH, int thangPH) {
        super(ma, tennhaXB, soban);
        this.soPH = soPH;
        this.thangPH = thangPH;
    }



    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }

    public int getThangPH() {
        return thangPH;
    }

    public void setThangPH(int thangPH) {
        this.thangPH = thangPH;
    }
    
    public String toString(){
        return super.getMa()+"\t"+super.getTennhaXB()+"\t"+super.getSoban()+"\t"+soPH+"\t"+thangPH;
    }
    
}

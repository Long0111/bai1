/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2_ktr1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class QLGT implements ChucNang{
    private List<PTGT> list;
    private Scanner in=new Scanner(System.in);
    
    public QLGT() {
        list=new ArrayList<>();
        list.add(new Oto("HN876","yaris",2021, 800000,"do","cho nu",4));
        list.add(new XeMay("HN876","honda",2015, 60000, "den",150));
        list.add(new XeMay("HY089","yamaha",2021, 140000,"do",450));
        list.add(new Oto("HN111","yaris",2000, 1200000,"den","cho nam",7));
        list.add(new Oto("NB498","yaris",2012, 900000,"den","cho nu",16));
        list.add(new Oto("HN666","yaris",1999, 500000,"do","cho nam",4));
    }
    //khong trung ma
    private int tontai(String ma){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMa().equalsIgnoreCase(ma))
                return i;
        }
        return -1;// k thay
            
    }
    //nhap lop cha
    private PTGT nhap(){
        String ma, hang;
        int nam;
        double gia;
        String mau;
        String reg="^HN\\d{3}";
        while(true){
            System.out.println("nhap ma: ");
            ma=in.nextLine().toUpperCase();
            if(tontai(ma)==-1 && ma.matches(reg))
                break;
            System.err.println("nhap lai!!");
        }
        System.out.println("nhap hang:");
        hang=in.nextLine();
        System.out.println("nhap nam:");
        nam=Integer.parseInt(in.nextLine());
        System.out.println("nhap gia:");
        gia=Double.parseDouble(in.nextLine());
        System.out.println("nhap mau:");
        mau=in.nextLine();
        return new PTGT(ma, hang, nam, gia, mau);
    }
    

    public void nhapOto() {
        PTGT p=nhap();
        System.out.println("nhap kieu:");
        String k=in.nextLine();
        System.out.println("nhap so cho:");
        int sc=Integer.parseInt(in.nextLine());
        list.add(new Oto(p.getMa(),p.getHang(),p.getNam(),p.getGia(),p.getMau(),k,sc));
    }

    @Override
    public void nhapXeMay() {
        PTGT p=nhap();
        System.out.println("nhap cong suat:");
        Double cs=Double.parseDouble(in.nextLine());
        list.add(new XeMay(p.getMa(),p.getHang(),p.getNam(),p.getGia(),p.getMau(),cs));
    }

    public void vietDS() {
        System.out.println("Danh sach Oto");
        for(PTGT i:list)
            if(i instanceof Oto)
                System.out.println(i);
        System.out.println("Danh sach XeMay");
        for(PTGT i:list)
            if(i instanceof XeMay)
                System.out.println(i);
        System.out.println("-----------------------");
    }

 
    public void xoa() {
        System.out.println("Nhap ma can xoa: ");
        String ma=in.nextLine();
        int vitri=tontai(ma);
        if(vitri==-1)
               System.out.println("Co dau ma xoa");
        else{
            list.remove(vitri);
            System.out.println("da xoa thanh cong!!!");
        }
    }

 
    public void sua() {
        System.out.println("nhap ma can sua:");
        String ma=in.nextLine();
        int vitri=tontai(ma);
        if(vitri==-1)
            System.out.println("co dau ma sua");
        else{
            PTGT p=list.get(vitri);
            System.out.println("nhap hang:");
            String hang=in.nextLine();
            System.out.println("nhap nam:");
            int nam=Integer.parseInt(in.nextLine());
            System.out.println("nhap gia:");
            double gia=Double.parseDouble(in.nextLine());
            System.out.println("nhap mau:");
            String mau=in.nextLine();
            p.setHang(hang);
            p.setNam(nam);
            p.setGia(gia);
            p.setMau(mau);
            System.out.println("sua thanh cong!!!");
            
        }
    }

    public void suaXemay(){
        List<XeMay> l=new ArrayList<>();
        for(PTGT i:list)
            if(i instanceof XeMay)
                l.add((XeMay)i);
        System.out.println("nhap ma XM can sua:");
        String ma=in.nextLine();
        for(int i=0;i<l.size();i++){
            XeMay x=l.get(i);
            if(x.getMa().equalsIgnoreCase(ma)){
                System.out.println("nhap hang:");
                String hang=in.nextLine();
                System.out.println("nhap nam:");
                int nam=Integer.parseInt(in.nextLine());
                System.out.println("nhap gia:");
                double gia=Double.parseDouble(in.nextLine());
                System.out.println("nhap mau:");
                String mau=in.nextLine();
                System.out.println("nhap cong suat:");
                double cs=Double.parseDouble(in.nextLine());
                x.setHang(hang);
                x.setNam(nam);
                x.setGia(gia);
                x.setMau(mau);
                x.setCongsuat(cs);
                System.out.println("sua thanh cong!!!");
            }
        }
        System.out.println("khong tim thay de sua!!!");
    }
    
    public void timTheoHang() {
        System.out.println("nhap hang can tim:");
        String h=in.nextLine().toLowerCase();
        boolean co =false;
        for(PTGT i:list)
            if(i.getHang().toLowerCase().contains(h)){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay phuong tien nao");
    }

 
    public void timTheoMa() {
        System.out.println("nhap ma can tim:");
        String ma=in.nextLine();
        int vitri=tontai(ma);
        if(vitri==-1)
            System.out.println("khong tim thay!!!");
        else{
            System.out.println("Doi tuong la:");
            System.out.println(list.get(vitri));
        }
    }

    
    public void timTheoNam() {
        System.out.println("nhap tu nam can tim:");
        int n1=Integer.parseInt(in.nextLine());
        System.out.println("nhap den nam can tim:");
        int n2=Integer.parseInt(in.nextLine());
        boolean co =false;
        for(PTGT i:list)
            if(i.getNam() >= n1 && i.getNam() <=n2){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay phuong tien nao");
    }



    public void timTheoMau() {
        System.out.println("nhap mau can tim:");
        String m=in.nextLine();
        boolean co =false;
        for(PTGT i:list)
            if(i.getMau().equalsIgnoreCase(m)){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay phuong tien nao");
    }
    public void timTheoSoCho(){
        List<Oto> l=new ArrayList<>();
        for(PTGT i:list)
            if(i instanceof Oto)
                l.add((Oto)i);
        System.out.println("nhap so cho can tim:");
        int sc=Integer.parseInt(in.nextLine());
        boolean co =false;
        for(Oto i:l)
            if(i.getSocho()==sc){
                System.out.println(i);
                co = true;
            }
        if(!co)
            System.out.println("khong co!!!");
    }

    public void sapxepTheoMa() {
        Collections.sort(list);
        
    }

    public void sapxepCSgiamdan(){
        List<XeMay> l = new ArrayList<>();
        for (PTGT x : list) {
            if(x instanceof XeMay){
                l.add((XeMay)x);
            }
        }
        l.sort(new Comparator<XeMay>() {
            public int compare(XeMay o1, XeMay o2) {
                return Double.compare(o2.getCongsuat(), o1.getCongsuat());
            }
            
        });
        for (XeMay i : l) {
            System.out.println(i);
        }

    }
    
    public void sapxepTheoMauVaGia(){
        // mau giam - gia tang
        list.sort(new Comparator<PTGT>() {
            public int compare(PTGT o1, PTGT o2) {
                if(o1.getMau() == o2.getMau())
                    return Double.compare(o1.getGia(), o2.getGia());
                else   
                    return o1.getMau().compareToIgnoreCase(o2.getMau());
            }
        });
    }

    
    public void sapxepTheoHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sapxepTheoNam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sapxepTheoGiaGiamDan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sapxepTheoMau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sapxepOtoTheoGia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void thongke() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

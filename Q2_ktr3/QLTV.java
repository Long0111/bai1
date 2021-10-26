/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2_ktr3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class QLTV implements ChucNang{
    private List<ThuVien> list;
    private List<TapChi> list1;
    private List<Bao> list2;
    public Scanner in=new Scanner(System.in);
    
    public QLTV(){
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list.add(new Sach("HY123","Nhi dong",10000,"Vu Trong Phung","So do",3780));
        list.add(new Sach("HY343","Nhi dong",15000,"Vu Trong Phung","Giong to",5440));
        list.add(new Sach("HY256","Viet Nam",35000,"Nguyen Du","Truyen Kieu",12012));
        list.add(new TapChi("HY672","Nguoi mau",1300,16,10));
        list.add(new TapChi("HY689","Mua thu",800,17,10));
        list.add(new Bao("HY567","Tien phong",1000, 27));
        list.add(new Bao("HY555","Cong An",1000, 5));
        list1.add(new TapChi("HY672","Nguoi mau",1300,16,10));
        list1.add(new TapChi("HY689","Mua thu",800,17,10));
        list2.add(new Bao("HY567","Tien phong",1000, 27));
        list2.add(new Bao("HY555","Cong An",1000, 5));
    }
    //khong trung ma
    private int tontai(String ma){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getMa().equalsIgnoreCase(ma))
                return i;
        }
        return -1;// k thay
            
    }
    
    private ThuVien nhap(){
        String ma,tennhaXB;
        int soban;
        String reg="HY\\d{3}";
        while(true){
            System.out.println("nhap ma: ");
            ma=in.nextLine().toUpperCase();
            if(tontai(ma)==-1 && ma.matches(reg))
                break;
            System.err.println("nhap lai!!");
        }
        System.out.println("nhap ten nha XB ");
        tennhaXB=in.nextLine();
        System.out.println("nhap so ban ");
        soban=in.nextInt();
        String x=in.nextLine();
        return new ThuVien(ma, tennhaXB, soban);
    }
    
    public void nhapSach(){
        ThuVien p=nhap();
        System.out.println("nhap ten tac gia: ");
        String tg=in.nextLine();
        System.out.println("nhap ten sach: ");
        String t=in.nextLine();
        System.out.println("nhap so trang: ");
        int tr=Integer.parseInt(in.nextLine());
        list.add(new Sach(p.getMa(),p.getTennhaXB(),p.getSoban(),tg,t,tr));
    }
    
    public void nhapTapChi(){
        ThuVien p=nhap();
        System.out.println("nhap so phat hanh");
        int s=Integer.parseInt(in.nextLine());
        System.out.println("nhap thang phat hanh");
        int th=Integer.parseInt(in.nextLine());
        list.add(new TapChi(p.getMa(),p.getTennhaXB(),p.getSoban(),s,th));
        list1.add(new TapChi(p.getMa(),p.getTennhaXB(),p.getSoban(),s,th));
    }
    
    public void nhapBao(){
        ThuVien p=nhap();
        System.out.println("nhap ngay");
        int n=Integer.parseInt(in.nextLine());
        list.add(new Bao(p.getMa(),p.getTennhaXB(),p.getSoban(),n));
        list2.add(new Bao(p.getMa(),p.getTennhaXB(),p.getSoban(),n));
    }
    
    public void vietDS() {
        System.out.println("Cac dau sach ");
        for(ThuVien i:list)
            if(i instanceof Sach)
                System.out.println(i);
        System.out.println("Cac dau tap chi ");
        for(ThuVien i:list)
            if(i instanceof TapChi)
                System.out.println(i);
        System.out.println("Cac dau bao ");
        for(ThuVien i:list)
            if(i instanceof Bao)
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
            ThuVien p=list.get(vitri);
            System.out.println("nhap ten nha XB:");
            String tennhaXB=in.nextLine();
            System.out.println("nhap so ban:");
            int soban=Integer.parseInt(in.nextLine());
            p.setTennhaXB(tennhaXB);
            p.setSoban(soban);
            System.out.println("sua thanh cong!!!");
            
        }
    }
    
    public void suaSach(){
        List<Sach> l=new ArrayList<>();
        for(ThuVien i:list)
            if(i instanceof Sach)
                l.add((Sach)i);
        System.out.println("nhap ma sach can sua:");
        String ma=in.nextLine();
        for(int i=0;i<l.size();i++){
            Sach x=l.get(i);
            if(x.getMa().equalsIgnoreCase(ma)){
                System.out.println("nhap ten nha XB ");
                String tennhaXB=in.nextLine();
                System.out.println("nhap so ban ");
                int soban=Integer.parseInt(in.nextLine());
                System.out.println("nhap ten tac gia");
                String tenTG=in.nextLine();
                System.out.println("nhap ten sach ");
                String tensach=in.nextLine();
                System.out.println("nhap so trang");
                int sotrang=Integer.parseInt(in.nextLine());
                x.setTennhaXB(tennhaXB);
                x.setSoban(soban);
                x.setTenTG(tenTG);
                x.setTenSach(tensach);
                x.setSotrang(sotrang);
                System.out.println("sua thanh cong!!!");
                
            }
        }      
    }
    
    public void suaTapChi(){
        List<TapChi> l=new ArrayList<>();
        for(ThuVien i:list)
            if(i instanceof Sach)
                l.add((TapChi)i);
        System.out.println("nhap ma sach can sua:");
        String ma=in.nextLine();
        for(int i=0;i<l.size();i++){
            TapChi x=l.get(i);
            if(x.getMa().equalsIgnoreCase(ma)){
                System.out.println("nhap ten nha XB ");
                String tennhaXB=in.nextLine();
                System.out.println("nhap so ban ");
                int soban=Integer.parseInt(in.nextLine());
                System.out.println("nhap so phat hanh");
                int soPH=Integer.parseInt(in.nextLine());
                System.out.println("nhap thang phat hanh ");
                int thangPH=Integer.parseInt(in.nextLine());
                x.setTennhaXB(tennhaXB);
                x.setSoban(soban);
                x.setSoPH(soPH);
                x.setThangPH(thangPH);
                System.out.println("sua thanh cong!!!");
            }
        }      
    }
    
    public void suaBao(){
        List<Bao> l=new ArrayList<>();
        for(ThuVien i:list)
            if(i instanceof Bao)
                l.add((Bao)i);
        System.out.println("nhap ma sach can sua:");
        String ma=in.nextLine();
        for(int i=0;i<l.size();i++){
            Bao x=l.get(i);
            if(x.getMa().equalsIgnoreCase(ma)){
                System.out.println("nhap ten nha XB ");
                String tennhaXB=in.nextLine();
                System.out.println("nhap so ban ");
                int soban=Integer.parseInt(in.nextLine());
                System.out.println("nhap ngay phat hanh ");
                int ngayPH=Integer.parseInt(in.nextLine());
                x.setTennhaXB(tennhaXB);
                x.setSoban(soban);
                x.setNgayPH(ngayPH);
                System.out.println("sua thanh cong!!!");
            }
        }      
    }
    
    public void timTheotennhaXB() {
        System.out.println("nhap ten nha XB can tim:");
        String h=in.nextLine().toLowerCase();
        boolean co =false;
        for(ThuVien i:list)
            if(i.getTennhaXB().toLowerCase().contains(h)){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay nha XB nao");
    }
    
    public void timTheoThang() {
        System.out.println("nhap tu thang can tim:");
        int n1=Integer.parseInt(in.nextLine());
        System.out.println("nhap den thang can tim:");
        int n2=Integer.parseInt(in.nextLine());
        boolean co =false;
        for(TapChi i:list1)
            if(i.getThangPH()>= n1 && i.getThangPH()<=n2){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay cuon sach nao");
    }
    
    public void timTheoNgay() {
        System.out.println("nhap tu ngay can tim:");
        int n1=Integer.parseInt(in.nextLine());
        System.out.println("nhap den ngay can tim:");
        int n2=Integer.parseInt(in.nextLine());
        boolean co =false;
        for(Bao i:list2)
            if(i.getNgayPH()>= n1 && i.getNgayPH()<=n2){
                System.out.println(i);
                co = true;
            }
        if(co==false)
            System.out.println("khong tim thay to bao nao");
    }
    
    public void sapxepTheoMa() {
        Collections.sort(list);
        
    }
    
    
}

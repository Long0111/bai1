/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2_ktr3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLTV q=new QLTV();
        
        while(true){
            System.out.println("-------MENU-------");
            System.out.println("1. nhap Sach ");
            System.out.println("2. nhap Tap Chi ");
            System.out.println("3. nhap Bao");
            System.out.println("4. viet ra ds");
            
            
            System.out.println("5. Xoa");
            System.out.println("6. Sua");
            System.out.println("7. Sua sach");
            System.out.println("8. sua tap chi");
            System.out.println("9. sua bao");
            
            System.out.println("10. Tim theo ten nha XB");
            System.out.println("11. Tim theo thang PH");
            System.out.println("12. Tim theo ngay PH");
            System.out.println("13. Sap xep theo ma");
//            System.out.println("14. Sap xep theo ngay PH");
//            System.out.println("15. Sap xep thep CS giam dan");
//            System.out.println("16. Sap xep theo Mau va gia");
            
            System.out.println("0. Thoat");
            System.out.println("-----------------");
            System.out.println("Ban chon  (0->10): ");
            int chon;
            Scanner in = new Scanner(System.in);
            chon=Integer.parseInt(in.nextLine());
            switch(chon){
                case 0:System.out.println("BYE!!!");
                        System.exit(0);
                case 1:q.nhapSach();
                        break;
                case 2:q.nhapTapChi();
                        break;
                case 3:q.nhapBao();
                        break;
                case 4:q.vietDS();
                        break;
                case 5:q.xoa();
                        break;
                case 6:q.sua();
                        break;
                case 7:q.suaSach();
                        break;
                case 8:q.suaTapChi();
                        break;
                case 9:q.suaBao();
                        break;
                case 10:q.timTheotennhaXB();
                        break;
                case 11:q.timTheoThang();
                        break;
                case 12:q.timTheoNgay();
                        break;
                case 13:q.sapxepTheoMa();
                        break;
                case 14:
                        break;
                case 15:
                        break;
                case 16:
                        break;
                default:System.out.println("chi chon 0->14");
                        break;
            }
        }
    }
}

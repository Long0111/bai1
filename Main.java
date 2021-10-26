
package Q2_ktr1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        QLGT q=new QLGT();
        
        while(true){
            System.out.println("-------MENU-------");
            System.out.println("1. nhap Oto ");
            System.out.println("2. nhap XeMay ");
            System.out.println("3. Viet ra ds");
            
            System.out.println("4. Xoa");
            System.out.println("5. Sua");
            System.out.println("6. Sua xe may");
            
            System.out.println("7. Tim theo ma");
            System.out.println("8. tim theo hang");
            
            System.out.println("9. Tim theo nam");
            
            System.out.println("10. Tim theo mau");
            System.out.println("11. Tim Oto theo so cho");
            System.out.println("12. Sap xep theo gia ma");
            System.out.println("13. ");
            System.out.println("14. ");
            System.out.println("15. Sap xep thep CS giam dan");
            System.out.println("16. Sap xep theo Mau va gia");
            
            System.out.println("0. Thoat");
            System.out.println("-----------------");
            System.out.println("Ban chon  (0->10): ");
            int chon;
            Scanner in = new Scanner(System.in);
            chon=Integer.parseInt(in.nextLine());
            switch(chon){
                case 0:System.out.println("BYE!!!");
                        System.exit(0);
                case 1:q.nhapOto();
                        break;
                case 2:q.nhapXeMay();
                        break;
                case 3:q.vietDS();
                        break;
                case 4:q.xoa();
                        break;
                case 5:q.sua();
                        break;
                case 6:q.suaXemay();
                        break;
                case 7:q.timTheoMa();
                        break;
                case 8:q.timTheoHang();
                        break;
                case 9:q.timTheoNam();
                        break;
                case 10:q.timTheoMau();
                        break;
                case 11:q.timTheoSoCho();
                        break;
                case 12:q.sapxepTheoMa();
                        break;
                case 13:
                        break;
                case 14:
                        break;
                case 15:q.sapxepCSgiamdan();
                        break;
                case 16:q.sapxepTheoMauVaGia();
                        break;
                default:System.out.println("chi chon 0->14");
                        break;
            }
        }
        
    }
}

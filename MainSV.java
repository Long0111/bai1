
package Q2_ktr1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class MainSV {
    public static void main(String[] args){
        List<SinhVien> list=new ArrayList<>();
        list.add(new SinhVien(1,"To An An","05/10/2000"));
        list.add(new SinhVien(4,"Nguyen Thanh Long","11/08/2001"));
        list.add(new SinhVien(5,"Vu Van An","05/11/2000"));
        list.add(new SinhVien(2,"Bui Thanh Tu","12/11/2000"));
        System.out.println("ds ban dau");
        for(SinhVien i:list)
            System.out.println(i);
        list.sort(new Comparator<SinhVien>(){
            public int compare(SinhVien o1, SinhVien o2){
                //sap xep theo ho va ten
                String[] t1=o1.getHoten().split("\\s+");
                String n1=t1[t1.length-1];
                String[] t2=o2.getHoten().split("\\s+");
                String n2=t2[t2.length-1];
                if(n1.equalsIgnoreCase(n2))
                    return o1.getHoten().compareToIgnoreCase(o2.getHoten());
                else
                    return n1.compareToIgnoreCase(n2);
            }
        });
        System.out.println("ds sap xep theo ho ten");
        for(SinhVien i:list)
            System.out.println(i);
        list.sort(new Comparator<SinhVien>(){
            public int compare(SinhVien o1, SinhVien o2){
                //sap xep theo ngay sinh
                String[] t1=o1.getNsinh().split("/");
                String n1=t1[2]+t1[1]+t1[0];
                String[] t2=o2.getNsinh().split("/");
                String n2=t2[2]+t2[1]+t2[0];
                return n1.compareToIgnoreCase(n2);
            }
        });
        System.out.println("ds sap xep theo ngay sinh");
        for(SinhVien i:list)
            System.out.println(i);
        
        //tim co ma la 2
//        Comparator<SinhVien> c=new Comparator<SinhVien>(){
//            @Override
//            public int compare(SinhVien o1, SinhVien o2) {
//                return o1.getMa()-o2.getMa();
//            }
//        };
//        int index=Collections.binarySearch(list, new SinhVien(2,null,null),c);
//        System.out.println(list.get(index));
        SinhVien[] ss=list.toArray(new SinhVien[list.size()]);
        System.out.println("sau khi doi: ");
        for(SinhVien i:ss)
            System.out.println(i);
        List<String> tens=Arrays.asList("To an","Tuan Bing","Ha Anh","Manh");
        for(String i:tens)
            System.out.println(i);
    }
}

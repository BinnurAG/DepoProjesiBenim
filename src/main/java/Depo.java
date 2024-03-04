import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

class Depo {
    private Map<Integer, Urun> urunler;
    LocalDateTime myCurrentTime = LocalDateTime.now();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-MMM-yyyy  hh:mm a");
    String formattedTime = time.format(myCurrentTime);

    static int idSayac = 1000;
    public Depo() {
        this.urunler = new HashMap<>();
    }


    public void urunTanimlama(String urunIsmi, String uretici, String birim) {
        Urun urun = new Urun(urunIsmi, uretici, 0, birim, null);

        urun.setId(idSayac++);
        System.out.println("Ürün tanımlandı: " + urunIsmi);
        urunler.put(urun.getId(), urun);
    }

    public void urunListele() { //Hüseyin hocadan alalım

        System.out.println("Ürün Listesi:");
        System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", "ID", "ISIM", "URETICI", "MIKTAR", "BIRIM", "RAF");

        for (Urun urun : urunler.values()) {

            System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", urun.getId(),
                     urun.getUrunIsmi(),
                     urun.getUretici(),
                     urun.getMiktar(),
                     urun.getBirim(),
                     urun.getRaf());
        }

    }
/* public void urunListele() {
    System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", "ID", "ISIM", "URETICI", "MIKTAR", "BIRIM", "RAF");
    System.out.println("---------------------------------------------------------------");
    for (Urun product : urunList) {
        System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", product.id, product.urunIsmi, product.uretici, product.miktar, product.birim, product.raf);}
    System.out.println();
}*/




    public void urunGirisi(int id, int girisMiktar) {
        Urun urun = urunler.get(id);
        if (urun != null) {
            int yeniMiktar = urun.getMiktar() + girisMiktar;
            urun.setMiktar(yeniMiktar);
            System.out.println("Ürün girişi yapıldı. Yeni miktar: " + yeniMiktar + " Giriş zamanı "+ formattedTime);
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }


    public void urunuRafaKoy(int id, String raf) {
        Urun urun = urunler.get(id);
        if (urun != null) {
            urun.setRaf(raf);
            System.out.println("Ürün rafa konuldu.");
        }else
            System.out.println("Ürün bulunamadı.");

    }

    public void urunCikisi(int id, int cikisMiktar) {
        Urun urun = urunler.get(id);
        if (urun != null) {
            int yeniMiktar = urun.getMiktar() - cikisMiktar;
            if (yeniMiktar >= 0) {
                urun.setMiktar(yeniMiktar);
                System.out.println("Ürün çıkışı yapıldı. Yeni miktar: " + yeniMiktar + "  Çıkış zamanı "+ formattedTime);
            } else {
                System.out.println("Stokta yeterli ürün yok.");
            }
        }else {
            System.out.println("Ürün bulunamadı.");
        }

    }
}
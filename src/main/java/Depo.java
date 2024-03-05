import java.util.ArrayList;
import java.util.List;

public class Depo {
    private final List<Urun> urunListesi;

    public Depo() {
        this.urunListesi = new ArrayList<>();
    }

    public void urunTanimlama(int id, String urunIsmi, String uretici, String birim) {
        Urun urun = new Urun(id, urunIsmi, uretici, 0, birim, 0);
        urunListesi.add(urun);
        System.out.println("Ürün tanımlandı: " + urunIsmi);
    }

    public void urunListele() {
        System.out.println("Ürün Listesi:");
        for (Urun urun : urunListesi) {
            System.out.println("ID: " + urun.getId() +
                    ", Ürün İsmi: " + urun.getUrunIsmi() +
                    ", Üretici: " + urun.getUretici() +
                    ", Miktar: " + urun.getMiktar() +
                    ", Birim: " + urun.getBirim() +
                    ", Raf: " + urun.getRaf());
        }
    }

    public void urunGirisi(int id, int miktar) {
        for (Urun urun : urunListesi) {
            if (urun.getId() == id) {
                System.out.println("Depoda bulunan ürün miktari " +miktar);
                int yeniMiktar = urun.getMiktar() + miktar;
                urun.setMiktar(yeniMiktar);
                System.out.println("Ürün girişi yapıldı. Yeni miktar: " + yeniMiktar);
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }

    public void urunuRafaKoy(int id, int raf) {
        for (Urun urun : urunListesi) {
            if (urun.getId() == id) {
                urun.setRaf(String.valueOf(raf));
                System.out.println("Ürün rafa konuldu.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }

    public void urunCikisi(int id, int miktar) {
        for (Urun urun : urunListesi) {
            if (urun.getId() == id) {
                int yeniMiktar = urun.getMiktar() - miktar;
                if (yeniMiktar >= 0) {
                    urun.setMiktar(yeniMiktar);
                    System.out.println("Ürün çıkışı yapıldı. Yeni miktar: " + yeniMiktar);
                } else {
                    System.out.println("Stokta yeterli ürün yok.");
                }
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }
}
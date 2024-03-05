import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Depo {
    private Map<Integer, Urun> urunler;

    LocalDateTime myCurrentTime = LocalDateTime.now();
    DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-MMM-yyyy  hh:mm a");
    String formattedTime = time.format(myCurrentTime);

    static int idSayac = 1000;
     static Scanner input =new Scanner(System.in);
    public Depo() {
        this.urunler = new HashMap<>();
    }
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_UNDERLINE = "\u001B[4m";
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_YELLOW = "\u001B[33m";


    public Urun urunTanimlama(String urunIsmi, String uretici, String birim) {

        Urun urun = new Urun(urunIsmi, uretici, 0, birim, null);
        urun.setId(idSayac++);
        urunler.put(urun.getId(), urun);
        do {
            System.out.println("Urun Eklemeye devam etmek icin 1' e \nAnasayfaya donmek icin 2'ye basiniz");
            int secim = input.nextInt();

            if (secim==1){
                secim();
                break;
            } else if (secim==2) {
                new DepoUygulamasi();
                break;

            }else{
                System.out.println("Yanlis bir secim yaptiniz");
            }

        }while(true);
        return urun;
    }

    private void secim() {
        input.nextLine();
        System.out.print("Ürün İsmi: ");
        String urunIsmi = input.nextLine();
        System.out.print("Üretici: ");
        String uretici = input.nextLine();
        System.out.print("Birim:(cuval,koli,teneke) ");
        String birim = input.nextLine();
        urunTanimlama(urunIsmi, uretici, birim);

    }



    public void urunListele() { //Hüseyin hocadan alalım

        System.out.println(ANSI_BLUE + "          *** Urun Listesi ***     " + ANSI_RESET);
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", "ID", "ISIM", "URETICI", "MIKTAR", "BIRIM", "RAF");
        System.out.println("---------------------------------------------------------------------------------------------");

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

        private String kullaniciBilgiAlma(String mesaj,String hataMesaji){
        String metinGirisi;
        do {
            System.out.println(mesaj);
            metinGirisi=input.nextLine().trim().toLowerCase();
            if (metinkontrolGirisimi(metinGirisi)){
                return metinGirisi;

            } else if (Integer.parseInt(metinGirisi)==0) {
                break;

            }else{
                System.out.println(hataMesaji);
            }
        }while(true);
        return metinGirisi;
        }
        private boolean metinkontrolGirisimi(String girdi){
        String gecerliKullanim ="[a-z0-9 ]+";
        int minKa =1;
        int maxKa =20;
            return girdi.matches(gecerliKullanim) && girdi.length() >= minKa && girdi.length() <= maxKa;
        }
    public boolean isExist(String urunIsmi, String uretici, String birim) {
        boolean isExist = false;
        for (Urun urun: urunler.values()) {
            if (urun.getUrunIsmi().equals(urunIsmi) && urun.getUretici().equals(uretici)&& urun.getBirim().equals(birim)) {
                isExist = true;
                continue;
            }
        }
        return isExist;
    }
        }



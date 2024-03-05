
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class DepoUygulamasi {


    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Depo depo = new Depo();
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_UNDERLINE = "\u001B[4m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_YELLOW = "\u001B[33m";
        // TODO: 04/03/2024 aynı ürün geldiğinde, bu ürün mevcuttur diye uyarı versin, ürün eklemeye devam etmek için 1 e çıkmak için 9 a basın


        //mismatch exception ı kullanacak mıyız?
        while (true) {


            System.out.println(ANSI_YELLOW + "=============   GIDA DEPOSU =============\n" +
                    "=========== ANA MENU ============\n" +
                    "\t   1- Ürün Tanımlama\n" +
                    "\t   2- Ürün Listeleme\n" +
                    "\t   3- Ürün Girişi\n" +
                    "\t   4- Ürünü Rafa Koyma\t\n" +
                    "\t   5- Ürün Çıkışı \t\n" +
                    "\t   6- Çıkış" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Lütfen Menuden tercihinizi yapiniz" + ANSI_RESET);


            int secim;
            try {
                secim = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz giriş! Lütfen bir tamsayı girin.");
                scanner.next(); // Boşluk karakterlerini temizler
                continue; // Döngünün başına dön
            }


            switch (secim) {
                case 1:
                    System.out.println(ANSI_BLUE + "                          *** URUN TANIMLAMA ***          " + ANSI_RESET);
                    System.out.println("---------------------------------------------------------------------------------------------");
                    scanner.nextLine();
                    System.out.print("Ürün İsmi: ");
                    String urunIsmi = scanner.nextLine();
                    System.out.print("Üretici: ");
                    String uretici = scanner.nextLine();
                    System.out.print("Birim: (cuval,koli,teneke) ");
                    String birim = scanner.nextLine();
                    if (depo.isExist(urunIsmi,uretici,birim)) {
                        System.out.println("“Bu urun depoda mevcuttur Lutfen urun girisini seciniz“");
                        break;
                    } else {
                        depo.urunTanimlama(urunIsmi, uretici, birim);
                    }
                    break;

                case 2:
                    depo.urunListele();
                    break;
                case 3:
                    System.out.print("ID: ");
                    int girisId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int girisMiktar = scanner.nextInt();
                    depo.urunGirisi(girisId, girisMiktar);
                    break;
                case 4:
                    System.out.print("ID: ");
                    int rafId = scanner.nextInt();
                    System.out.print("Raf: ");
                    String raf = scanner.next();
                    depo.urunuRafaKoy(rafId, raf);
                    break;
                case 5:
                    System.out.print("ID: ");
                    int cikisId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int cikisMiktar = scanner.nextInt();
                    depo.urunCikisi(cikisId, cikisMiktar);
                    break;
                case 6:
                    System.out.println("Programdan çıkılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");



            }
            Thread.sleep(10000);
        }
    }
}
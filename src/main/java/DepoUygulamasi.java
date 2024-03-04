import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class DepoUygulamasi {




    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Depo depo = new Depo();

        // TODO: 04/03/2024 aynı ürün geldiğinde, bu ürün mevcuttur diye uyarı versin, ürün eklemeye devam etmek için 1 e çıkmak için 9 a basın









        //mismatch exception ı kullanacak mıyız?
        while (true) {



            System.out.println("\nDepo Uygulaması");
            System.out.println("1- Ürün Tanımlama");
            System.out.println("2- Ürün Listeleme");
            System.out.println("3- Ürün Girişi");
            System.out.println("4- Ürünü Rafa Koyma");
            System.out.println("5- Ürün Çıkışı");
            System.out.println("6- Çıkış");
            System.out.print("Seçiminizi yapın: ");


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

                    scanner.nextLine();
                    System.out.print("Ürün İsmi: ");
                    String urunIsmi = scanner.nextLine();
                    System.out.print("Üretici: ");
                    String uretici = scanner.nextLine();
                    System.out.print("Birim: ");
                    String birim = scanner.nextLine();
                    depo.urunTanimlama(urunIsmi, uretici, birim);
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
        }
    }
}
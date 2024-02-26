import java.util.Scanner;

public class DepoUygulamasi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Depo depo = new Depo();

        while (true) {
            System.out.println("1- Ürün Tanımlama");
            System.out.println("2- Ürün Listeleme");
            System.out.println("3- Ürün Girişi");
            System.out.println("4- Ürünü Rafa Koyma");
            System.out.println("5- Ürün Çıkışı");
            System.out.println("6- Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Dummy nextLine to consume newline character
                    System.out.print("Ürün İsmi: ");
                    String urunIsmi = scanner.nextLine();
                    System.out.print("Üretici: ");
                    String uretici = scanner.nextLine();
                    System.out.print("Birim: ");
                    String birim = scanner.nextLine();
                    depo.urunTanimlama(id, urunIsmi, uretici, birim);
                }
                case 2 -> depo.urunListele();
                case 3 -> {
                    System.out.print("ID: ");
                    int girisId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int girisMiktar = scanner.nextInt();
                    depo.urunGirisi(girisId, girisMiktar);
                }
                case 4 -> {
                    System.out.print("ID: ");
                    int rafId = scanner.nextInt();
                    System.out.print("Raf: ");
                    int raf = scanner.nextInt();
                    depo.urunuRafaKoy(rafId, raf);
                }
                case 5 -> {
                    System.out.print("ID: ");
                    int cikisId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int cikisMiktar = scanner.nextInt();
                    depo.urunCikisi(cikisId, cikisMiktar);
                }
                case 6 -> {
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }
}

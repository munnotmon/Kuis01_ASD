import java.util.Scanner;

public class MainBarang12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TransaksiBarang12 transaksi = new TransaksiBarang12();

        while (true) {
            System.out.println("\n=============================");
            System.out.println("      MOONA BEAUTY SHOP      ");
            System.out.println("=============================");
            System.out.println("1.  Lihat Barang");
            System.out.println("2.  Beli Barang");
            System.out.println("3.  Lihat Pembelian");
            System.out.println("4.  Keluar");
            System.out.println("=============================");
            System.out.print("Masukkan Pilihan Anda: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    transaksi.tampilkanBarang();
                    break;
                case 2:
                    transaksi.beliBarang(input);
                    break;
                case 3:
                    transaksi.tampilkanPembelian();
                    break;
                case 4:
                    System.out.println("\nTerima kasih telah berbelanja! Sampai jumpa lagi.");
                    input.close();
                    return;
                default:
                    System.out.println("⚠ Pilihan tidak valid! Silakan pilih menu yang tersedia.");
            }
        }
    }
}

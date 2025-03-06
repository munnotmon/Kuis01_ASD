import java.util.Scanner;

public class TransaksiBarang12 {
    Barang12[] daftarBarang;
    Barang12[] daftarPembelian;
    int[] jumlahBeli;
    int totalHarga = 0;
    int jumlahPembelian = 0;

    public TransaksiBarang12() {
        daftarBarang = new Barang12[]{
            new Barang12("BN1", "BNB Mousse Tint", 56000, 10),
            new Barang12("BN2", "BNB Compact Powder", 65000, 13),
            new Barang12("BN3", "BNB Mochi Blush", 73000, 15),
            new Barang12("BN4", "BNB Skin Tint Serum", 96500, 8),
            new Barang12("BN5", "BNB Roll Maskara", 76000, 7)
        };
        daftarPembelian = new Barang12[50];
        jumlahBeli = new int[50];
    }

    public void tampilkanBarang() {
        System.out.println("\n==========================================================");
        System.out.println("                     DAFTAR BARANG                       ");
        System.out.println("==========================================================");
        System.out.printf("%-6s | %-20s | %-10s | %s\n", "Kode", "Nama", "Harga", "Stok");
        System.out.println("----------------------------------------------------------");
        for (Barang12 b : daftarBarang) {
            System.out.printf("%-6s | %-20s | Rp %,8d | %d\n", b.kode, b.nama, b.harga, b.stok);
        }
        System.out.println("==========================================================");
    }

    public void beliBarang(Scanner input) {
        while (true) {
            System.out.print("\nMasukkan kode barang: ");
            String kode = input.nextLine();
            boolean ditemukan = false;

            for (int i = 0; i < daftarBarang.length; i++) {
                if (daftarBarang[i].kode.equalsIgnoreCase(kode)) {
                    ditemukan = true;
                    System.out.print("Masukkan jumlah yang ingin dibeli: ");
                    int jumlah = input.nextInt();
                    input.nextLine(); 

                    if (jumlah <= daftarBarang[i].stok) {
                        daftarBarang[i].stok -= jumlah; 

                        boolean sudahAda = false;
                        for (int j = 0; j < jumlahPembelian; j++) {
                            if (daftarPembelian[j].kode.equalsIgnoreCase(kode)) {
                                jumlahBeli[j] += jumlah;
                                sudahAda = true;
                                break;
                            }
                        }

                        if (!sudahAda) {
                            daftarPembelian[jumlahPembelian] = daftarBarang[i];
                            jumlahBeli[jumlahPembelian] = jumlah;
                            jumlahPembelian++;
                        }

                        System.out.println("\n✅ Berhasil membeli " + jumlah + " " + daftarBarang[i].nama);
                    } else {
                        System.out.println("⚠ Stok tidak mencukupi!");
                    }
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("❌ Barang tidak ditemukan! Pastikan kode benar.");
            }

            System.out.print("\nApakah Anda ingin membeli barang lagi? (y/n): ");
            String lanjut = input.nextLine();
            if (!lanjut.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public void tampilkanPembelian() {
        if (jumlahPembelian == 0) {
            System.out.println("\n⚠ Belum ada pembelian.");
            return;
        }

        totalHarga = 0;
        System.out.println("\n==========================================================");
        System.out.println("                     DAFTAR PEMBELIAN               ");
        System.out.println("==========================================================");
        System.out.printf("%-6s | %-20s | %-5s | %-10s\n", "Kode", "Nama", "Qty", "Harga");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < jumlahPembelian; i++) {
            Barang12 b = daftarPembelian[i];
            int subtotal = jumlahBeli[i] * b.harga;
            System.out.printf("%-6s | %-20s | %-5d | Rp %,8d\n", b.kode, b.nama, jumlahBeli[i], subtotal);
            totalHarga += subtotal;
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("Total Harga: Rp %,d\n", totalHarga);
        System.out.println("==========================================================");
    }
}

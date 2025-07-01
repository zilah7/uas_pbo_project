import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Lihat Data Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    Barang.insertData();
                    break;
                case 2:
                    BarangView.viewData();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 3);
    }
}
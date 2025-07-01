import java.sql.*;
import java.util.Scanner;

public class Barang {
    public static void insertData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Input Data Barang ===");
        System.out.print("Kode Barang: ");
        String kode = scanner.nextLine();
        
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        
        System.out.print("Harga: ");
        int harga = scanner.nextInt();
        
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertBarang(?, ?, ?, ?)}")) {
            
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            
            stmt.execute();
            System.out.println("Data barang berhasil ditambahkan!");
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
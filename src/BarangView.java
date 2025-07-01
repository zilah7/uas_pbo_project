import java.sql.*;

public class BarangView {
    public static void viewData() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM view_barang")) {
            
            System.out.println("=== Data Barang ===");
            System.out.println("----------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-10s | %-5s | %-12s |\n", 
                "Kode", "Nama", "Harga", "Stok", "Total Nilai");
            System.out.println("----------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("| %-10s | %-20s | %-10d | %-5d | %-12d |\n",
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getInt("harga"),
                    rs.getInt("stok"),
                    rs.getInt("total_nilai"));
            }
            
            System.out.println("----------------------------------------------------------------");
            
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
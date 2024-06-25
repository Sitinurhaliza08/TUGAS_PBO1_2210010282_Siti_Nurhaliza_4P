/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author asus
 */
public class koneksi {
    
    private String databaseName = "db_detail_biaya";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/"+databaseName;
    public static Connection koneksiDB;
    
   public koneksi (){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           koneksiDB = DriverManager.getConnection(lokasi,username,password);
           System.out.println("Database Terkoneksi");
       }catch (Exception e){
           System.err.println(e.toString());
       }
   }
   
   public void SimpanBiaya(int paramidbiaya, String paramnamabiaya, String paramnominalbiaya, int paramidjurusan,
           int paramidtapel) {
   
   
       try{
           String SQL = "INSERT INTO Biaya(id_biaya, nama_biaya, nominal_biaya, id_jurusan, id_tapel)" 
                   + "VALUE(?,?,?,?,?)";
           
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidbiaya);
           perintah.setString(2, paramnamabiaya);
           perintah.setString(3, paramnominalbiaya);
           perintah.setInt(4, paramidjurusan);
           perintah.setInt(5, paramidtapel);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Simpan");
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
         
  }
  
  public void UbahBiaya (int paramidbiaya, String paramnamabiaya, String paramnominalbiaya, int paramidjurusan,
           int paramidtapel) {
      
      try{
        String SQL = "UPDATE Biaya SET  nama_biaya=?, nominal_biaya=?, id_jurusan=?, id_tapel=? WHERE id_biaya=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramnamabiaya);
           perintah.setString(2, paramnominalbiaya);
           perintah.setInt(3, paramidjurusan);
           perintah.setInt(4, paramidtapel);
           perintah.setInt(5, paramidbiaya);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Ubah");
       } catch (Exception e){
           System.out.println(e.getMessage());  
       }
          
  }
  
  public void HapusBiaya(int paramidbiaya){
      try{
          String SQL = "DELETE FROM Biaya WHERE id_biaya=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidbiaya);
          perintah.executeUpdate();
          System.out.println("Data Berhasil di Hapus");
      } catch (Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void CariBiaya(int paramidbiaya){
      try{
          String SQL = "SELECT*FROM Biaya WHERE id_biaya=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidbiaya);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
              System.out.println("id_biaya :"+data.getInt("id_biaya"));
              System.out.println("nama_jurusan :"+data.getInt("nama_jurusan"));
              System.out.println("nominal_biaya :"+data.getInt("niminal_biaya"));
              System.out.println("id_jurusan :"+data.getString("id_jurusan"));
              System.out.println("id_tapel :"+data.getString("id_tapel"));
          }
      }catch(Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void dataBiaya(){
      try{
         Statement stmt = koneksiDB.createStatement();
         ResultSet baris = stmt.executeQuery("SELECT*FROM Biaya ORDER BY id_biaya ASC");
         while(baris.next()){
             System.out.println(baris.getInt("id_biaya")+"|"+
                     baris.getString("nama_biaya")+" | "+
                     baris.getString("nominal_biaya")+" | "+
                     baris.getInt("id_jurusan")+" | "+
                     baris.getInt("id_tapel"));
         }
      }catch (Exception e){
      System.err.println(e.getMessage());
      }
  
    }
  
  public void SimpanDetailBiaya(int paramiddetailbiaya, int paramidsiswa, String paramtglbayar, int paramidbiaya,
           String paramdibayar, int paramiduser) {
   
   
       try{
           String SQL = "INSERT INTO detail_biaya(id_detail_biaya, id_siswa, tgl_bayar, id_biaya, dibayar, id_user)" 
                   + "VALUE(?,?,?,?,?,?)";
           
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramiddetailbiaya);
           perintah.setInt(2, paramidsiswa);
           perintah.setString(3, paramtglbayar);
           perintah.setInt(4, paramidbiaya);
           perintah.setString(5, paramdibayar);
           perintah.setInt(6, paramiduser);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Simpan");
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
         
  }
  
  public void UbahDetailBiaya (int paramiddetailbiaya, int paramidsiswa, String paramtglbayar, int paramidbiaya,
           String paramdibayar, int paramiduser) {
      
      try{
        String SQL = "UPDATE detail_biaya SET id_siswa=?, tgl_bayar=?, id_biaya=?, dibayar=?, id_user=? WHERE id_detail_biaya=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidsiswa);
           perintah.setString(2, paramtglbayar);
           perintah.setInt(3, paramidbiaya);
           perintah.setString(4, paramdibayar);
           perintah.setInt(5, paramiduser); 
           perintah.setInt(6, paramiddetailbiaya);

           perintah.executeUpdate();
                System.out.println("Data Berhasil di Ubah");
       } catch (Exception e){
           System.out.println(e.getMessage());  
       }
          
  }
  
  public void HapusDetailBiaya(int paramiddetailbiaya){
      try{
          String SQL = "DELETE FROM detail_biaya WHERE id_detail_biaya=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramiddetailbiaya);
          perintah.executeUpdate();
          System.out.println("Data Berhasil di Hapus");
      } catch (Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void CariDetailBiaya(int paramiddetailbiaya){
      try{
          String SQL = "SELECT*FROM detail_biaya WHERE id_detail_biaya=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramiddetailbiaya);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
              System.out.println("id_detail_biaya :"+data.getInt("id_detail_biaya"));
              System.out.println("id_siswa :"+data.getInt("id_siswa"));
              System.out.println("tgl_bayar :"+data.getString("tgl_bayar"));
              System.out.println("id_bayar :"+data.getInt("id_biaya"));
              System.out.println("dibayar :"+data.getString("dibayar"));
              System.out.println("id_user :"+data.getInt("id_user"));
          }
      }catch(Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void dataDetailBiaya(){
      try{
         Statement stmt = koneksiDB.createStatement();
         ResultSet baris = stmt.executeQuery("SELECT*FROM detail_biaya ORDER BY id_detail_biaya ASC");
         while(baris.next()){
             System.out.println(baris.getInt("id_detail_biaya")+"|"+
                     baris.getInt("id_siswa")+" | "+
                     baris.getString("tgl_bayar")+" | "+
                     baris.getInt("id_biaya")+" | "+
                     baris.getString("dibayar")+" | "+
                     baris.getInt("id_user"));
         }
      }catch (Exception e){
      System.err.println(e.getMessage());
      }
  
    }
  
  public void SimpanJurusan(int paramidjurusan, String paramkodejurusan, String paramnamajurusan, String paramkaprodi) {
   
       try{
           String SQL = "INSERT INTO Jurusan(id_jurusan, kode_jurusan, nama_jurusan, kaprodi)" 
                   + "VALUE(?,?,?,?)";
           
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidjurusan);
           perintah.setString(2, paramkodejurusan);
           perintah.setString(3, paramnamajurusan);
           perintah.setString(4, paramkaprodi);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Simpan");
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
         
  }
  
  public void UbahJurusan (int paramidjurusan, String paramkodejurusan, String paramnamajurusan, String paramkaprodi) {
      
      try{
        String SQL = "UPDATE Jurusan SET  kode_jurusan=?, nama_jurusan=?, kaprodi=? WHERE id_jurusan=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramkodejurusan);
           perintah.setString(2, paramnamajurusan);
           perintah.setString(3, paramkaprodi);  
           perintah.setInt(4, paramidjurusan);

           perintah.executeUpdate();
                System.out.println("Data Berhasil di Ubah");
       } catch (Exception e){
           System.out.println(e.getMessage());  
       }
          
  }
  
  public void HapusJurusan(int paramidjurusan){
      try{
          String SQL = "DELETE FROM Jurusan WHERE id_jurusan=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidjurusan);
          perintah.executeUpdate();
          System.out.println("Data Berhasil di Hapus");
      } catch (Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void CariJurusan(int paramidjurusan){
      try{
          String SQL = "SELECT*FROM Jurusan WHERE id_jurusan=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidjurusan);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
              System.out.println("id_jurusan :"+data.getInt("id_jurusan"));
              System.out.println("kode_jurusan :"+data.getInt("kode_jurusan"));
              System.out.println("nama_jurusan :"+data.getString("nama_jurusan"));
              System.out.println("kaprodi :"+data.getInt("kaprodi"));
              
          }
      }catch(Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void dataJurusan(){
      try{
         Statement stmt = koneksiDB.createStatement();
         ResultSet baris = stmt.executeQuery("SELECT*FROM Jurusan ORDER BY id_jurusan ASC");
         while(baris.next()){
             System.out.println(baris.getInt("id_jurusan")+"|"+
                     baris.getString("kode_jurusan")+" | "+
                     baris.getString("nama_jurusan")+" | "+
                     baris.getString("kaprodi"));
         }
      }catch (Exception e){
      System.err.println(e.getMessage());
      }
  
    }
  
  public void SimpanTapel(int paramidtapel, String paramtahuntapel) {
   
       try{
           String SQL = "INSERT INTO Tapel(id_tapel, tahun_tapel)" 
                   + "VALUE(?,?)";
           
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidtapel);
           perintah.setString(2, paramtahuntapel);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Simpan");
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
         
  }
  
  public void UbahTapel (int paramidtapel, String paramtahuntapel) {
      
      try{
        String SQL = "UPDATE Tapel SET tahun_tapel=? WHERE id_tapel=?";
        
        PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramtahuntapel);
           perintah.setInt(2, paramidtapel);
           perintah.executeUpdate();
                System.out.println("Data Berhasil di Ubah");
       } catch (Exception e){
           System.out.println(e.getMessage());  
       }
          
  }
  
  public void HapusTapel(int paramidtapel){
      try{
          String SQL = "DELETE FROM Tapel WHERE id_tapel=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidtapel);
          perintah.executeUpdate();
          System.out.println("Data Berhasil di Hapus");
      } catch (Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void CariTapel(int paramidtapel){
      try{
          String SQL = "SELECT*FROM Tapel WHERE id_tapel=?";
          PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
          perintah.setInt(1, paramidtapel);
          ResultSet data = perintah.executeQuery();
          while(data.next()){
              System.out.println("id_tapel :"+data.getInt("id_tapel"));
              System.out.println("tahun_tapel:"+data.getInt("tahun_tapel"));
              
          }
      }catch(Exception e){
          System.err.println(e.getMessage());
      }
  }
  
  public void dataTapel(){
      try{
         Statement stmt = koneksiDB.createStatement();
         ResultSet baris = stmt.executeQuery("SELECT*FROM Tapel ORDER BY id_Tapel ASC");
         while(baris.next()){
             System.out.println(baris.getInt("id_tapel")+"|"+
                     baris.getString("tahun_tapel"));
         }
      }catch (Exception e){
      System.err.println(e.getMessage());
      }
  
  }
  
}
    


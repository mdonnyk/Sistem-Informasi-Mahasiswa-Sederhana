/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    
    public Connection getConnection(){
       String host = "localhost";
       String port = "1521";
       String db = "xe";
       String usr = "mdonnyk";
       String pwd = "Ceksatu23";
              try{
           Class.forName("oracle.jdbc.driver.OracleDriver");}
       catch (ClassNotFoundException ex){
           System.out.println("Maaf driver class tidak ditemukan");
           System.out.println(ex.getMessage());}
              Connection conn = null;
       try{
           conn = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":"+db, usr, pwd);
       }
       catch (SQLException ex){
           System.out.println("Maaf koneksi tidak berhasil");
           System.out.println(ex.getMessage());
       }
       
       if (conn!=null) {
           System.out.println("Koneksi ke database terbentuk");
       }
       else{
           System.out.println("Koneksi gagal terbentuk");
       }
       return conn;
   }
    
    public Mahasiswa login(String username, String password) throws Exception{
       Mahasiswa m = new Mahasiswa();
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();   
       try{
           st = conn.createStatement();
           rs = st.executeQuery("select * from mahasiswa where nim='" + username + "' and password='" + password + "'");
           // query menampilkan tabel username sama password
           while(rs.next()){
               // Kalau tabel ada
               m.setNim(rs.getString(1));
               m.setNama(rs.getString(2));
               m.setTotalSKS(rs.getInt(4));
               m.setMakul(this.showMataKuliah(username));
           }}
              catch (SQLException ex){
           System.out.println(ex.getMessage());}
       finally{
           try{
               rs.close();
               st.close();
               conn.close();}
                      catch (SQLException ex){
               System.out.println(ex.getMessage());
           }}
       
        if (m.getNim()==null) {
            throw new Exception("NIM atau Password salah");
        }
       return m;
    
    }
    
    public Admin loginAdmin(String username, String password) throws Exception{
       Admin a = new Admin();
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();   
       try{
           st = conn.createStatement();
           rs = st.executeQuery("select usernamea from adminweb where usernamea='" + username + "' and password='" + password + "'");
           
           while(rs.next()){
                a.setNama(rs.getString(1));
           }}
              catch (SQLException ex){
           System.out.println(ex.getMessage());}
       finally{
           try{
               rs.close();
               st.close();
               conn.close();}
                      catch (SQLException ex){
               System.out.println(ex.getMessage());
           }}
       
        if (a.getNama()==null) {
            throw new Exception("username atau Password salah");
        }
       return a;
    
    }

    public Mahasiswa[] showMahasiswa(){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       Mahasiswa mhs[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT count(nim) FROM mahasiswa");
           rs.next();
           mhs = new Mahasiswa[rs.getInt(1)];
           rs = st.executeQuery("SELECT NIM, NAMA, TOTAL_SKS FROM mahasiswa");
           int index =0;
           while(rs.next()){
               mhs[index] = new Mahasiswa();
               mhs[index].setNim(rs.getString(1));
               mhs[index].setNama(rs.getString(2));
               mhs[index].setTotalSKS(rs.getInt(3));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return mhs;
   }
    
    public MataKuliah[] showMataKuliah(String nim){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       MataKuliah makul[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM KULIAH JOIN MATA_KULIAH USING (kode) WHERE NIM=" + nim);
           rs.next();
           makul = new MataKuliah[rs.getInt(1)];
           rs = st.executeQuery("SELECT kode, nama_makul, dosen, jumlah_sks FROM KULIAH JOIN MATA_KULIAH USING (kode) WHERE NIM=" + nim);
           int index =0;
           while(rs.next()){
               makul[index] = new MataKuliah();
               makul[index].setKode(rs.getString(1));
               makul[index].setNama(rs.getString(2));
               makul[index].setDosen(rs.getString(3));
               makul[index].setJumlahSKS(rs.getInt(4));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return makul;
   }
    
    public MataKuliah[] showMataKuliah(){
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       MataKuliah makul[] = null;
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT COUNT (*) TOTAL FROM MATA_KULIAH");
           rs.next();
           makul = new MataKuliah[rs.getInt(1)];
           rs = st.executeQuery("SELECT kode, nama_makul, dosen, jumlah_sks FROM MATA_KULIAH");
           int index =0;
           while(rs.next()){
               makul[index] = new MataKuliah();
               makul[index].setKode(rs.getString(1));
               makul[index].setNama(rs.getString(2));
               makul[index].setDosen(rs.getString(3));
               makul[index].setJumlahSKS(rs.getInt(4));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return makul;
   }
    
    public void tambahMakul(String nim, String kode, int sks){
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null;
       
       conn = this.getConnection();
   
       try{
           ps = conn.prepareCall("INSERT INTO KULIAH VALUES(?,?)");
           ps.setString(1, nim);
           ps.setString(2, kode);
           ps.executeUpdate();
           conn.commit();
           text = "Data sudah ditambahkan";
           ps = conn.prepareCall("UPDATE MAHASISWA SET TOTAL_SKS = TOTAL_SKS + ? WHERE NIM=?");
           ps.setInt(1, sks);
           ps.setString(2, nim);
           ps.executeUpdate();
           conn.commit();
           
       }
       catch(SQLException ex){
//           throw new Exception(ex.getMessage());
       }
       finally{
           try{
               ps.close();
               conn.close();}
           catch (SQLException ex){
//               throw new Exception(ex.getMessage());
           }
       }
       //return text;
   }
    
    public String hapusMakul(String nim, String kode, int sks) throws Exception{
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null;
       
       conn = this.getConnection();
   
       try{
           ps = conn.prepareStatement("DELETE FROM KULIAH WHERE NIM=? AND KODE=?");
           ps.setString(1, nim);
           ps.setString(2, kode);
           ps.executeUpdate();
           conn.commit();
           ps = conn.prepareCall("UPDATE MAHASISWA SET TOTAL_SKS = TOTAL_SKS - ? WHERE NIM=?");
           ps.setInt(1, sks);
           ps.setString(2, nim);
           ps.executeUpdate();
           conn.commit();
           
       }
       catch(SQLException ex){
           throw new Exception(ex.getMessage());
       }
       finally{
           try{
               ps.close();
               conn.close();}
           catch (SQLException ex){
               throw new Exception(ex.getMessage());
           }
       }
       return text;
   }
    
    public String updatePassword(Mahasiswa mhs, String passLama, String passBaru) throws Exception{
       String text = null;
       Connection conn = null;
       PreparedStatement ps = null;
       
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       
       String nim = mhs.getNim();
       String nama = mhs.getNama();
       String password = null;
       
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT PASSWORD FROM MAHASISWA WHERE NIM=" + nim);
           rs.next();
           password = rs.getString(1);
       } 
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           
       }


       if (password.compareTo(passLama)!=0) {
            throw new Exception("Password lama salah");
        }
       try{
           ps = conn.prepareCall("UPDATE MAHASISWA SET PASSWORD=? WHERE NIM=?");
           ps.setString(1, passBaru);
           ps.setString(2, nim);
           ps.executeUpdate();
           conn.commit();
           text = "Password sudah diganti";
       }
       catch(SQLException ex){
           throw new Exception(ex.getMessage());
           
       }
       finally{
           try{
               ps.close();
               conn.close();
           }
           catch (SQLException ex){
               throw new Exception(ex.getMessage());
           }
       }
       return text;    
   }
    
    public Mahasiswa[] cariMahasiswa(String keyword, String collumn) throws Exception{
       Connection conn = null;
       Statement st = null;
       ResultSet rs = null;
       conn = this.getConnection();
       Mahasiswa mhs[] = null;
       String statement = "SELECT count(nim) FROM mahasiswa WHERE LOWER("+collumn+") LIKE '%"+keyword+"%'";
       try{
           st = conn.createStatement();
           rs = st.executeQuery(statement);
           rs.next();
           int count = rs.getInt(1);
           if (count==0) {
               throw new Exception("Data tidak ditemukan");
           }
           mhs = new Mahasiswa[count];
           statement = "SELECT NIM, NAMA, TOTAL_SKS FROM mahasiswa WHERE LOWER("+collumn+") LIKE '%"+keyword+"%'";
           rs = st.executeQuery(statement);
           int index =0;
           while(rs.next()){
               mhs[index] = new Mahasiswa();
               mhs[index].setNim(rs.getString(1));
               mhs[index].setNama(rs.getString(2));
               mhs[index].setTotalSKS(rs.getInt(3));
               index++;               
           }
       }
       catch (SQLException ex){
           System.out.println(ex.getMessage());
           
       }
       finally{
           try{
               rs.close();
               st.close();
               conn.close();
           }
           catch (SQLException ex){
               System.out.println(ex.getMessage());
           }
       }
   return mhs;
   }

}

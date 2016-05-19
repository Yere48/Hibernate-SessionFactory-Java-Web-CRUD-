
import DAO.MahasiswaDAO;
import entitas.Mahasiswa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class test {
    public static void main(String[] args) {
        MahasiswaDAO mdao=new HibernateUtil().getMahasiswaDAO(); //deklarasi MahasiswaDAO u/ pengambilan method class MahasiswaDAO
        
        Mahasiswa m=new Mahasiswa(); //deklasri Mahasiswa u/ pengambilan getter setter class Mahasiswa
        
        //Insert
        m.setNIM("672013041");
        m.setNama("Yere");
        m.setAlamat("Ampel");
        m.setNoTelp("085867684048 dan 085713060318");
        System.out.println(mdao.insertMahasiswa(m));
   
        //Update
        m = mdao.getByNim("672013041");
        m.setNama("Yeremia Yuliyanto");
        System.out.println(mdao.updateMahasiswa(m));
        
        //Delete
        m.setId(new Long("8"));
        System.out.println(mdao.deleteMahasiswa(m));
        
        //Search
        m = mdao.getByNim("672013041");
        System.out.println("NIM    = "+m.getNIM());
        System.out.println("Nama   = "+m.getNama());
        System.out.println("Alamat = "+m.getAlamat());
        System.out.println("NoTelp = "+m.getNoTelp());
        
        //Select
        for (Mahasiswa mhs : mdao.getAllMahasiswa()) {
            System.out.println("NIM    = "+mhs.getNIM());
            System.out.println("Nama   = "+mhs.getNama());
            System.out.println("Alamat = "+mhs.getAlamat());
            System.out.println("NoTelp = "+mhs.getNoTelp());
            System.out.println("---------------------------------------");
        }
    
    }
}

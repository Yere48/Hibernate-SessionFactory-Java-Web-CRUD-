/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entitas.Mahasiswa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USER
 */
public class MahasiswaDAO {
    public SessionFactory sf1=null; //khusus factory
    public Session s=null; //setiap langkah
    
    public MahasiswaDAO(SessionFactory sf){
        this.sf1=sf;
        this.s=sf1.openSession();
    }
    
    public String insertMahasiswa(Mahasiswa mhs){
        String hasil ="gagal insert";
        try {
            s.beginTransaction();
            s.save(mhs);
            s.getTransaction().commit();
            hasil = "sukses insert";
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            s.close();
            sf1.close();
        }
        return hasil;
    }
    
    public String updateMahasiswa(Mahasiswa mhs){
        String hasil ="gagal update";
        try {
            s.beginTransaction();
            s.update(mhs);
            s.getTransaction().commit();
            hasil = "sukses update";
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            s.close();
            sf1.close();
        }
        return hasil;
    }
    
    public String deleteMahasiswa(Mahasiswa mhs){
        String hasil ="gagal delete";
        try {
            s.beginTransaction();
            s.delete(mhs);
            s.getTransaction().commit();
            hasil = "sukses delete";
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            s.close();
            sf1.close();
        }
        return hasil;
    }
    
    public List<Mahasiswa> getAllMahasiswa() {
        return s.createQuery("from Mahasiswa").list();
    }
 
    public Mahasiswa getByNim(String nim) {
        return (Mahasiswa) s.createQuery("from Mahasiswa m where nim=:nim").setParameter("nim", nim).uniqueResult();
    }
}

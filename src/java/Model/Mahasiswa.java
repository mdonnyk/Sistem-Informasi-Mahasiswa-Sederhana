/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Michael Donny Kusuma
 */
public class Mahasiswa {
    private String nama;
    private String nim;
    private int totalSKS = 0;
    private MataKuliah[] makul;

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    public Mahasiswa() {
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getTotalSKS() {
        for (int i = 0; i < makul.length; i++) {
            setTotalSKS(totalSKS + makul[i].getJumlahSKS());
        }
        return totalSKS;
    }

    public MataKuliah[] getMakul() {
        return makul;
    }

    public void setMakul(MataKuliah[] makul) {
        this.makul = makul;
    }

    public void setTotalSKS(int totalSKS) {
        this.totalSKS = totalSKS;
    }
    
    
    
}

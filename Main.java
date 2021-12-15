package com.pemdas.projekAkhir;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int tahunMasuk, NIP, jumlahAnak, jumlahKendaraan, tmp=0;
    static String jabatan, nama;
    static boolean isRunning=true;
    static String[] jenisJabatan = {"Manajer", "Kepala divisi", "HRD", "Programmer", "Sales", "Pegawai"};

    public static void main(String[] args) {
        do {
            showMenu();
        }while (isRunning);
    }
    static void showMenu() {
        System.out.println("===================== Menu =====================");
        System.out.println("[1] Masukkan data");
        System.out.println("[2] Tampilkan data");
        System.out.println("[3] Keluar");
        System.out.print("Masukkan pilihan : ");
        int pilihanMenu = in.nextInt();
        System.out.print("-------------------------------------------------\n");
        if(pilihanMenu==1){
            System.out.print("Jenis-jenis Jabatan: \n");
            for(int i=0; i<jenisJabatan.length; i++){
                System.out.print((i+1)+". "+jenisJabatan[i]+"\n");
            }
            System.out.println();
        }
        switch (pilihanMenu) {
            case 1: insertData(); break;
            case 2:
                if (tmp <1) {
                    System.out.println("****Data belum dimasukkan****\n");
                }else {
                    showData();
                }
                break;
            case 3:
                isRunning=false;
                break;
            default:
                System.out.println("****Pilihan salah****\n");
                showMenu();
        }
    }
    static void insertData(){
        System.out.print("Masukkan Nama\t\t\t  : ");
        in.nextLine();
        nama = in.nextLine();
        System.out.print("Masukkan NIP\t\t\t  : ");
        NIP = in.nextInt();
        in.nextLine();
        System.out.print("Masukkan Jabatan\t\t  : ");
        jabatan = in.nextLine();
        System.out.print("Masukkan Tahun Masuk\t  : ");
        tahunMasuk = in.nextInt();
        System.out.print("Masukkan Jumlah Anak\t  : ");
        jumlahAnak= in.nextInt();
        System.out.print("Masukkan Jumlah Kendaraan : ");
        jumlahKendaraan = in.nextInt();
        System.out.print("\n");
        tmp++;
    }
    static void showData(){
        System.out.print("");
        System.out.println("Jabatan\t\t: "+jabatan);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("NIP\t\t\t: "+NIP);
        System.out.printf("Total Gaji\t: Rp.%.0f\n" ,totalGaji());
        System.out.println("\n-DETAIL GAJI-");
        System.out.printf("1. Gaji Pokok\t\t\t\t\t    : Rp.%8.0f\n",gajiPokok(jabatan));
        System.out.printf("2. Bonus\t\t\t\t\t\t    : Rp.%8.0f\n", bonus(gajiPokok(jabatan)));
        System.out.printf("3. Tunjangan Keluarga dan Kendaraan : Rp.%8.0f\n" , tunjanganKeluarga());
        System.out.printf("4. Tunjangan Perumahan\t\t\t    : Rp.%8.0f\n" , tunjanganPerumahan(jabatan));
        System.out.printf("5. Potongan Asuransi\t\t\t    : Rp.%8.0f\n",potonganAsuransi(jumlahAnak));
        System.out.print("-------------------------------------------------\n\n");
    }
    static double totalGaji(){
        double total;
        total = (gajiPokok(jabatan)+bonus(gajiPokok(jabatan))+tunjanganKeluarga()+tunjanganPerumahan(jabatan))-potonganAsuransi(jumlahAnak);
        return total;
    }
    static double bonus(double gajiPokok){
        double hasil;
        int tahun = 2021-tahunMasuk;
        if (tahun>=5) tahun = 5;
        hasil = (0.05*gajiPokok)*tahun;
        return hasil;
    }
    static double tunjanganKeluarga(){
        double tunjangan;
        double gaji = gajiPokok(jabatan);
        if (gaji>0) gaji=1;
        else gaji=0;
        tunjangan = (jumlahAnak*300000)+(jumlahKendaraan*100000);
        return tunjangan*gaji;
    }
    static double tunjanganPerumahan(String posisi){
        double tunjanganRumah;
        switch (posisi){
            case"Manajer": tunjanganRumah=5000000; break;
            case"Kepala divisi": tunjanganRumah=4000000; break;
            case"HRD": tunjanganRumah=3500000; break;
            default:tunjanganRumah=0;
        }
        return tunjanganRumah;
    }
    static double potonganAsuransi(int anak){
        double asuransi;
        double gaji = gajiPokok(jabatan);
        if (gaji>0) gaji=1;
        else gaji=0;
        asuransi = (anak+2)*200000;
        return asuransi*gaji;
    }
    static double gajiPokok(String jabatan){
        double gaji;
        switch (jabatan){
            case "Manajer": gaji=12000000; break;
            case "Sales": gaji=6000000; break;
            case "Kepala divisi": gaji=10000000; break;
            case "Pegawai": gaji=5000000; break;
            case "Programmer": gaji=8000000; break;
            case "HRD": gaji=9000000; break;
            default: gaji=0;
        }
        return gaji;
    }
}


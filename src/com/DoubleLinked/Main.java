package com.DoubleLinked;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private Node awal;
    private Node akhir;

    private DataMahasiswa dataMaju;
    private DataMahasiswa dataAkhir;

    Random random = new Random();

    int size = 10; // Jumlah elemen dalam linked list

    private String nama =         "Nama          : ";
    private String tanggalLahir = "Tanggal Lahir : ";
    private String usia =         "Usia          : ";
    private String pendidikan =   "pendidikan    : ";
    private String alamat =       "alamat        : ";

    public Main() {
        this.awal = null;
        this.akhir = null;
        this.dataMaju = null;
        this.dataAkhir = null;
    }

    public static void main(String[] args) {
        Main kelasUtama = new Main();

        System.out.println();
        System.out.println("Selamat Datang Di Program java Double Linked");

        Scanner myObj = new Scanner(System.in);
        System.out.print("Masukkan Nama : ");
        String userName = myObj.nextLine();

        Scanner myObj2 = new Scanner(System.in);
        System.out.print("Masukkan Tanggal Lahir : ");
        String inputTanggalLahir = myObj2.nextLine();

        Scanner myObj3 = new Scanner(System.in);
        System.out.print("Masukkan usia : ");
        String inputUsia = myObj3.nextLine();

        Scanner myObj4 = new Scanner(System.in);
        System.out.print("Masukkan Pendidikan : ");
        String inputPendidikan = myObj4.nextLine();

        Scanner myObj5 = new Scanner(System.in);
        System.out.print("Masukkan alamat : ");
        String inputAlamat = myObj5.nextLine();
        System.out.println();

        System.out.println("Jika Anda ingin menampilkan data secara berurutan masukkan 1");
        System.out.println("Jika Anda ingin menampilkan data dari belakang masukkan 2");
        System.out.println("Jika Anda ingin menampilkan data secara acak masukkan 3");
        System.out.println("Jika Anda ingin menghapus data salah satu data masukkan 4");
        System.out.println();
        Scanner myObj6 = new Scanner(System.in);
        System.out.print("Masukkan Pilihan : ");
        int inputMenu = myObj6.nextInt();
        System.out.println();

        // Menambahkan elemen ke Double Linked List bertipe integer
        kelasUtama.menambahkan(1);
        kelasUtama.menambahkan(2);
        kelasUtama.menambahkan(3);
        kelasUtama.menambahkan(4);
        kelasUtama.menambahkan(5);


        // Menambahkan elemen ke Double Linked List bertipe String
        kelasUtama.menambahkanDataMahasiswa(kelasUtama.nama +" "+userName);
        kelasUtama.menambahkanDataMahasiswa(kelasUtama.tanggalLahir + " "+inputTanggalLahir);
        kelasUtama.menambahkanDataMahasiswa(kelasUtama.usia + " "+ inputUsia);
        kelasUtama.menambahkanDataMahasiswa(kelasUtama.pendidikan + " "+ inputPendidikan);
        kelasUtama.menambahkanDataMahasiswa(kelasUtama.alamat + " "+ inputAlamat);


        if (inputMenu == 1){
            // Menampilkan elemen dari depan
            System.out.println("Maju:");
            kelasUtama.tampilkanMaju();
            kelasUtama.tampilkanDataMaju();
            System.out.println();
        }else if(inputMenu == 2){
            // Menampilkan elemen dari belakang
            System.out.println("Mundur:");
            kelasUtama.tampilkanMundur();
            kelasUtama.tampilkanDataMundur();
        }else if(inputMenu == 3){
            System.out.println("Acak:");
            kelasUtama.tampilkanDataAcak();
        }else if(inputMenu == 4){
            kelasUtama.tampilkanMaju();
            System.out.println();
            System.out.print("Data nomor berapa yang anda ingin hapus : ");
            Scanner myObj7 = new Scanner(System.in);
            int inputHapus = myObj7.nextInt();
          kelasUtama.hapus(inputHapus);
          kelasUtama.tampilkanMaju();
          kelasUtama.tampilkanDataMaju();
        } else{
            System.out.println("Menu yang anda masukkan tidak ada dalam daftar");
        }

    }


    public void menambahkan(int data) {
        Node nodeBaru = new Node(data);
        if (awal == null) {
            awal = nodeBaru;
            akhir = nodeBaru;
        } else {
            akhir.next = nodeBaru;
            nodeBaru.prev = akhir;
            akhir = nodeBaru;
        }
    }

    public void menambahkanDataMahasiswa(String data) {
        DataMahasiswa mahasiswaBaru = new DataMahasiswa(data);
        if (dataMaju == null) {
            dataMaju = mahasiswaBaru;
            dataAkhir = mahasiswaBaru;
        } else {
            dataAkhir.nextMahasiswa = mahasiswaBaru;
            mahasiswaBaru.prevMahasiswa = dataAkhir;
            dataAkhir = mahasiswaBaru;
        }
    }

    public void tampilkanMaju() {
        if (awal == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }
        Node isiData = awal;
        while (isiData != null) {
            System.out.print(isiData.data + " ");
            isiData = isiData.next;
        }
        System.out.println();
    }

    public void tampilkanDataMaju() {
        if (dataMaju == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }
        DataMahasiswa isiData = dataMaju;
        while (isiData != null) {
            System.out.println(isiData.dataBaru + " ");
            isiData = isiData.nextMahasiswa;
        }
        System.out.println();
    }

    public void tampilkanMundur() {
        if (akhir == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }
        Node isiData = akhir;
        while (isiData != null) {
            System.out.print(isiData.data + " ");
            isiData = isiData.prev;
        }
        System.out.println();
    }

    public void tampilkanDataMundur() {
        if (dataAkhir == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }
        DataMahasiswa isiData = dataAkhir;
        while (isiData != null) {
            System.out.println(isiData.dataBaru + " ");
            isiData = isiData.prevMahasiswa;
        }
        System.out.println();
    }

    public void tampilkanDataAcak() {
        if (dataMaju == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }

        DataMahasiswa[] dataMahasiswas = new DataMahasiswa[5]; // Jumlah elemen dalam linked list
        DataMahasiswa current = dataMaju;
        int index = 0;

        while (current != null) {
            dataMahasiswas[index] = current;
            current = current.nextMahasiswa;
            index++;
        }

        Random random = new Random();
        for (int i = dataMahasiswas.length - 1; i >= 0; i--) {
            int randomIndex = random.nextInt(i + 1);

            DataMahasiswa temp = dataMahasiswas[randomIndex];
            dataMahasiswas[randomIndex] = dataMahasiswas[i];
            dataMahasiswas[i] = temp;
        }

        for (DataMahasiswa dataMahasiswa : dataMahasiswas) {
            System.out.println(dataMahasiswa.dataBaru);
        }
        System.out.println();
    }

    public void hapus(int data) {
        if (awal == null) {
            System.out.println("Double Linked List Kosong");
            return;
        }

        // Cek apakah data yang ingin dihapus berada pada elemen pertama
        if (awal.data == data) {
            awal = awal.next;
            if (awal != null) {
                awal.prev = null;
            } else {
                akhir = null;
            }
            return;
        }

        // Cek apakah data yang ingin dihapus berada pada elemen terakhir
        if (akhir.data == data) {
            akhir = akhir.prev;
            if (akhir != null) {
                akhir.next = null;
            } else {
                awal = null;
            }
            return;
        }

        // Cari data yang ingin dihapus di antara elemen pertama dan terakhir
        Node current = awal.next;
        while (current != null) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
            current = current.next;
        }

        System.out.println("Data tidak ditemukan dalam Double Linked List");
    }

}

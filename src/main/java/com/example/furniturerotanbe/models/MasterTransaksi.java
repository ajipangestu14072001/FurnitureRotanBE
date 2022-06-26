package com.example.furniturerotanbe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "master_transaksi")
public class MasterTransaksi {
    @Id
    private String idTransaksi;
    private String idBarang;
    private Long idUser;
    private String typePembayaran;
    private int jumlahBarang;
    private int totalHarga;
    private String pengiriman;
    private String status;
}

package com.example.furniturerotanbe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "master_data")
public class MasterData {
    @Id
    private String id;
    private String namaBarang;
    private Integer stock;
    private Integer harga;
    private String deskripsi;
    private String pathPhoto;
    private String kategori;
    private String lokasi;
}

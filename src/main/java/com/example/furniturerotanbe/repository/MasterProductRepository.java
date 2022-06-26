package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MasterProductRepository extends JpaRepository<MasterData, String> {
    List<MasterData> findByNamaBarangContaining(String name);
    List<MasterData> findByKategoriContaining(String kategori);

}

package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.MasterTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterTransaksiRepository extends JpaRepository<MasterTransaksi, String> {
    List<MasterTransaksi> findByIdUser(Long idUser);

}

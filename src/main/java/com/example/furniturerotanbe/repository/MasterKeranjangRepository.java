package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.Keranjang;
import com.example.furniturerotanbe.models.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterKeranjangRepository extends JpaRepository<Keranjang, Integer> {
    List<Keranjang> findByIdUsersContaining(String idUsers);

}

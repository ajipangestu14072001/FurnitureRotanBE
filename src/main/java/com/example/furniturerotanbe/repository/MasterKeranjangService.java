package com.example.furniturerotanbe.repository;


import com.example.furniturerotanbe.models.Keranjang;
import com.example.furniturerotanbe.models.MasterData;
import org.springframework.stereotype.Component;

@Component
public interface MasterKeranjangService {
    Keranjang Post(Keranjang params);
    String Delete(Integer id);
    Keranjang Get(Integer id);


}

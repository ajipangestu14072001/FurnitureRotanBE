package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.MasterData;
import com.example.furniturerotanbe.models.MasterTransaksi;
import org.springframework.stereotype.Component;

@Component
public interface MasterTransaksiService {
    MasterTransaksi Post(MasterTransaksi params);
}

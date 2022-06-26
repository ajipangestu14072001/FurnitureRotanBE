package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.MasterData;
import org.springframework.stereotype.Component;


@Component
public interface MasterBarangService {
    MasterData Post(MasterData params);

    MasterData Get(String id);

    MasterData Update(MasterData params, String id);

    String Delete(String id);
}

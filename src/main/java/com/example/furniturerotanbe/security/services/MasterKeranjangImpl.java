package com.example.furniturerotanbe.security.services;

import com.example.furniturerotanbe.models.Keranjang;
import com.example.furniturerotanbe.repository.MasterKeranjangRepository;
import com.example.furniturerotanbe.repository.MasterKeranjangService;
import org.springframework.stereotype.Service;

@Service
public class MasterKeranjangImpl implements MasterKeranjangService {
    private final MasterKeranjangRepository masterKeranjangRepository;

    public MasterKeranjangImpl(MasterKeranjangRepository masterKeranjangRepository) {
        this.masterKeranjangRepository = masterKeranjangRepository;
    }

    @Override
    public Keranjang Post(Keranjang params) {
        params.setIdBarang(params.getIdBarang());
        params.setIdUsers(params.getIdUsers());
        params.setNamaBarang(params.getNamaBarang());
        params.setDeskripsi(params.getDeskripsi());
        params.setHarga(params.getHarga());
        params.setPathPhoto(params.getPathPhoto());
        params.setKategori(params.getKategori());
        return masterKeranjangRepository.save(params);
    }

    @Override
    public String Delete(Integer id) {
        masterKeranjangRepository.deleteById(id);
        return "Barang ("+id+")"+ " Telah di Hapus";
    }

    @Override
    public Keranjang Get(Integer id) {
        return masterKeranjangRepository.findById(id).orElse(null);
    }
}

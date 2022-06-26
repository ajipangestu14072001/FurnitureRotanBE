package com.example.furniturerotanbe.controllers;


import com.example.furniturerotanbe.models.MasterData;
import com.example.furniturerotanbe.payload.response.ResponseHandler;
import com.example.furniturerotanbe.repository.MasterBarangService;
import com.example.furniturerotanbe.repository.MasterProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class MasterProductController {

    private final MasterProductRepository masterProductRepository;

    final MasterBarangService masterBarangService;
    private final ResponseHandler responseHandler = new ResponseHandler();


    public MasterProductController(MasterBarangService masterBarangService, MasterProductRepository masterProductRepository) {
        this.masterBarangService = masterBarangService;
        this.masterProductRepository = masterProductRepository;
    }

    @GetMapping("/barang")
    public ResponseEntity<Object> findAll(
            @RequestParam(name = "namaBarang",
                    required = false,
                    defaultValue = "") String namaBarang) {
        try {
            List<MasterData> data;
            if (StringUtils.hasText(namaBarang)) {
                data = masterProductRepository.findByNamaBarangContaining(namaBarang);
            } else {
                data = masterProductRepository.findAll();
            }
            return responseHandler.generateResponse("OK", HttpStatus.OK, data);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }

    }

    @GetMapping(value = "/barang/kategori")
    public ResponseEntity<Object> findKategori(@RequestParam(name = "kategori",
            required = false,
            defaultValue = "") String kategori) {
        try {
            List<MasterData> data;
            data = masterProductRepository.findByKategoriContaining(kategori);
            return responseHandler.generateResponse("OK", HttpStatus.OK, data);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }

    @PostMapping(value = "/barang")
    public ResponseEntity<Object> Post(@RequestBody MasterData params) {
        try {
            MasterData result = masterBarangService.Post(params);
            return responseHandler.generateResponse("OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");

        }
    }

    @PutMapping(value = "/barang/{id}")
    public ResponseEntity<Object> Update(@PathVariable String id, @RequestBody MasterData params) {
        try {
            MasterData result = masterBarangService.Update(params, id);
            return responseHandler.generateResponse("OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }

    @GetMapping(value = "/barang/{id}")
    public ResponseEntity<Object> Get(@PathVariable String id) {
        try {
            MasterData result = masterBarangService.Get(id);
            return responseHandler.generateResponse("OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }

    @DeleteMapping(value = "/barang/{id}")
    public ResponseEntity<Object> Delete(@PathVariable String id) {
        try {
            String result = masterBarangService.Delete(id);
            return responseHandler.generateResponse("OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }
}

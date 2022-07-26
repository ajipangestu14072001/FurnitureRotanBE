package com.example.furniturerotanbe.controllers;

import com.example.furniturerotanbe.models.MasterData;
import com.example.furniturerotanbe.models.MasterTransaksi;
import com.example.furniturerotanbe.payload.response.ResponseHandler;
import com.example.furniturerotanbe.repository.MasterProductRepository;
import com.example.furniturerotanbe.repository.MasterTransaksiRepository;
import com.example.furniturerotanbe.repository.MasterTransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/transactions")
public class MasterTransaksiController {

    final MasterTransaksiRepository masterTransaksiRepository;

    private final ResponseHandler responseHandler = new ResponseHandler();
    final
    MasterTransaksiService masterTransaksiService;


    public MasterTransaksiController(MasterTransaksiService masterTransaksiService, MasterTransaksiRepository masterTransaksiRepository) {
        this.masterTransaksiService = masterTransaksiService;
        this.masterTransaksiRepository = masterTransaksiRepository;
    }

    @PostMapping(value = "/buy")
    public ResponseEntity<Object> buyProduct(@RequestBody MasterTransaksi params) {
        try {
            MasterTransaksi result = masterTransaksiService.Post(params);
            return responseHandler.generateResponse("OK", HttpStatus.OK, result);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }

    @GetMapping(value = "/buy/idUser")
    public ResponseEntity<Object> findKategori(@RequestParam(name = "idUser",
            required = false,
            defaultValue = "") Long idUser) {
        try {
            List<MasterTransaksi> data;
            data = masterTransaksiRepository.findByIdUser(idUser);
            return responseHandler.generateResponse("OK", HttpStatus.OK, data);
        } catch (Exception e) {
            return responseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, "[]");
        }
    }

}

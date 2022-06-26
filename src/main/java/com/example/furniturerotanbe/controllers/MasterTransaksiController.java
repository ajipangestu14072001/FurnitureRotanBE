package com.example.furniturerotanbe.controllers;

import com.example.furniturerotanbe.models.MasterTransaksi;
import com.example.furniturerotanbe.payload.response.ResponseHandler;
import com.example.furniturerotanbe.repository.MasterTransaksiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/transactions")
public class MasterTransaksiController {
    private final ResponseHandler responseHandler = new ResponseHandler();
    final
    MasterTransaksiService masterTransaksiService;


    public MasterTransaksiController(MasterTransaksiService masterTransaksiService) {
        this.masterTransaksiService = masterTransaksiService;
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

}

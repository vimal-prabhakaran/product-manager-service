package com.pesto.productmanagerservice.controller;

import com.pesto.ecomm.common.lib.dto.BuyerProductListResponseDTO;
import com.pesto.ecomm.common.lib.dto.SellerProductInfoDTO;
import com.pesto.ecomm.common.lib.dto.SellerProductListResponseDTO;
import com.pesto.ecomm.common.lib.dto.request.ProductOnboardRequestDTO;
import com.pesto.productmanagerservice.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/api/v1/seller")
@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/catalog")
    public ResponseEntity<SellerProductListResponseDTO> getSellerCatalog(@RequestParam String sellerId,
                                                                         @RequestParam(required = false) Integer pageNo,
                                                                         @RequestParam(required = false) Integer pageSize) {
        SellerProductListResponseDTO responseDTO = sellerService.getSellerCatalog(sellerId, pageNo, pageSize);
        if (Objects.isNull(responseDTO))
            return new ResponseEntity<SellerProductListResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<SellerProductListResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<SellerProductInfoDTO> onboardProduct(@RequestBody ProductOnboardRequestDTO requestDTO) {
        SellerProductInfoDTO responseDTO = sellerService.onboardProduct(requestDTO);
        if (Objects.isNull(responseDTO))
            return new ResponseEntity<SellerProductInfoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<SellerProductInfoDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<SellerProductInfoDTO> getProductOffer(@RequestParam String productId, @RequestParam String sellerId) {
        SellerProductInfoDTO responseDTO = sellerService.getProduct(productId, sellerId);
        if (Objects.isNull(responseDTO))
            return new ResponseEntity<SellerProductInfoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<SellerProductInfoDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<SellerProductInfoDTO> editProduct(@RequestBody ProductOnboardRequestDTO requestDTO) {
        SellerProductInfoDTO responseDTO = sellerService.editProduct(requestDTO);
        if (Objects.isNull(responseDTO))
            return new ResponseEntity<SellerProductInfoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<SellerProductInfoDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<Boolean> deleteProduct(@RequestParam String productId, @RequestParam String sellerId) {
        Boolean response = sellerService.deleteProduct(productId, sellerId);
        if (response)
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}

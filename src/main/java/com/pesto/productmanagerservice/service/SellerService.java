package com.pesto.productmanagerservice.service;

import com.pesto.ecomm.common.lib.dto.SellerProductInfoDTO;
import com.pesto.ecomm.common.lib.dto.SellerProductListResponseDTO;
import com.pesto.ecomm.common.lib.dto.request.ProductOnboardRequestDTO;

public interface SellerService {

    SellerProductListResponseDTO getSellerCatalog(String sellerId, Integer pageNo, Integer pageSize);

    SellerProductInfoDTO onboardProduct(ProductOnboardRequestDTO requestDTO);

    SellerProductInfoDTO editProduct(ProductOnboardRequestDTO requestDTO);

    SellerProductInfoDTO getProduct(String productId, String sellerId);

    Boolean deleteProduct(String productId, String sellerId);

}

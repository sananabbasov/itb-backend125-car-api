package site.backendlesson.car.services;

import site.backendlesson.car.dtos.brand.BrandCreateDto;
import site.backendlesson.car.dtos.brand.BrandDto;
import site.backendlesson.car.dtos.brand.BrandUpdateDto;
import site.backendlesson.car.models.Brand;
import site.backendlesson.car.payloads.ApiPayload;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();
    ApiPayload create(BrandCreateDto brandCreateDto);
    Brand findBrandById(Long id);

    BrandUpdateDto getUpdatedBrand(Long id);
    ApiPayload updateBrand(Long id, BrandUpdateDto brandUpdateDto);

    ApiPayload removeBrand(Long id);
}

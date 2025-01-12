package site.backendlesson.car.controllers;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.backendlesson.car.dtos.brand.BrandCreateDto;
import site.backendlesson.car.dtos.brand.BrandDto;
import site.backendlesson.car.dtos.brand.BrandUpdateDto;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.services.BrandService;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/getall")
    public ResponseEntity<List<BrandDto>> getAll(){
        List<BrandDto> brands = brandService.getAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiPayload> create(@RequestBody BrandCreateDto brandCreateDto){
        ApiPayload response = brandService.create(brandCreateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<BrandUpdateDto> getUpdate(@PathVariable Long id){
        BrandUpdateDto brandUpdateDto = brandService.getUpdatedBrand(id);
        return new ResponseEntity<>(brandUpdateDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiPayload> getUpdate(@PathVariable Long id, @RequestBody BrandUpdateDto brandUpdateDto){
        ApiPayload result = brandService.updateBrand(id,brandUpdateDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ApiPayload> remove(@PathVariable Long id){
        ApiPayload result = brandService.removeBrand(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }




}

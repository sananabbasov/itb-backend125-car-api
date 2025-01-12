package site.backendlesson.car.services.impls;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.backendlesson.car.dtos.brand.BrandCreateDto;
import site.backendlesson.car.dtos.brand.BrandDto;
import site.backendlesson.car.dtos.brand.BrandUpdateDto;
import site.backendlesson.car.exceptions.ResourceNotFoundException;
import site.backendlesson.car.models.Brand;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.repositories.BrandRepository;
import site.backendlesson.car.services.BrandService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BrandDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> brandDtos= brands.stream().map(b -> modelMapper.map(b, BrandDto.class)).collect(Collectors.toList());
        return brandDtos;
    }

    @Override
    public ApiPayload create(BrandCreateDto brandCreateDto) {
     try {
         Brand brand = new Brand();
         brand.setName(brandCreateDto.getName());
         brandRepository.save(brand);
         return new ApiPayload(true, "Brand created successfully.", HttpStatus.CREATED);
     }catch (Exception e){
         return  new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
     }
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", "id", id));
    }

    @Override
    public BrandUpdateDto getUpdatedBrand(Long id) {
        Brand findBrand = brandRepository.findById(id).orElseThrow();
        BrandUpdateDto brand = modelMapper.map(findBrand, BrandUpdateDto.class);
        return brand;
    }

    @Override
    public ApiPayload updateBrand(Long id, BrandUpdateDto brandUpdateDto) {
        try {
            Brand findBrand = brandRepository.findById(id).orElseThrow();
            findBrand.setName(brandUpdateDto.getName());
            brandRepository.save(findBrand);
            return new ApiPayload(true, "Brand updated successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiPayload removeBrand(Long id) {
        try {
            Brand findBrand = brandRepository.findById(id).orElseThrow();
            brandRepository.delete(findBrand);
            return  new ApiPayload(true, "Brand removed successfully.", HttpStatus.OK);
        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

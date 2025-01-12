package site.backendlesson.car.services.impls;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.backendlesson.car.dtos.model.*;
import site.backendlesson.car.exceptions.ResourceNotFoundException;
import site.backendlesson.car.models.Brand;
import site.backendlesson.car.models.Model;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.repositories.ModelRepository;
import site.backendlesson.car.services.BrandService;
import site.backendlesson.car.services.ModelService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;
    private final ModelMapper modelMapper;


    @Override
    public List<ModelDto> getHomeModels() {

        List<Model> findModels = modelRepository.findAll();
        List<ModelDto> models = findModels.stream().map(model -> modelMapper.map(model, ModelDto.class)).collect(Collectors.toList());
        return models;
    }

    @Override
    public ModelDetailDto getModelById(Long id) {
          Model findModel = modelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Model","id",id));
          ModelDetailDto modelDetailDto = modelMapper.map(findModel, ModelDetailDto.class);
          return modelDetailDto;

    }

    @Override
    public ApiPayload createModel(ModelCreateDto modelCreateDto) {
       try {

           Brand brand = brandService.findBrandById(modelCreateDto.getBrandId());
           Model model = new Model();
           model.setName(modelCreateDto.getName());
           model.setBrand(brand);
           modelRepository.save(model);
           return new ApiPayload(true, "Model created successfully",HttpStatus.CREATED);
       }catch (Exception e){
           return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @Override
    public ModelGetUpdateDto getUpdatedModel(Long id) {
        Model findModel = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", id));
        ModelGetUpdateDto modelUpdateDto = modelMapper.map(findModel, ModelGetUpdateDto.class);
        return modelUpdateDto;
    }

    @Override
    public ApiPayload updatedModel(Long id, ModelUpdateDto modelUpdateDto) {
      try {
          Model findModel = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", id));
          Brand brand = brandService.findBrandById(modelUpdateDto.getBrandId());
          findModel.setBrand(brand);
          findModel.setName(modelUpdateDto.getName());
          modelRepository.save(findModel);
          return new ApiPayload(true, "Model updated successfully",HttpStatus.OK);
      }catch (Exception e){
          return new ApiPayload(false, e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }

    @Override
    public ApiPayload removedModel(Long id) {
      try {
          Model findModel = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Model", "id", id));
          modelRepository.delete(findModel);
          return new ApiPayload(true,"Model deleted successfully", HttpStatus.OK);
      }catch (Exception e){
          return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
      }
    }
}

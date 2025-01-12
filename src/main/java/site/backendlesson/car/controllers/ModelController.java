package site.backendlesson.car.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.backendlesson.car.dtos.model.*;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.services.ModelService;

import java.util.List;

@RestController
@RequestMapping("/api/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;


    @GetMapping("/getall")
    public ResponseEntity<List<ModelDto>> getAll(){
        List<ModelDto> models = modelService.getHomeModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ModelDetailDto> get(@PathVariable Long id){
        ModelDetailDto model = modelService.getModelById(id);
        return  new ResponseEntity<>(model, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<ApiPayload> create(@RequestBody  ModelCreateDto modelCreateDto){
        ApiPayload payload = modelService.createModel(modelCreateDto);
        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }


    @GetMapping("/update/{id}")
    public ResponseEntity<ModelGetUpdateDto> update(@PathVariable Long id){
        ModelGetUpdateDto model = modelService.getUpdatedModel(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiPayload> update(@PathVariable Long id, @RequestBody ModelUpdateDto modelUpdateDto){
        ApiPayload model = modelService.updatedModel(id, modelUpdateDto);
        return new ResponseEntity<>(model,model.getHttpStatus());
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ApiPayload> remove(@PathVariable Long id){
        ApiPayload model = modelService.removedModel(id);
        return new ResponseEntity<>(model,model.getHttpStatus());
    }

}

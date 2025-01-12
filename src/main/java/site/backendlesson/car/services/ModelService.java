package site.backendlesson.car.services;

import site.backendlesson.car.dtos.model.*;
import site.backendlesson.car.exceptions.ResourceNotFoundException;
import site.backendlesson.car.payloads.ApiPayload;

import java.util.List;

public interface ModelService {
    List<ModelDto> getHomeModels();
    ModelDetailDto getModelById(Long id) throws ResourceNotFoundException;
    ApiPayload createModel(ModelCreateDto modelCreateDto);
    ModelGetUpdateDto getUpdatedModel(Long id);
    ApiPayload updatedModel(Long id, ModelUpdateDto modelUpdateDto);

    ApiPayload removedModel(Long id);
}

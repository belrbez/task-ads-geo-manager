package com.keeper.managers;

import com.keeper.dto.GeoPointDto;
import com.keeper.entity.GeoPoint;
import com.keeper.service.IGeoPointService;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */

public interface IGeoPointDtoManager<T> extends IModelDtoManager<T, GeoPointDto>, IGeoPointService {

}

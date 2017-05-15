package com.keeper.controllers.restful;

/*
 * Created by @GoodforGod on 28.03.2017.
 */

import com.keeper.model.dao.Route;
import com.keeper.model.dto.RouteDTO;
import com.keeper.service.modelbased.impl.RouteService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.resolvers.ApiResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Default Comment
 */
@RestController
public class RouteRestController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    private final RouteService repoService;

    @Autowired
    public RouteRestController(RouteService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping(value = ApiResolver.ROUTE + "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RouteDTO>> getByUserId(@RequestParam("id") Long userId) {
        return new ResponseEntity<>(ModelTranslator.routesToDTO(repoService.getByUserId(userId).get()), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RouteDTO> get(@RequestParam(value = "id", required = false) Long id,
                                        @RequestParam(value = "userId", required = false) Long userId) {
        return new ResponseEntity<>(ModelTranslator.toDTO(repoService.get(id).orElse(Route.EMPTY)), HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@Valid @RequestBody RouteDTO model, BindingResult result) {
        repoService.updateDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody RouteDTO model, BindingResult result) {
        repoService.saveDTO(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = ApiResolver.ROUTE, method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") Long routeId) {
        repoService.remove(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

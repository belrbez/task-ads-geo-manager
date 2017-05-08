package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.GeoPoint;
import com.keeper.model.dao.Picture;
import com.keeper.model.dao.Route;
import com.keeper.model.dao.User;
import com.keeper.model.dto.*;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.RouteRepository;
import com.keeper.repo.TaskRepository;
import com.keeper.repo.UserRepository;
import com.keeper.service.modelbased.IUserService;
import com.keeper.util.Translator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Default Comment
 */
@Service
public class UserService extends ModelService<User> implements IUserService {

    private final UserRepository repository;
    private final GeoPointRepository geoPointRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public UserService(UserRepository repository,
                       GeoPointRepository geoPointRepository,
                       RouteRepository routeRepository) {
        this.repository = repository;
        this.primeRepository = repository;
        this.geoPointRepository = geoPointRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public User getEmpty() {
        return User.EMPTY;
    }

    @Override
    public boolean existsByEmail(@NotEmpty String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(@NotEmpty String phone) {
        return repository.existsByPhone(phone);
    }

    @Override
    public Optional<User> getAuthorized() {
        return getByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public Optional<User> getByEmail(@NotEmpty String email) {
        return repository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getByPhone(@NotEmpty String phone) {
        return repository.findOneByPhone(phone);
    }

    @Transactional
    @Override
    public Optional<User> saveDTO(UserDTO model) {
        if(model == null) {
            LOGGER.warn("save NULLABLE dto");
            return Optional.empty();
        }

        return super.save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<User> updateDTO(UserDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }
        Optional<User> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            LOGGER.warn("Update model which doesn't exist");
            return Optional.empty();
        }

        return super.save(Translator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<User> removeByEmail(@NotEmpty String email) {
        return repository.removeByEmail(email);
    }

    @Transactional
    @Override
    public Optional<User> removeByPhone(@NotEmpty String phone) {
        return repository.removeByPhone(phone);
    }
}
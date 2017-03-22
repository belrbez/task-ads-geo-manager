package com.keeper.dao.hibernate.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 22.03.2017.
 *
 */

import com.keeper.dao.hibernate.LocationDao;
import com.keeper.entity.Coordinate;
import com.keeper.entity.Location;
import com.keeper.entity.Route;


import java.util.List;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public class LocationDaoHibernate extends GenericDaoHibernate<Location, Integer> implements LocationDao {


    //<editor-fold desc="LocationCRUD">

    public List<Location> createLocation(Integer userId, Location location) {

        return null;
    }

    public List<Location> readLocation(List<Integer> userId) {

        return null;
    }

    public List<Location> updateLocation(Integer userId, Location location) {

        return null;
    }

    public List<Location> deleteLocation(List<Integer> userId) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="CoordinatesCRUD">

    public List<Coordinate> createCoordinates(Integer userId, List<Coordinate> coordinates) {

        return null;
    }

    public List<Coordinate> readCoordinates(Integer userId, List<Integer> coordinateIds) {

        return null;
    }

    public List<Coordinate> updateCoordinates(Integer userId, List<Coordinate> coordinates) {

        return null;
    }

    public List<Coordinate> deleteCoordinates(Integer userId, List<Integer> coordinateIds) {

        return null;
    }
    //</editor-fold>

    //<editor-fold desc="RoutesCRUD">

    public List<Route> createRoutes(Integer userId, List<Route> routes) {

        return null;
    }

    public List<Route> readRoutes(Integer userId, List<Integer> routeIds) {

        return null;
    }

    public List<Route> updateRoute(Integer userId, List<Integer> routeIds) {

        return null;
    }

    public List<Route> deleteRoutes(Integer userId, List<Integer> routeIds) {

        return null;
    }
    //</editor-fold>

}
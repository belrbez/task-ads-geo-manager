package com.keeper.util;

/*
 * Created by GoodforGod on 20.03.2017.
 */

import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.TaskDTO;

/**
 * Computes Marks for Hot Coords and Routes
 */
public class Computer {

    private static double haversine(double lat1, double lng1, double lat2, double lng2) {
        double r = 63711370.; // average radius of the earth in Meters , 6371.1370 in KM
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        return r * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    public static boolean geoInRadius(Double lat1, Double lng1, Double lat2, Double lng2, Integer radius) {
        return (lat1 != null && lng1 != null && lat2 != null && lng2 != null && radius != null)
                && haversine(lat1, lng1, lat2, lng2) <= radius;
    }

//    public static boolean geoInRadius(String lat1, String lng1, SimpleGeoPoint geo, Integer radius) {
//        return !(geo == null || geo.getLatitude() == null || geo.getLongitude() == null || lat1 == null || lng1 == null)
//                && geoInRadius(Double.valueOf(lat1), Double.valueOf(lng1), geo.getLatitude(), geo.getLongitude(), radius);
//    }

    public static boolean geoInRadius(GeoPointDTO geo, TaskDTO task) {
        return geoInRadius(geo.getLatitude(), geo.getLongitude(), task.getGeo().getLatitude(), task.getGeo().getLongitude(), geo.getRadius());
    }
}

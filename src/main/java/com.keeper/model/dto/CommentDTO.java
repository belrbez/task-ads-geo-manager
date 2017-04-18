package com.keeper.model.dto;

import com.keeper.model.SimpleGeoPoint;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

/**
 * Default Comment
 */
public class CommentDTO {

    public static final CommentDTO EMPTY = new CommentDTO();


    private Long taskId;
    private Long userId;
    private LocalDateTime createDate;
    private LocalDateTime lastModifyDate;
    private String message;
    private String longtitude;
    private String latitude;

    public CommentDTO(){}

    public CommentDTO(Long taskId, Long userId, Timestamp createDate, Timestamp lastModifyDate,
                      String message, SimpleGeoPoint geoPoint){
        this.taskId     = taskId;
        this.userId     = userId;
        this.createDate = createDate.toLocalDateTime();
        this.lastModifyDate = lastModifyDate.toLocalDateTime();
        this.message    = message;
        this.longtitude = geoPoint.getLongtitude();
        this.latitude   = geoPoint.getLatitude();
    }

    public static CommentDTO getEMPTY() {
        return EMPTY;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public String getMessage() {
        return message;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getLatitude() {
        return latitude;
    }
}

package com.keeper.model.test;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.model.states.UserState;
import com.keeper.model.types.UserType;

import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class UserTestDTO {

    public static final UserTestDTO EMPTY = new UserTestDTO((long)UserType.EMPTY.getValue(),UserType.EMPTY);

    private final Long  id;
    private UserState state;
    private UserType    type;
    private String      name;
    private String      maskEmail;
    private String      maskPhone;
    private String      about;
    private Boolean     isNotified;
    private LocalDateTime muteStart;
    private LocalDateTime muteEnd;

    private UserTestDTO() {
        this.id         = (long) UserType.UNKNOWN.getValue();
        this.type       = UserType.UNKNOWN;
        this.name       = "";
        this.maskEmail  = "";
        this.maskPhone  = "";
        this.about      = "";
        this.isNotified = false;
        this.muteStart  = LocalDateTime.MIN;
        this.muteEnd    = LocalDateTime.MAX;
    }

    private UserTestDTO(Long id, UserType type) {
        super();
        this.type = type;
        this.id = id;
    }

    public UserTestDTO(Long id, UserType type, UserState state, String name, String email,
                       String phone, String about, boolean isNotified,
                       LocalDateTime muteStart, LocalDateTime muteEnd) {
        this.id         = (id != null) ? id : UserType.UNKNOWN.getValue();
        this.state      = state != null ? state : UserState.UNKNOWN;
        this.type       = type != null ? type : UserType.UNKNOWN;
        this.name       = name;
        this.maskEmail  = email; //Converter.maskEmail(email);
        this.maskPhone  = phone; //Converter.maskStr(phone);
        this.about      = about;
        this.isNotified = isNotified;
        this.muteStart  = muteStart;
        this.muteEnd    = muteEnd;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public UserState getState() {
        return state;
    }

    public UserType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getMaskEmail() {
        return maskEmail;
    }

    public String getMaskPhone() {
        return maskPhone;
    }

    public String getAbout() {
        return about;
    }

    public Boolean getNotified() {
        return isNotified;
    }

    public LocalDateTime getMuteStart() {
        return muteStart;
    }

    public LocalDateTime getMuteEnd() {
        return muteEnd;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTestDTO that = (UserTestDTO) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
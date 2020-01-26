package com.hk.paperview.account.domain.user;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String userName;

    public SessionUser(User user) {
        this.userName = user.getName();
    }
}

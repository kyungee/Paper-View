package com.hk.paperview.account.domain.user;

import com.hk.paperview.account.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table (name = "user_info")
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column (name = "user_id",length = 15, nullable = false)
    private String id;

    @Column (name = "user_pw", length = 15, nullable = false)
    private String password;

    @Column (name = "user_name", length = 10, nullable = false)
    private String name;

    @Builder
    public User(String id, String password, String name) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

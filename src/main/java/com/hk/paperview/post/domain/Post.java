package com.hk.paperview.post.domain;

import com.hk.paperview.account.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column (nullable = false, length = 30)
    private String title;

    @Column (nullable = false)
    private String content;

    @ManyToOne (targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_IDX")
    private User user;

    @Builder
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}

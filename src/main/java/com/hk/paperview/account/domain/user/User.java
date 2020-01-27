package com.hk.paperview.account.domain.user;

import com.hk.paperview.account.domain.BaseTimeEntity;
import com.hk.paperview.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_IDX",columnDefinition = "serial")
    private Long idx;

    @Column (name = "USER_ID",length = 15, nullable = false)
    private String id;

    @Column (name = "USER_PW", length = 15, nullable = false)
    private String password;

    @Column (name = "USER_NAME", length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> postsList = new ArrayList<Post>();

    @Builder
    public User(String id, String password, String name) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void addPost(Post post) {
        this.postsList.add(post);
    }
}

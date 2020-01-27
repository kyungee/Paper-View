package com.hk.paperview.post.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}

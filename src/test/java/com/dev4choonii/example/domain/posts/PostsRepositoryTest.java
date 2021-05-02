package com.dev4choonii.example.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void postsRepository_저장_테스트() {
        String title = "제목";
        String contnet = "본문";
        String author = "dev4choonii";

        postsRepository.save(Posts.builder().title(title).content(contnet).author(author).build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(contnet);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }

}
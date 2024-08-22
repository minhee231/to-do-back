package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post creatPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow( () -> new RuntimeException(""));
        post.setTitle(postDetails.getTitle());
        post.setCompleted(postDetails.getCompleted());
        return  postRepository.save(post);
    }

    public void deletePosts(Long id) {
        Post post = postRepository.findById(id).orElseThrow( () -> new RuntimeException("post not found"));
        postRepository.deleteById(id);
    }
}

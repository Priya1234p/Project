package com.demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demoapp.entity.Comment;
import com.demoapp.entity.Post;
import com.demoapp.repository.CommentRepository;
import com.demoapp.repository.PostRepository;

@SpringBootTest
class DemoappApplicationTests {
	

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	@Test
	void savePost() {
		Post post = new Post();
		post.setTitle("Hello");
		postRepository.save(post);
	}
	
	@Test
	void addCommentToExistingPost() {
		 Long postId = 1L; // Replace with actual saved post ID
		 Post post = postRepository.findById(postId).orElseThrow();
		 
		 Comment comment = new Comment();
		 comment.setContent("This is a comment after the post was created");
		 
		 // fk is set 
		    post.getComments().add(comment);

		    // Save the post again — due to CascadeType.ALL, comment will be saved
		    postRepository.save(post);
	}

	public CommentRepository getCommentRepository() {
		return commentRepository;
	}

	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

}

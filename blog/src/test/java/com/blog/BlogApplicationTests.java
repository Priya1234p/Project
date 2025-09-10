package com.blog;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.entity.Bus;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.Profile;
import com.blog.entity.Stop;
import com.blog.entity.User;
import com.blog.repository.BusRepository;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;
import com.blog.repository.StopRepository;
import com.blog.repository.UserRepository;


@SpringBootTest
class BlogApplicationTests {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	 @Autowired
	    private BusRepository busRepo;

	    @Autowired
	    private StopRepository stopRepo;
	    
	    @Autowired
	    private UserRepository userRepo;


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
        comment.setPost(post);
        
        commentRepository.save(comment);
	}
	
	@Test
	public void getPostAndItsComments() {
	    Post post = postRepository.findById(1L).orElseThrow();
	    List<Comment> comments = post.getComments(); // Works because session is open
	    for (Comment c:comments) {
	    	System.out.println(c.getId());
			System.out.println(c.getContent());
		}
	}
	
	 @Test
	    public void createBusWithStops() {
	        Stop s1 = new Stop();
	        s1.setStopName("Majestic");

	        Stop s2 = new Stop();
	        s2.setStopName("BTM Layout");

	        Stop s3 = new Stop();
	        s3.setStopName("Electronic City");

	        stopRepo.saveAll(Arrays.asList(s1, s2, s3));

	        Bus b1 = new Bus();
	        b1.setBusName("Bus 101");
	        b1.setStops(Arrays.asList(s1, s2));

	        Bus b2 = new Bus();
	        b2.setBusName("Bus 202");
	        b2.setStops(Arrays.asList(s2, s3));

	        busRepo.saveAll(Arrays.asList(b1, b2));
	    }
	 
	 @Test
	 public void createUser() {
		 Profile profile = new Profile();
	        profile.setBio("Full Stack Developer");

	        User user = new User();
	        user.setName("Pankaj");
	        user.setProfile(profile);

	        userRepo.save(user);
		 
	 }


}

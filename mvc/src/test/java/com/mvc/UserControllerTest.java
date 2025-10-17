package com.mvc;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mvc.controller.UserController;
import com.mvc.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	//All working because these are contructor dependency
	// Create MockObject
	@Mock
    private UserService mockService;

	//Inject mockObject
    @InjectMocks
    private UserController controller;
	
    
    //Positive senario
    @Test
    void testGetUserName_Found() {
        // Mock the service
      //  UserService mockService = mock(UserService.class);
        when(mockService.getUserName(1)).thenReturn("Alice");
        
        // Call method & assert (here it compare expected and actual value)
        assertEquals("Alice", controller.getUserName(1));
	
        // Verify interaction
        verify(mockService, times(1)).getUserName(1);

}
    
    @Test
    void testGetUserName_NotFound() {
    	when(mockService.getUserName(2)).thenReturn("unknown User");
    	assertEquals("unknown User", controller.getUserName(2));
    	
    }
}

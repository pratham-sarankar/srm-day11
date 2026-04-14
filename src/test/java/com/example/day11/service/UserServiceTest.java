package com.example.day11.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.day11.model.User;
import com.example.day11.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldAuthenticateUser() {
        // Arrange
        User user = new User("john@gmail.com", "password");
        when(repository.findByEmail("john@gmail.com")).thenReturn(user);

        // Act
        User authenticatedUser = userService.authenticate("john@gmail.com", "password");

        // Assert
        assertNotNull(authenticatedUser);
        assertEquals(user, authenticatedUser);
        verify(repository).findByEmail("john@gmail.com");
    }

    @Test
    void shouldGetUserById() {
        // Arrange
        Optional<User> user = Optional.of(new User());
        when(repository.findById(1)).thenReturn(user);

        // Act
        Optional<User> result = userService.getUserById(1);

        // Assert
        assertEquals(user, result);
        verify(repository).findById(1);
    }

    @Test
    void shouldReturnAllUsers() {
        // Arrange
        List<User> users = List.of(new User());
        when(repository.findAll()).thenReturn(users);

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertEquals(users, result);
        verify(repository).findAll();
    }
}

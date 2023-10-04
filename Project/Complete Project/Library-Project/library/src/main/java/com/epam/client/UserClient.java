package com.epam.client;

import com.epam.dto.BookDTO;
import com.epam.dto.UserDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-app")
@LoadBalancerClient(name = "user-app")
public interface UserClient {

	@GetMapping("/users")
	public List<UserDTO> getUsers();

	@GetMapping("/users/{username}")
	public UserDTO getUser(@PathVariable("username") String userName);

	@PostMapping("/users")
	public UserDTO addUser(UserDTO userDto);

	@DeleteMapping("/users/{username}")
	public void deleteUser(@PathVariable("username") String userName);

	@PutMapping("/users")
	public BookDTO updateUser(@RequestBody BookDTO bookDto);

}

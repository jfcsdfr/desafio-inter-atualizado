package com.formed.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.formed.entities.DigitoUnico;
import com.formed.entities.User;
import com.formed.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@org.junit.jupiter.api.Test
	public void buscarListaDeUsuarios() throws Exception {
		
		List<User> result = new ArrayList<>();
		result.add(new User(1L, "nome", "email", null));
		Mockito.when(userService.listUser()).thenReturn(result);
		this.mockMvc.perform(get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@org.junit.jupiter.api.Test
	public void buscarDeUsuarios() throws Exception {
		
		User user = new User(1L, "nome", "email", null);
		Mockito.when(userService.user(1)).thenReturn(user);
		this.mockMvc.perform(get("/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@org.junit.jupiter.api.Test
	public void buscarListaDeDigitosUnicos() throws Exception {
		
		List<DigitoUnico> result = new ArrayList<>();
		DigitoUnico digitoUnico = new DigitoUnico(1L, "TESTE", 1, 1, null);
		result.add(digitoUnico);
		Mockito.when(userService.listOfdigits(1L)).thenReturn(result);
		this.mockMvc.perform(get("/users/1/digitos")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@org.junit.jupiter.api.Test
	public void salvarUsuarios() throws Exception {
		
		User user = new User(1L, "name", "email", null);
		
		RequestBuilder request = MockMvcRequestBuilders
	            .post("/users")
	            .accept(MediaType.APPLICATION_JSON)
	            .content("{\"id\":1,\"name\":\"name\",\"email\":\"email\",\"digitoUnico\":null}")
	            .contentType(MediaType.APPLICATION_JSON);
		
		Mockito.when(userService.saveUser(user)).thenReturn(user);
		this.mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@org.junit.jupiter.api.Test
	public void atualizarUsuarios() throws Exception {
		
		User user = new User(1L, "name", "email", null);
		
		RequestBuilder request = MockMvcRequestBuilders
	            .put("/users/1")
	            .accept(MediaType.APPLICATION_JSON)
	            .content("{\"id\":1,\"name\":\"name\",\"email\":\"email\",\"digitoUnico\":null}")
	            .contentType(MediaType.APPLICATION_JSON);
		
		Mockito.when(userService.updateUser(user, 1L)).thenReturn(user);
		this.mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@org.junit.jupiter.api.Test
	public void deleteUsuarios() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.delete("/users/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isNoContent());
		}
}

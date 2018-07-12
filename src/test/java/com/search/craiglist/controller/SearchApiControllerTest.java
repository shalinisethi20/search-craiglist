package com.search.craiglist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.search.craiglist.domain.model.Content;
import com.search.craiglist.services.SearchService;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchApiController.class)
public class SearchApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SearchService searchService;

	@Test
	public void givenSearchRoom_whenDataExists_thenReturnJsonArray() throws Exception {

		Content content = new Content();
		content.setDate(new Date());
		content.setTitle("room1");

		when(searchService.getResultByType("room")).thenReturn(Arrays.asList(content));

		mvc.perform(get("/api/v1/search/room").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].title", is("room1")));
	}

}
package com.search.craiglist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.search.craiglist.domain.model.Content;
import com.search.craiglist.domain.model.SearchType;
import com.search.craiglist.services.SearchService;
import com.search.craiglist.util.*;

@RestController
public class SearchApiController {

	private static Logger logger = LoggerFactory.getLogger(SearchApiController.class);

	@Autowired
	private SearchService searchService;

	@GetMapping(Constants.GET_ALL_SEARCH_TYPE)
	public List<SearchType> getAllSearchType() {
		logger.info("rest call received");
		return searchService.getAllSearchType();
	}

	@GetMapping(Constants.GET_SEARCH_BY_TYPE)
	public List<Content> getSearchResultBytype(@PathVariable String type) {
		logger.info("rest call received for type {}", type);
		return searchService.getResultByType(type);
	}
}

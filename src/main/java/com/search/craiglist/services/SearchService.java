package com.search.craiglist.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.search.craiglist.domain.SearchGateway;
import com.search.craiglist.domain.model.Content;
import com.search.craiglist.domain.model.SearchType;

@Service
public class SearchService {

	private SearchGateway craiglistSearchGateway;

	public SearchService(SearchGateway craiglistSearchGateway) {
		this.craiglistSearchGateway = Objects.requireNonNull(craiglistSearchGateway, "SearchGateway is null");
	}

	List<SearchType> allSearchType = new ArrayList<SearchType>(Arrays.asList(new SearchType("appartment", "Appartment"),
			new SearchType("house", "Independent house"), new SearchType("room", "Room")));

	/**
	 * this method will return the search types. We can populate this in a drop
	 * down to UI if required. As of now we have hard coded somevalues
	 * 
	 */
	public List<SearchType> getAllSearchType() {
		return allSearchType;
	}

	/**
	 * 
	 * @param type
	 * @return list of content based on search type It will try maximum of two
	 *         times if service is not responding
	 */

	@Retryable(maxAttempts = 2, backoff = @Backoff(delay = 5000))
	public List<Content> getResultByType(String type) {
		List<Content> content = craiglistSearchGateway.getRssFeedResults(type);
		return content;
	}

}

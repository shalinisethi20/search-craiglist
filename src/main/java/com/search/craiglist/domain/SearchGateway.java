package com.search.craiglist.domain;

import java.util.List;

import com.search.craiglist.domain.model.Content;

public interface SearchGateway {

	List<Content> getRssFeedResults(String type);	

}

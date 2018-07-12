package com.search.craiglist.gateway;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.search.craiglist.domain.SearchGateway;
import com.search.craiglist.domain.model.Content;
import com.search.craiglist.util.Constants;

public class CraiglistSearchGateway implements SearchGateway {

	private static Logger logger = LoggerFactory.getLogger(CraiglistSearchGateway.class);

	private final String baseUrl;

	public CraiglistSearchGateway(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<Content> getRssFeedResults(String type) {
		logger.info("getRssFeedResults is called");
		List<Content> feedList = new ArrayList<Content>();
		try {
			try (XmlReader reader = new XmlReader(new URL(baseUrl + type))) {
				SyndFeed syndFeed = new SyndFeedInput().build(reader);
				feedList = getListContent(syndFeed);
			}
		} catch (Exception e) {
			logger.info("exception is thrown" + e.getMessage());
			throw new RuntimeException(e);
		}
		logger.info("getRssFeedResults returned");
		return feedList;
	}

	private List<Content> getListContent(SyndFeed syndFeed) {
		List<Content> feedList = new ArrayList<Content>();

		for (SyndEntry entry : syndFeed.getEntries()) {
			feedList.add(new Content(
					entry.getTitle().substring(Constants.INT_ZERO, entry.getTitle().indexOf(Constants.XML_CHARACTERS)),
					entry.getPublishedDate()));

		}

		return feedList;
	}
}

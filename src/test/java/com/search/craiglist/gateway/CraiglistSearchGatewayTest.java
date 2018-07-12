package com.search.craiglist.gateway;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.search.craiglist.domain.model.Content;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CraiglistSearchGatewayTest {

	CraiglistSearchGateway craiglistSearchGateway;

	/*TODO Need to write unit test case for this class*/
	@Test
	public void test() {
		SyndFeed syndFeed = new SyndFeedImpl();
		SyndEntry syndEntryOne = new SyndEntryImpl();
		syndEntryOne.setTitle("Title 1");
		syndEntryOne.setPublishedDate(new Date());

		SyndEntry syndEntryTwo = new SyndEntryImpl();
		syndEntryTwo.setTitle("Title 2");
		syndEntryTwo.setPublishedDate(new Date());

		syndFeed.setEntries(Arrays.asList(syndEntryOne, syndEntryTwo));

		List<Content> listResponseValue = craiglistSearchGateway.getRssFeedResults("room");
	}

}

package com.crud.tasks.trello.client;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrelloConfigTest {

    @Mock
    TrelloConfig trelloConfig;

    @Test
    public void testGetTrelloApiEndpoint() {
        //given
        String trelloApiEndpoint = "https://api.trello.com/1";
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn(trelloApiEndpoint);
        //when
        String excpectApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        //then
        Assert.assertEquals(trelloApiEndpoint, excpectApiEndpoint);
    }

    @Test
    public void testGetTrelloAppKey() {
        //given
        String trelloAppKey = "d4788c903375cc439780b5948e3fe132";
        when(trelloConfig.getTrelloAppKey()).thenReturn(trelloAppKey);
        //when
        String excpectTrelloAppKey = trelloConfig.getTrelloAppKey();
        //then
        Assert.assertEquals(trelloAppKey, excpectTrelloAppKey);
    }

    @Test
    public void testGetTrelloAppToken() {
        //given
        String trelloAppToken = "afdc1bb9833234b9f417de0101fbccbf24f941063cf64174f26fa614be0fb8cf";
        when(trelloConfig.getTrelloToken()).thenReturn(trelloAppToken);
        //when
        String excpectTrelloAppToken = trelloConfig.getTrelloToken();
        //then
        Assert.assertEquals(trelloAppToken, excpectTrelloAppToken);
    }

    @Test
    public void testGetTrelloUsername() {
        //given
        String trelloUsername = "dzyndzello@eims.pl";
        when(trelloConfig.getTrelloUsername()).thenReturn(trelloUsername);
        //when
        String excpectTrelloUsername = trelloConfig.getTrelloUsername();
        //then
        Assert.assertEquals(trelloUsername, excpectTrelloUsername);
    }
}
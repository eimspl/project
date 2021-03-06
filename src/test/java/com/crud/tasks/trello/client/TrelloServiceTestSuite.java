package com.crud.tasks.trello.client;

import com.crud.tasks.trello.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    TrelloConfig trelloConfig;

    @Mock
    SimpleEmailService emailService;

    @Mock
    AdminConfig adminConfig;

    @Test
    public void testCreateTrelloCard() {

        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test Description",
                "top",
                "test_id");

        //when
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto(
                "1",
                "Test task",
                "http://test.com",
                new Badges(1,
                        new AttachmentsByType(
                                new Trello(11, 22)
                        ))
        );

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        //then

        CreatedTrelloCardDto newCard = trelloService.createTrelloCard(trelloCardDto);
        assertNotNull(newCard);
        assertEquals("1", newCard.getId());
        assertEquals("Test task", newCard.getName());
        assertEquals(1, newCard.getBadges().getVotes());
        assertEquals(11, newCard.getBadges().getAttachments().getTrello().getBoard());
        assertEquals(22, newCard.getBadges().getAttachments().getTrello().getCard());
    }

    @Test
    public void testFetchTrelloBoards() {
        //given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1", "test", trelloListsDto));

        //when

        when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardsDto);
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();
        //then

        Assert.assertNotNull(fetchedTrelloBoards);
        Assert.assertEquals(1, fetchedTrelloBoards.size());
        Assert.assertEquals("1", fetchedTrelloBoards.get(0).getId());
        Assert.assertEquals("test", fetchedTrelloBoards.get(0).getName());
        Assert.assertEquals(trelloListsDto, fetchedTrelloBoards.get(0).getLists());
    }
}
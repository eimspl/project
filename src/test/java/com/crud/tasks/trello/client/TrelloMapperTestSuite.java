package com.crud.tasks.trello.client;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoardDto() {
        //given
        TrelloList trelloList1 = new TrelloList("123", "List123", false);
        TrelloList trelloList2 = new TrelloList("321", "List321", true);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);
        TrelloBoard trelloBoard = new TrelloBoard("111", "Board111", trelloLists);
        List<TrelloBoard> trelloBoardList = Arrays.asList(trelloBoard);

        //when
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //then
        Assert.assertNotEquals(trelloBoardList,trelloBoardDtoList);
        Assert.assertEquals(1, trelloBoardDtoList.size());
        Assert.assertEquals(2, trelloBoardDtoList.get(0).getLists().size());
        Assert.assertEquals("123", trelloBoardDtoList.get(0).getLists().get(0).getId());
        Assert.assertEquals("List123", trelloBoardDtoList.get(0).getLists().get(0).getName());
        Assert.assertTrue(trelloBoardDtoList.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void testMapToBoard() {
        TrelloListDto trelloListDto1 = new TrelloListDto("666", "List666", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("999", "List999", false);
        List<TrelloListDto> trelloLists = Arrays.asList(trelloListDto1, trelloListDto2);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("111", "Board1111", trelloLists);
        List<TrelloBoardDto> trelloBoardListDto = Arrays.asList(trelloBoardDto);

        //when
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardListDto);

        //then
        Assert.assertNotEquals(trelloBoardListDto,trelloBoardList);
        Assert.assertEquals(1, trelloBoardList.size());
        Assert.assertEquals(2, trelloBoardList.get(0).getLists().size());
        Assert.assertEquals("666", trelloBoardList.get(0).getLists().get(0).getId());
        Assert.assertEquals("List666", trelloBoardList.get(0).getLists().get(0).getName());
        Assert.assertFalse(trelloBoardList.get(0).getLists().get(1).isClosed());
    }

    @Test
    public void testMapToList() {
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("333", "List333", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("4444", "List444", false);
        List<TrelloListDto> trelloListsDto = Arrays.asList(trelloListDto1, trelloListDto2);

        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDto);

        //then
        Assert.assertNotEquals(trelloListsDto,trelloLists);
        Assert.assertEquals(2, trelloLists.size());
        Assert.assertEquals("333", trelloLists.get(0).getId());
        Assert.assertEquals("List444", trelloLists.get(1).getName());
        Assert.assertFalse(trelloLists.get(1).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //given
        TrelloList trelloList1 = new TrelloList("333", "List111", true);
        TrelloList trelloList2 = new TrelloList("444", "List222", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);

        //when
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        //then
        Assert.assertNotEquals(trelloLists,trelloListsDto);
        Assert.assertEquals(2, trelloListsDto.size());
        Assert.assertEquals("333", trelloListsDto.get(0).getId());
        Assert.assertEquals("List222", trelloListsDto.get(1).getName());
        Assert.assertFalse(trelloListsDto.get(1).isClosed());
    }

    @Test
    public void testMapToCard() {
        //given
        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card111", "description1111", "111", "111");

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto1);

        //then
        Assert.assertEquals("Card111", trelloCard.getName());
        Assert.assertEquals("description1111", trelloCard.getDescription());
        Assert.assertEquals("111", trelloCard.getPos());
        Assert.assertEquals("111", trelloCard.getListId());
    }

    @Test
    public void testMapToCardDto() {
        //given
        TrelloCard trelloCard1 = new TrelloCard("Card1", "description1", "1", "11");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard1);

        //then
        Assert.assertEquals("Card1", trelloCardDto.getName());
        Assert.assertEquals("description1", trelloCardDto.getDescription());
        Assert.assertEquals("1", trelloCardDto.getPos());
        Assert.assertEquals("11", trelloCardDto.getListId());
    }
}
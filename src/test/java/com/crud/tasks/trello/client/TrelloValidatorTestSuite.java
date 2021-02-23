package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {

    @Test
    public void testValidateTrelloBoards() {
        //given
        TrelloValidator trelloValidator = new TrelloValidator();

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "list1", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "board2", trelloLists));

        //when
        List<TrelloBoard> excpectedTrelloBoardList = trelloValidator.validateTrelloBoards(trelloBoards);

        //then
        assertNotNull(excpectedTrelloBoardList);
        assertEquals(1, excpectedTrelloBoardList.size());
        excpectedTrelloBoardList.forEach(trelloBoard -> {
            assertEquals("2", trelloBoard.getId());
            assertEquals("board2", trelloBoard.getName());
        });
    }
}
package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Game;
import ru.netology.repository.NotRegisteredException;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game = new Game();
    private List<Player> players = new ArrayList<>();
    Player first = new Player(101, "John Wick", 89);
    Player second = new Player(32, "Leon", 77);
    Player third = new Player(15, "Willy Wonka", 15);
    Player fourth = new Player(67, "Razor Ramon", 48);
    Player fifth = new Player(7, "Godzilla", 98);
    Player sixth = new Player(29, "Harley Quinn", 66);
    Player seventh = new Player(1, "Pikachu", 35);
    Player eighth = new Player(44, "Black widow", 77);
    Player ninth = new Player(51, "Hannibal Lector", 80);
    Player tenth = new Player(11, "Zlatan Ibrahimovic", 73);

    @BeforeEach
    void insertData() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
        game.register(fifth);
        game.register(sixth);
        game.register(seventh);
        game.register(eighth);
        game.register(ninth);
        game.register(tenth);
    }

    @Test
    public void findByNameTest() {
        int actual = game.findByName("Leon");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinFirstTest() {
        int actual = game.round("John Wick", "Pikachu");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondTest() {
        int actual = game.round("Willy Wonka", "Zlatan Ibrahimovic");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    //
    @Test
    public void shouldNoWinnersTest() {
        int actual = game.round("Leon", "Black widow");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNoRegisteredFirstTest() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Mike Wazowski", "Harley Quinn");
        });
    }

    @Test
    public void shouldNoRegisteredSecondTest() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Godzilla", "T-Rex");
        });
    }
}


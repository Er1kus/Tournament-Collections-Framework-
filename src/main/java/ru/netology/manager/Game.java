package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.repository.NotRegisteredException;

import java.util.HashMap;
import java.util.Map;


public class Game {
    protected Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int findByName(String name){
        Player player = players.get(name);
        return player.getStrength();
    }

        public int round (String name1, String name2){

            Player player1 = players.get(name1);
            Player player2 = players.get(name2);


            if (player1 == null) {
                throw new NotRegisteredException("Player with this name: " + name1 + " is not registered");
            }
            if (player2 == null) {
                throw new NotRegisteredException("Player with this name: " + name2 + " is not registered");
            }


            int strength1 = player1.getStrength();
            int strength2 = player2.getStrength();

            if (strength1 == strength2) {
                return 0;
            }
            if (strength1 > strength2) {
                return 1;
            }
            return 2;
        }
    }

package es.art83.ticTacToe.controllers;

import es.art83.ticTacToe.models.entities.PlayerEntity;

public interface LoginController {

    boolean login(PlayerEntity player);

    boolean register(PlayerEntity player);
    
    boolean logged();

}

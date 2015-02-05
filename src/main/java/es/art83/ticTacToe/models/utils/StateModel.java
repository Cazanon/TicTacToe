package es.art83.ticTacToe.models.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum StateModel {
    INITIAL, CLOSED_GAME, OPENED_GAME, FINAL;
}

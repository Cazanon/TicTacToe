package es.art83.ticTacToe.models.daos.jpa;

import es.art83.ticTacToe.models.daos.PlayerDAO;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class PlayerDAOJPATestMain {
    public static void main(String[] args) {
        PlayerDAO dao = DAOJPAFactory.getFactory().getPlayerDAO();
        PlayerEntity p1 = new PlayerEntity("u1", "pu1");
        dao.create(p1);
        PlayerEntity p2 = new PlayerEntity("u2", "pu2");
        dao.create(p2);
        PlayerEntity p3 = new PlayerEntity("u3", "pu3");
        dao.create(p3);
        dao.deleteByID(p3.getUser());
        p1.setPassword("otra");
        dao.update(p1);
        System.out.println("Read u1: " + dao.read("u1"));
        System.out.println("findAll: " + dao.findAll());
    }
}

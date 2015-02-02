package es.art83.ticTacToe.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import es.art83.ticTacToe.models.utils.ColorModel;

@Entity
public class GameEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Embedded
    private TurnEntity turnEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardEntity boardEntity;

    
    @ManyToOne
    private PlayerEntity playerEntity;

    public GameEntity(String name, PlayerEntity playerEntity, BoardEntity boardEntity, TurnEntity turnEntity) {
        this.setName(name);
        this.setPlayerEntity(playerEntity);
        this.setBoardEntity(boardEntity);
        this.setTurnEntity(turnEntity);
    }

    public GameEntity(String name, PlayerEntity playerEntity) {
        this(name, playerEntity, new BoardEntity(), new TurnEntity());
    }

    public GameEntity(PlayerEntity playerEntity) {
        this(null, playerEntity);
    }

    public GameEntity() {
        this(null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }

    private void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    private TurnEntity getTurnEntity() {
        return this.turnEntity;
    }

    private void setTurnEntity(TurnEntity turnEntity) {
        this.turnEntity = turnEntity;
    }

    private void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    //TODO que devuelva ColorModel del que gana
    public boolean gameOver() {
        return this.boardEntity.existTicTacToe(this.turnEntity.getColorChanged());
    }

    public List<PieceEntity> allPieces() {
        return this.boardEntity.getPieces();
    }

    //TODO esto no es correcto del todo, siempre daría un ganador! Se arregla con lo que devuelva existTitTacToe
    public ColorModel winner() {
        return this.turnEntity.getColorChanged();
    }

    public ColorModel turnColor() {
        return this.turnEntity.getColor();
    }

    public boolean hasAllPieces() {
        return this.boardEntity.hasAllPieces();
    }

    public List<CoordinateEntity> validSourceCoordinates() {
        return this.boardEntity.coordinates(this.turnColor());
    }

    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.boardEntity.validDestinationCoordinates();
    } 

    public void placePiece(CoordinateEntity coordinate) {
        this.boardEntity.put(new PieceEntity(this.getTurnEntity().getColor(), coordinate));
        this.turnEntity.change();
    }

    public PieceEntity deletePiece(CoordinateEntity source) {
        return this.boardEntity.remove(source);
    }

    public void update(GameEntity gameEntity) {
        this.turnEntity.update(gameEntity.turnEntity);
        this.boardEntity.update(gameEntity.boardEntity);
        this.setName(gameEntity.getName());
        this.setPlayerEntity(gameEntity.getPlayerEntity());
    }

    @Override
    public String toString() {
        return "GameEntity[" + id + ":" + name + "," + playerEntity + "," + turnEntity + "," + boardEntity + "]";
    }

    @Override
    public GameEntity clone() {
        BoardEntity boardClone = this.boardEntity.clone();
        TurnEntity turnClone = this.turnEntity.clone();
        return new GameEntity(this.name, this.playerEntity, boardClone, turnClone);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((playerEntity == null) ? 0 : playerEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        GameEntity other = (GameEntity) obj;
        boolean result;

        if (this.name == null) {
            result = other.name == null;
        } else {
            result = other.name != null && this.name.equals(other.name);
        }
        return result && this.playerEntity.equals(other.playerEntity);
    }


}

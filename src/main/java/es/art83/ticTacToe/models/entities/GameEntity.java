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
    private TurnEntity turn;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardEntity board;

    @ManyToOne
    private PlayerEntity player;

    public GameEntity(String name, PlayerEntity player, BoardEntity board, TurnEntity turn) {
        this.setName(name);
        this.setPlayer(player);
        this.setBoardEntity(board);
        this.setTurn(turn);
    }

    public GameEntity(String name, PlayerEntity player) {
        this(name, player, new BoardEntity(), new TurnEntity());
    }

    public GameEntity(PlayerEntity player) {
        this(null, player);
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

    public PlayerEntity getPlayer() {
        return this.player;
    }

    private void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    private TurnEntity getTurn() {
        return this.turn;
    }

    private void setTurn(TurnEntity turn) {
        this.turn = turn;
    }

    private void setBoardEntity(BoardEntity board) {
        this.board = board;
    }

    //TODO que devuelva ColorModel del que gana
    public boolean gameOver() {
        return this.board.existTicTacToe(this.turn.getColorChanged());
    }

    public List<PieceEntity> pieces() {
        return this.board.getPieces();
    }

    public List<PieceEntity> allPieces() {
        return this.board.getPieces();
    }

    //TODO esto no es correcto del todo, siempre daría un ganador! Se arregla con lo que devuelva existTitTacToe
    public ColorModel winner() {
        return this.turn.getColorChanged();
    }

    public ColorModel turnColor() {
        return this.turn.getColor();
    }

    public boolean hasAllPieces() {
        return this.board.hasAllPieces();
    }

    public List<CoordinateEntity> validSourceCoordinates() {
        return this.board.coordinates(this.turnColor());
    }

    public List<CoordinateEntity> validDestinationCoordinates() {
        return this.board.validDestinationCoordinates();
    } 

    public void placePiece(CoordinateEntity coordinate) {
        this.board.put(new PieceEntity(this.getTurn().getColor(), coordinate));
        this.turn.change();
    }

    public void placePiece(CoordinateEntity source, CoordinateEntity destination) {
        this.board.remove(source);
        this.placePiece(destination);
    }

    //TODO hay que quitarlo, solo se usa en pruebas... NNNNNNOOOOOOOOO
    //Se utiliza mediante recursos!!!!
    public PieceEntity deletePiece(CoordinateEntity source) {
        return this.board.remove(source);
    }

    public void update(GameEntity game) {
        this.turn.update(game.turn);
        this.board.update(game.board);
        this.setName(game.getName());
        this.setPlayer(game.getPlayer());
    }

    @Override
    public String toString() {
        return "GameEntity[" + id + ":" + name + "," + player + "," + turn + "," + board + "]";
    }

    @Override
    public GameEntity clone() {
        BoardEntity boardClone = this.board.clone();
        TurnEntity turnClone = this.turn.clone();
        return new GameEntity(this.name, this.player, boardClone, turnClone);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((player == null) ? 0 : player.hashCode());
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
        return result && this.player.equals(other.player);
    }


}

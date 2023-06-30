import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void Player1Wins() {
        Player john = new Player(1, "John", 10);
        Player jack = new Player(2, "Jack", 20);
        Game game = new Game();
        game.register(john);
        game.register(jack);
        int expected = 1;
        int actual = game.round("Jack", "John");
    }

    @Test
    public void Player2Wins() {
        Player john = new Player(1, "John", 10);
        Player jack = new Player(2, "Jack", 20);
        Game game = new Game();
        game.register(john);
        game.register(jack);
        int expected = 2;
        int actual = game.round("John", "Jack");
    }

    @Test
    public void Draw() {
        Player john = new Player(1, "John", 10);
        Player jack = new Player(2, "Jack", 10);
        Game game = new Game();
        game.register(john);
        game.register(jack);
        int expected = 0;
        int actual = game.round("John", "Jack");
    }

    @Test
    public void Player1NotRegistered() {
        Player john = new Player(1, "John", 10);
        Player jack = new Player(2, "Jack", 10);

        Game game = new Game();
        game.register(john);
        game.register(jack);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Max", "Jack");
        });
    }

    @Test
    public void Player2NotRegistered() {
        Player john = new Player(1, "John", 10);
        Player jack = new Player(2, "Jack", 10);

        Game game = new Game();
        game.register(john);
        game.register(jack);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jack", "Max");
        });
    }
}
package fht.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player('x');
    }

    @Test
    public void testGetMarker() {
        assertEquals('x', player.getMarker());
    }
}
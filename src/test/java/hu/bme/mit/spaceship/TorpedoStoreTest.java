package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach 
    void init() {
        this.store = new TorpedoStore(10,0.0);
    }

    @Test 
    void fire_Succes() {
        boolean result = store.fire(1);
        assertTrue(result);
        assertEquals(9, store.getTorpedoCount());
    }

    @Test 
    void fire_MoreThanAvailable_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> store.fire(11));
    }

    @Test 
    void fire_FaliureRate_ReturnsFalse() {
        TorpedoStore faultyStore = new TorpedoStore(10, 1.0);
        boolean result = faultyStore.fire(1);
        assertFalse(result);
    }

    @Test 
    void isEmpty_TrueWhenZeroTorpedos() {
        TorpedoStore emptyStore = new TorpedoStore(0, 0.0);
        assertTrue(emptyStore.isEmpty());
        assertEquals(0, emptyStore.getTorpedoCount());
    }
}

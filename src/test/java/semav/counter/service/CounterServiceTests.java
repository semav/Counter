package semav.counter.service;

import org.junit.jupiter.api.Test;
import semav.counter.entity.Counter;
import semav.counter.service.impl.InMemoryCounterService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterServiceTests {

    private final String name = "counter name";

    private InMemoryCounterService counterService = new InMemoryCounterService();

    @Test
    void create_shouldCreateCounter() {
        Counter actual = counterService.create(name);

        assertEquals(name, actual.getName());
        assertEquals(0, actual.getValue());
    }

    @Test
    void create_shouldThrowExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> counterService.create(null));
    }

    @Test
    void increment_shouldIncrementCounter() {
        Counter counter = counterService.create(name);
        Counter incrementedCounter = counterService.increment(name);

        assertEquals(counter.getValue() + 1, incrementedCounter.getValue());
    }

    @Test
    void increment_shouldThrowExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> counterService.increment(null));
    }

    @Test
    void get_shouldReturnCounter() {
        Counter expected = counterService.create(name);
        Counter actual = counterService.get(name);

        assertEquals(expected, actual);
    }

    @Test
    void get_shouldReturnNullWhenCounterDoesntExist() {
        Counter actual = counterService.get(name);

        assertNull(actual);
    }

    @Test
    void get_shouldThrowExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> counterService.get(null));
    }

    @Test
    void getAll_shouldReturnAllCounters() {
        Counter expected = counterService.create(name);
        List<Counter> counters = counterService.getAll();

        assertIterableEquals(Collections.singletonList(expected), counters);
    }

    @Test
    void getSum_shouldReturnSum() {
        counterService.create("first");
        counterService.create("second");

        counterService.increment("first");
        counterService.increment("second");

        int actual = counterService.getSum();

        assertEquals(2, actual);
    }

    @Test
    void delete_shouldDelete() {
        counterService.create(name);
        counterService.delete(name);

        Counter actual = counterService.get(name);

        assertNull(actual);
    }

    @Test
    void delete_shouldThrowExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class, () -> counterService.delete(null));
    }
}

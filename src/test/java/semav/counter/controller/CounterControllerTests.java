package semav.counter.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import semav.counter.dto.CounterDto;
import semav.counter.entity.Counter;
import semav.counter.mapper.CounterMapper;
import semav.counter.service.CounterService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CounterControllerTests {

    @InjectMocks
    private CounterController counterController;

    @Mock
    private CounterService counterService;

    @Mock
    private CounterMapper counterMapper;

    private final String name = "counter name";

    @Test
    void create_shouldCreateCounter() {
        Counter counter = new Counter();
        CounterDto expected = new CounterDto();

        when(counterService.create(name)).thenReturn(counter);
        when(counterMapper.map(counter)).thenReturn(expected);

        CounterDto actual = counterController.create(name);

        assertEquals(expected, actual);
    }

    @Test
    void increment_shouldIncrementCounter() {
        Counter counter = new Counter();
        CounterDto expected = new CounterDto();

        when(counterService.increment(name)).thenReturn(counter);
        when(counterMapper.map(counter)).thenReturn(expected);

        CounterDto actual = counterController.increment(name);

        assertEquals(expected, actual);
    }

    @Test
    void increment_shouldThrowExceptionWhenCounterDoesntExist() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> counterController.increment(name));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    void get_shouldReturnCounter() {
        Counter counter = new Counter();
        CounterDto expected = new CounterDto();

        when(counterService.get(name)).thenReturn(counter);
        when(counterMapper.map(counter)).thenReturn(expected);

        CounterDto actual = counterController.get(name);

        assertEquals(expected, actual);
    }

    @Test
    void get_shouldThrowExceptionWhenCounterDoesntExist() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> counterController.get(name));
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    void getAll_shouldReturnAllCounters() {
        List<Counter> counters = Collections.singletonList(new Counter());
        List<CounterDto> expected = Collections.singletonList(new CounterDto());

        when(counterService.getAll()).thenReturn(counters);
        when(counterMapper.map(counters)).thenReturn(expected);

        List<CounterDto> actual = counterController.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void getSum_shouldReturnSum() {
        int expected = 1;

        when(counterService.getSum()).thenReturn(expected);

        int actual = counterController.getSum();

        assertEquals(expected, actual);
    }

    @Test
    void delete_shouldDeleteCounter() {
        counterController.delete(name);

        verify(counterService).delete(name);
    }
}

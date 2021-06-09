package semav.counter.mapper;

import org.junit.jupiter.api.Test;
import semav.counter.dto.CounterDto;
import semav.counter.entity.Counter;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CounterMapperTests {

    private static final String NAME = "name";
    private static final int VALUE = 100;
    private CounterMapperImpl mapper = new CounterMapperImpl();

    @Test
    void shouldMapToCounterDto() {
        Counter counter = new Counter(NAME, VALUE);
        CounterDto expected = new CounterDto(NAME, VALUE);

        CounterDto actual = mapper.map(counter);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMapToCounterDtoList() {
        Counter counter = new Counter(NAME, VALUE);
        List<CounterDto> expected = Collections.singletonList(new CounterDto(NAME, VALUE));

        List<CounterDto> actual = mapper.map(Collections.singletonList(counter));

        assertIterableEquals(expected, actual);
    }

}

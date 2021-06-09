package semav.counter.mapper;

import org.mapstruct.Mapper;
import semav.counter.dto.CounterDto;
import semav.counter.entity.Counter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CounterMapper {
    CounterDto map(Counter counter);
    List<CounterDto> map(List<Counter> counter);
}

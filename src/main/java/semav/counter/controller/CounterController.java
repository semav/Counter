package semav.counter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import semav.counter.dto.CounterDto;
import semav.counter.entity.Counter;
import semav.counter.mapper.CounterMapper;
import semav.counter.service.CounterService;

import java.util.List;

@RestController()
@RequestMapping("/api/counter")
@Tag(name = "Счетчик", description = "Содержит операции для работы со счетчиками")
public class CounterController {

    private final CounterService counterService;
    private final CounterMapper counterMapper;

    public CounterController(CounterService counterService, CounterMapper counterMapper) {
        this.counterService = counterService;
        this.counterMapper = counterMapper;
    }

    @PostMapping("/{name}")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Создание нового счетчика")
    public CounterDto create(
            @Parameter(description = "Имя нового счетчика")
            @PathVariable String name) {

        Counter counter = counterService.create(name);
        return counterMapper.map(counter);
    }

    @PostMapping("/{name}/increment")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Инкремент значения счетчика по имени")
    public CounterDto increment(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {

        Counter counter = counterService.increment(name);
        return counterMapper.map(counter);
    }

    @GetMapping("/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение счетчика по имени")
    public CounterDto get(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {

        Counter counter = counterService.get(name);
        return counterMapper.map(counter);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение списка всех счетчиков")
    public List<CounterDto> getAll() {

        List<Counter> counters = counterService.getAll();
        return counterMapper.map(counters);
    }

    @GetMapping("/sum")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение суммы всех счетчиков")
    public int getSum() {

        return counterService.getSum();
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление счетчика по имени")
    public void delete(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {

        counterService.delete(name);
    }
}

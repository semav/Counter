package semav.counter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import semav.counter.dto.CounterDto;

import java.util.Collections;
import java.util.List;


@RestController()
@RequestMapping("/api/counter")
@Tag(name="Счетчик", description="Содержит операции для работы со счетчиками")
public class CounterController {
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Создание нового счетчика")
    public CounterDto create(
            @Parameter(description = "Новый счетчик")
            @RequestBody CounterDto counter) {
        return null;
    }

    @PostMapping("/{name}/increment")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Инкремент значения счетчика по имени")
    public CounterDto increment(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {
        return null;
    }

    @GetMapping("/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение счетчика по имени")
    public CounterDto get(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {
        return null;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение списка всех счетчиков")
    public List<CounterDto> getList() {
        return Collections.emptyList();
    }

    @GetMapping("/sum")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Получение суммы всех счетчиков")
    public int getSum() {
        return 0;
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление счетчика по имени")
    public CounterDto delete(
            @Parameter(description = "Имя счетчика")
            @PathVariable String name) {
        return null;
    }

}

package semav.counter.controller;

import org.springframework.web.bind.annotation.*;
import semav.counter.dto.CounterDto;

import java.util.Collections;
import java.util.List;

/**
 * Rest-контроллер для работы со счетчиками
 */
@RestController("counter")
public class CounterController {
    @PostMapping
    public CounterDto create(CounterDto counter) {
        return null;
    }

    @PostMapping("/{name}/increment")
    public CounterDto increment(@PathVariable String name) {
        return null;
    }

    @GetMapping("/{name}")
    public CounterDto get(@PathVariable String name) {
        return null;
    }

    @GetMapping
    public List<CounterDto> getList() {
        return Collections.emptyList();
    }

    @GetMapping("/sum")
    public int getSum() {
        return 0;
    }

    @DeleteMapping("/{name}")
    public CounterDto delete(@PathVariable String name) {
        return null;
    }

}

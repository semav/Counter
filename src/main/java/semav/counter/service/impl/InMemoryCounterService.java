package semav.counter.service.impl;

import org.springframework.stereotype.Service;
import semav.counter.entity.Counter;
import semav.counter.service.CounterService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для работы со счетчиками, который хранит состояние в памяти
 */
@Service
public class InMemoryCounterService implements CounterService {

    private final ConcurrentHashMap<String, Integer> counters = new ConcurrentHashMap<>();

    private static final Integer DEFAULT_VALUE = 0;

    @Override
    public Counter create(String name) {
        Integer value = counters.computeIfAbsent(name, k -> DEFAULT_VALUE);
        return Optional
                .of(value)
                .map(v -> new Counter(name, v))
                .orElse(null);
    }

    @Override
    public Counter increment(String name) {
        Integer value = counters.computeIfPresent(name, (k, v) -> v + 1);

        return Optional
                .ofNullable(value)
                .map(v -> new Counter(name, v))
                .orElse(null);
    }

    @Override
    public Counter get(String name) {
        Integer value = counters.get(name);

        return Optional
                .ofNullable(value)
                .map(v -> new Counter(name, v))
                .orElse(null);
    }

    @Override
    public List<Counter> getAll() {
        return counters.entrySet()
                .stream()
                .map(e -> new Counter(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public int getSum() {
        return counters.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    @Override
    public void delete(String name) {
        counters.remove(name);
    }
}

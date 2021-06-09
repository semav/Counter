package semav.counter.service.impl;

import org.springframework.stereotype.Service;
import semav.counter.entity.Counter;
import semav.counter.service.CounterService;

import java.util.List;

@Service
public class InMemoryCounterService implements CounterService {

    @Override
    public Counter create(String name) {
        return null;
    }

    @Override
    public Counter increment(String name) {
        return null;
    }

    @Override
    public Counter get(String name) {
        return null;
    }

    @Override
    public List<Counter> getAll() {
        return null;
    }

    @Override
    public int getSum() {
        return 0;
    }

    @Override
    public void delete(String name) {

    }
}

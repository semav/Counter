package semav.counter.service;

import semav.counter.entity.Counter;

import java.util.List;

public interface CounterService {
    Counter create(String name);

    Counter increment(String name);

    Counter get(String name);

    List<Counter> getAll();

    int getSum();

    void delete(String name);
}

package semav.counter.service;

import semav.counter.entity.Counter;

import java.util.List;

/**
 * Интрефейс сервиса для работы со счетчиками
 */
public interface CounterService {

    /**
     * Создание нового счетчика
     * @param name Имя нового счетчика
     * @return Новый счетчик
     */
    Counter create(String name);

    /**
     * Инкремент счетчика
     * @param name Имя счетчика
     * @return Счетчик с обновленным значением
     */
    Counter increment(String name);

    /**
     *
     * @param name Имя счетчика
     * @return Счетчик
     */
    Counter get(String name);

    /**
     * Получение всех счетчиков
     * @return Список счетчиков
     */
    List<Counter> getAll();

    /**
     * Получение суммы всех счетчиков
     * @return Сумма всех счетчиков
     */
    int getSum();

    /**
     * Удаление счетчика
     * @param name Имя счетчика
     */
    void delete(String name);
}

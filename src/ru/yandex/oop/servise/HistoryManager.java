package ru.yandex.oop.servise;
import ru.yandex.oop.model.Task;
import java.util.List;

public interface HistoryManager {

    void add(Task task);

    List<Task> getHistory();
}

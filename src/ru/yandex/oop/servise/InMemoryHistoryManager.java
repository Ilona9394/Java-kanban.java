package ru.yandex.oop.servise;

import ru.yandex.oop.model.Task;

import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private LinkedList<Task> historyTask = new LinkedList<>();

    @Override
    public void add(Task task) {
        historyTask.addLast(task);
        if (historyTask.size() > 10) {
            historyTask.removeFirst();
        }
    }

    @Override
    public List<Task> getHistory() {
        return historyTask;
    }
}

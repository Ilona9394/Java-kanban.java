package ru.yandex.oop;

import ru.yandex.oop.model.*;
import ru.yandex.oop.servise.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        TaskManager manager = Managers.getDefault(); // создание обьектов для работы с задачами через класс Managers
        HistoryManager historyManager = Managers.getDefaultHistory();// создание обьектов для работы с просмотреными
        // задачами через класс Managers

        Task task1 = new Task("Task 1", "Собрать коробки", Status.NEW);
        manager.createTask(task1);
        Epic epic1 = new Epic("Epic1", "Найти коробки", Status.NEW);
        manager.createEpic(epic1);
        Subtask subtask1 = new Subtask("subStack1", "Придти на склад", Status.NEW, epic1);
        Subtask subtask2 = new Subtask("subStack2", "Начать поиск", Status.NEW, epic1);
        manager.createSubStack(subtask1);
        manager.createSubStack(subtask2);
        epic1.addSubTasks(subtask1);
        epic1.addSubTasks(subtask2);

        Task task2 = new Task("Task 2", "Отметить Новый Год", Status.NEW);
        manager.createTask(task2);
        Epic epic2 = new Epic("Epic2", "Организовать праздник", Status.NEW);
        Subtask subtask3 = new Subtask("subStack1", "Позвать подруг", Status.NEW, epic2);
        Subtask subtask4 = new Subtask("subStack2", "Купить шампанское", Status.NEW, epic2);
        manager.createSubStack(subtask3);
        manager.createSubStack(subtask4);
        epic2.addSubTasks(subtask3);
        epic2.addSubTasks(subtask4);

        System.out.println("Эпик: " + epic1);
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("Лист эпика до: " + manager.getEpicSubtask(epic1));
        manager.updateStatusSubStack(subtask1, epic1); // обновляем статус подзадачи и вызываем метод обновление эпика
        System.out.println("Лист эпика после: " + manager.getEpicSubtask(epic1));
        manager.updateStatusTask(task1);

        System.out.println(epic1);
        System.out.println(subtask1);
        System.out.println(subtask2);

        System.out.println("////////////////////////////////////");
        System.out.println(manager.getBigTask());
        System.out.println(manager.getEpicTask());
        System.out.println(manager.getSubTask());
        System.out.println("////////////////////////////////////");
        manager.removeAllTask();
        manager.removeAllEpic();
        manager.removeAllSub();
        System.out.println(manager.getBigTask());
        System.out.println(manager.getEpicTask());
        System.out.println(manager.getSubTask());

        manager.getTaskHistory(task1.getId());  // просматриваем задачи,епики, подзадачи
        manager.getTaskHistory(task2.getId());
        manager.getEpicHistory(epic1.getId());
        manager.getEpicHistory(epic2.getId());
        manager.getSubTaskHistory(subtask1.getId());
        manager.getSubTaskHistory(subtask2.getId());
        manager.getSubTaskHistory(subtask3.getId());
        manager.getSubTaskHistory(subtask4.getId());

    }
}

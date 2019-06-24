package ch.fhnw.hogwarts.toDoRest.service;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import ch.fhnw.hogwarts.toDoRest.repository.ToDoRepository;
import ch.fhnw.hogwarts.toDoRest.request.ToDoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return this.toDoRepository.getToDoList();
    }

    public void saveToDo(ToDoRequest toDoRequest) {
        ToDo toDo = new ToDo(toDoRequest.getCreator(), toDoRequest.getText());
        this.toDoRepository.addToDo(toDo);
    }

    public boolean find(String id) {
        return this.toDoRepository.find(id);
    }

    public void deleteToDo(String id) {
        this.toDoRepository.delete(id);
    }
}

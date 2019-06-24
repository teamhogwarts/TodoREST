package ch.fhnw.hogwarts.toDoRest.service;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import ch.fhnw.hogwarts.toDoRest.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return this.toDoRepository.getToDoList();
    }
}

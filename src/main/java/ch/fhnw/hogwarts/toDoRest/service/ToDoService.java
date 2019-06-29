package ch.fhnw.hogwarts.toDoRest.service;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import ch.fhnw.hogwarts.toDoRest.repository.ToDoRepository;
import ch.fhnw.hogwarts.toDoRest.request.ToDoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return this.toDoRepository.getToDoList();
    }

    public void createToDo(ToDoRequest toDoRequest) {
        ToDo toDo = new ToDo(toDoRequest.getCreator(), toDoRequest.getText());
        this.toDoRepository.addToDo(toDo);
    }

    public ToDo getToDoById(String id){
       return this.toDoRepository.getToDoList()
               .stream()
               .filter(findToDo -> findToDo.getId().equals(id))
               .findAny()
               .orElse(null);
    }

    public boolean find(String id) {
        return this.toDoRepository.find(id);
    }

    public void deleteToDo(String id) {
        this.toDoRepository.delete(id);
    }
}

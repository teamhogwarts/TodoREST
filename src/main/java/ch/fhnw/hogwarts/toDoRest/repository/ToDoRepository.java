package ch.fhnw.hogwarts.toDoRest.repository;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository {

    private List<ToDo> toDoList;

    public ToDoRepository(){
        this.toDoList = new ArrayList<>();
        this.toDoList.add(new ToDo(1, "Pascal",  "first ToDo", false));
        this.toDoList.add(new ToDo(2, "Benjamin",  "second ToDo", false));
        this.toDoList.add(new ToDo(3, "Nadia",  "third ToDo", false));
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void addToDo(ToDo toDo){
        this.toDoList.add(toDo);
    }

    public void delete(int toDoId){
        this.toDoList = this.toDoList.stream()
                .filter(toDo -> toDo.getId() != toDoId)
                .collect(Collectors.toList());
    }
}

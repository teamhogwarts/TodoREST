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
        this.toDoList.add(new ToDo( "Pascal",  "first ToDo"));
        this.toDoList.add(new ToDo( "Benjamin",  "second ToDo"));
        this.toDoList.add(new ToDo( "Nadia",  "third ToDo"));
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void addToDo(ToDo toDo){
        this.toDoList.add(toDo);
    }

    public void delete(String toDoId){
        this.toDoList = this.toDoList.stream()
                .filter(toDo -> !toDo.getId().equals(toDoId))
                .collect(Collectors.toList());
    }

    public boolean find(String id){
        return this.toDoList.stream()
                .anyMatch(toDo -> toDo.getId().equals(id));
    }
}

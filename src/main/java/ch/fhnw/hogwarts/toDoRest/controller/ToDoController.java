package ch.fhnw.hogwarts.toDoRest.controller;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import ch.fhnw.hogwarts.toDoRest.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toDo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/toDos")
    public ResponseEntity<List<ToDo>> getAllTodos(){

        List<ToDo> toDoList = this.toDoService.getAll();

        if(toDoList == null || toDoList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }
}

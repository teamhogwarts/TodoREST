package ch.fhnw.hogwarts.toDoRest.controller;

import ch.fhnw.hogwarts.toDoRest.model.ToDo;
import ch.fhnw.hogwarts.toDoRest.request.ToDoRequest;
import ch.fhnw.hogwarts.toDoRest.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/toDo")
@CrossOrigin("*")
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

    @PostMapping("/create")
    public ResponseEntity createToDo(@RequestBody @Valid ToDoRequest toDoRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.PRECONDITION_FAILED);
        }

        this.toDoService.saveToDo(toDoRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable String id){
        ToDo toDo = this.toDoService.getToDoById(id);
        if (toDo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDo, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteToDo(@PathVariable String id){
        if (!toDoService.find(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        this.toDoService.deleteToDo(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

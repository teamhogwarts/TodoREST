package ch.fhnw.hogwarts.toDoRest.model;

import java.util.UUID;

public class ToDo {

    private String id;
    private String creator;
    private String text;
    private boolean isDone;

    public ToDo(String creator, String text) {
        this.id = UUID.randomUUID().toString();
        this.creator = creator;
        this.text = text;
        this.isDone = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}

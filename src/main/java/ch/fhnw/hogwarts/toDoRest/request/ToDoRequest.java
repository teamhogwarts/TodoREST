package ch.fhnw.hogwarts.toDoRest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ToDoRequest {

    @Size(min=3, max=10)
    private String creator;

    @NotNull
    private String text;

    @NotNull
    private boolean isDone;

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

package ch.fhnw.hogwarts.toDoRest.model;

public class ToDo {

    private int id;
    private String creator;
    private String text;
    private boolean isDone;

    public ToDo(int id, String creator, String text, boolean isDone) {
        this.id = id;
        this.creator = creator;
        this.text = text;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

package sevices;

import entities.TodoList;
import repositories.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private  final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList[] getTodoList() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        if(todo.isEmpty() || todo.isBlank()){
            System.out.println("Masukin todo dengan benar");
            return;
        }
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
    }

    @Override
    public Boolean removeTodoList(final Integer number) {
        return removeTodoList(number);
    }

    @Override
    public Boolean editTodoList(Integer number, String todo) {
        TodoList todoList = new TodoList();
        todoList.setId(number);
        todoList.setTodo(todo);
        return  todoListRepository.edit(todoList);
    }
}

import Views.TodoListTerminalView;
import Views.TodoListView;
import config.Database;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbimpl;
import sevices.TodoListService;
import sevices.TodoListServiceImpl;

public  class Main {
    public static void main(String[] args) {
        Database database = new Database("my_database", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbimpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}
package ex4;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private DAO dao = new DAO();
    public void insert() {
        List<Result> list = new ArrayList<>();
        list.add(new Result(1, 5));
        list.add(new Result(2, 7.3));
        dao.insertBatch(list);
    }
}
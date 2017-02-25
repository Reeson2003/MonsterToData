package temp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.monster_to_data.dao.MonsterDao;
import ru.reeson2003.monster_to_data.exceptions.BaseIsEmtyException;
import ru.reeson2003.monster_to_data.exceptions.IllegalFieldException;
import ru.reeson2003.monster_to_data.model.Monster;

import java.util.List;

/**
 * Created by reeson on 24.02.17.
 */
public class DaoTest {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config/beans.xml");
        MonsterDao dao = (MonsterDao) context.getBean("dao");
        Monster goblin = new Monster(1, "Goblin", 5, 30, 15);
        Monster ant = new Monster(2, "Ant", 3, 25, 10);

        try {
            dao.insert(goblin);
            dao.insert(ant);
        } catch (IllegalFieldException e) {
            e.printStackTrace();
            System.err.println("Error");
        }
        Monster m1 = null;
        try {
            m1 = dao.getById(1);
        } catch (IllegalFieldException e) {
            e.printStackTrace();
        }
        List<Monster> monsters = null;
        try {
            monsters = dao.getByName("Ant");
        } catch (IllegalFieldException e) {
            e.printStackTrace();
        }
        List<Monster> monsters1 = null;
        try {
            monsters1 = dao.getAll();
        } catch (BaseIsEmtyException e) {
            e.printStackTrace();
        }
        System.out.println(m1);
        System.out.println(monsters);
        System.out.println(monsters);
    }
}

package ru.reeson2003.monster_to_data.dao.demo_dao;

import ru.reeson2003.monster_to_data.dao.MonsterDao;
import ru.reeson2003.monster_to_data.exceptions.BaseIsEmtyException;
import ru.reeson2003.monster_to_data.exceptions.IllegalFieldException;
import ru.reeson2003.monster_to_data.model.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by reeson on 23.02.17.
 */
public class DemoDao implements MonsterDao {
    private Map<Integer, Monster> monsterMap = new ConcurrentHashMap<Integer, Monster>();

    public DemoDao() {
        Monster goblin = new Monster(1,"Goblin", 5, 200, 150);
        Monster ant = new Monster(2, "Ant", 4, 180, 100);
        Monster wolf = new Monster(3, "Wolf", 4, 150, 150);
        Monster orc = new Monster(4, "Orc", 7, 280, 200);
        Monster toad = new Monster(5, "Toad", 5, 220, 120);
        monsterMap.put(goblin.getId(), goblin);
        monsterMap.put(ant.getId(), ant);
        monsterMap.put(wolf.getId(), wolf);
        monsterMap.put(orc.getId(), orc);
        monsterMap.put(toad.getId(), toad);
    }

    public void insert(Monster monster) throws IllegalFieldException {
        if (monsterMap.put(monster.getId(), monster) != null)
            throw new IllegalFieldException("ID", Integer.toString(monster.getId()));
    }

    public List<Monster> getByName(String name) throws IllegalFieldException {
        List<Monster> result = new ArrayList<Monster>();
        for (Map.Entry<Integer, Monster> e : monsterMap.entrySet()) {
            if(e.getValue().getName().equals(name))
                result.add(e.getValue());
        }
        if(result.isEmpty())
            throw new IllegalFieldException("NAME", name);
        return result;
    }

    public Monster getById(int id) throws IllegalFieldException {
        Monster result = monsterMap.get(id);
        if (result == null)
            throw new IllegalFieldException("ID", Integer.toString(id));
        return result;
    }

    public List<Monster> getAll() throws BaseIsEmtyException {
        List<Monster> result = new ArrayList<Monster>(monsterMap.values());
        if (result.isEmpty())
            throw new BaseIsEmtyException();
        return result;
    }

    public void removeById(int id) throws IllegalFieldException {
        if (!monsterMap.containsKey(id))
            throw new IllegalFieldException("ID", Integer.toString(id));
        else
            monsterMap.remove(id);
    }
}

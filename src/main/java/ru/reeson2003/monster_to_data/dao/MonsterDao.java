package ru.reeson2003.monster_to_data.dao;

import ru.reeson2003.monster_to_data.exceptions.BaseIsEmtyException;
import ru.reeson2003.monster_to_data.exceptions.IllegalFieldException;
import ru.reeson2003.monster_to_data.model.Monster;

import java.util.List;

/**
 * Created by reeson on 23.02.17.
 */
public interface MonsterDao {
    void insert(Monster monster) throws IllegalFieldException;
    List<Monster> getByName(String name) throws IllegalFieldException;
    Monster getById(int id) throws IllegalFieldException;
    List<Monster> getAll() throws BaseIsEmtyException;
    void removeById(int id) throws IllegalFieldException;
}

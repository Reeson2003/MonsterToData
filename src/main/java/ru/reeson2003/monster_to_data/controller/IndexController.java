package ru.reeson2003.monster_to_data.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.monster_to_data.dao.MonsterDao;
import ru.reeson2003.monster_to_data.exceptions.BaseIsEmtyException;
import ru.reeson2003.monster_to_data.model.Monster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by reeson on 24.02.17.
 */
public class IndexController extends HttpServlet {
    private MonsterDao dao;

    @Override
    public void init() throws ServletException {
        AbstractApplicationContext context =
                (AbstractApplicationContext) getServletContext().getAttribute("springContext");
        dao = (MonsterDao) context.getBean("dao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Monster> monsterList = null;
        try {
            monsterList = dao.getAll();
        } catch (BaseIsEmtyException e) {
        }
        if (monsterList != null) {
            req.setAttribute("monsters", monsterList);
        }
        getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }
}

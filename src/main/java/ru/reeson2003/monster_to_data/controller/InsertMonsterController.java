package ru.reeson2003.monster_to_data.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.monster_to_data.dao.MonsterDao;
import ru.reeson2003.monster_to_data.exceptions.IllegalFieldException;
import ru.reeson2003.monster_to_data.model.Monster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by reeson on 23.02.17.
 */
public class InsertMonsterController extends HttpServlet {
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
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        int level = Integer.parseInt(req.getParameter("level"));
        int health = Integer.parseInt(req.getParameter("health"));
        int mana = Integer.parseInt(req.getParameter("mana"));
        String name = req.getParameter("name");
        Monster monster = new Monster(id, name, level, health, mana);
        try {
            dao.insert(monster);
        } catch (IllegalFieldException e) {
            req.setAttribute("errorMessage", "Monster with ID " + id + " already exists");
            req.getSession().setAttribute("monster", monster);
            getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
        resp.sendRedirect("index.html");
    }
}

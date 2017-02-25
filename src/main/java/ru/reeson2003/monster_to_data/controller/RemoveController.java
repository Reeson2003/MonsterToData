package ru.reeson2003.monster_to_data.controller;

import org.springframework.context.support.AbstractApplicationContext;
import ru.reeson2003.monster_to_data.dao.MonsterDao;
import ru.reeson2003.monster_to_data.exceptions.IllegalFieldException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by reeson on 25.02.17.
 */
public class RemoveController extends HttpServlet {
    private MonsterDao dao;

    @Override
    public void init() throws ServletException {
        AbstractApplicationContext context = (AbstractApplicationContext) getServletContext().getAttribute("springContext");
        dao = (MonsterDao) context.getBean("dao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Map<String, String[]> params = req.getParameterMap();
            String[] numbers = params.get("remove");
            for (String n : numbers) {
                try {
                    int number = Integer.parseInt(n);
                    dao.removeById(number);
                } catch (IllegalFieldException e) {
                    req.setAttribute("errorMessage", "Wrong id:" + e.getValue());
                    getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
                } catch (NumberFormatException e) {
                    req.setAttribute("errorMessage", "Wrong parameter");
                    getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
                }
            }
            resp.sendRedirect("index.html");
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Something wrong");
            getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
        }
    }
}

package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");

        req.setAttribute("mealList", MealsUtil.getFilteredWithExcess(MealsUtil.hardcodeMealList,
                LocalTime.of(0, 0), LocalTime.of(23, 59), 2000));
        req.setAttribute("dtf", MealsUtil.DTF);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}

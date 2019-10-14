package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.Collection;

public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Collection<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Meal get(int id) {
        log.info("get {}", id);
        return (SecurityUtil.authUserId() == id) ? service.get(id) : null;
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
//        checkNew(user);
        return service.create(meal);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        if (SecurityUtil.authUserId() == id)
            service.delete(id);
    }

    public void update(Meal meal, int id) {
        log.info("update {} with id={}", meal, id);
//        assureIdConsistent(user, id);
        if (SecurityUtil.authUserId() == id)
            service.update(meal);
    }
}

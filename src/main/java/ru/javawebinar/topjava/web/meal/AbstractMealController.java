package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Collection<Meal> getAll() {
        log.info("getAll");
        return service.getAll(SecurityUtil.authUserId());
    }

    public Collection<Meal> getAll(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        log.info("getAll with filter");
        return service.getAll(SecurityUtil.authUserId(), startDate, startTime, endDate, endTime);
    }

    public Meal get(int id) throws NotFoundException {
        log.info("get {}", id);
        Meal meal = service.get(id);
        return (meal != null && SecurityUtil.authUserId() == meal.getUserId()) ? meal : null;
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        if (meal.isNew())
            meal.setUserId(SecurityUtil.authUserId());
        return service.create(meal);
    }

    public void delete(int id) throws NotFoundException {
        log.info("delete {}", id);
        Meal meal = get(id);
        if (meal != null && SecurityUtil.authUserId() == meal.getUserId())
            service.delete(id);
    }

    public void update(Meal meal, int id) throws NotFoundException {
        log.info("update {} with id={}", meal, id);
        assureIdConsistent(meal, id);
        if (SecurityUtil.authUserId() == meal.getUserId())
            service.update(meal);
    }
}

package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        repository = mealRepository;
    }

    public Meal create(Meal meal) throws NotFoundException{
        return checkNotFoundWithId(repository.save(meal), meal.getUserId());
    }

    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Meal get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }

    public Collection<Meal> getAll(int userId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return repository.getAll(userId, startDate, startTime, endDate, endTime);
    }

    public void update(Meal meal) throws NotFoundException {
        checkNotFoundWithId(repository.save(meal), meal.getId());
    }
}
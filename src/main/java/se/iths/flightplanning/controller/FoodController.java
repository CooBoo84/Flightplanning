package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.entity.FoodEntity;
import se.iths.flightplanning.exception.EmptyListException;
import se.iths.flightplanning.service.FoodService;

@RestController
@RequestMapping("food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping()
    public ResponseEntity<FoodEntity> createFood(@RequestBody FoodEntity foodEntity) {
        FoodEntity createdFood = foodService.createFood(foodEntity);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<Iterable<FoodEntity>> findAllFood() {
        Iterable<FoodEntity> allFood = foodService.findAllFood();
        if (allFood.iterator().hasNext())
            return new ResponseEntity<>(allFood, HttpStatus.OK);
        else
            throw new EmptyListException("Food list is empty.");
    }

    @GetMapping("getfoodDto")
    public ResponseEntity<Iterable<FoodDto>> findAllFoodDTO() {
        Iterable<FoodDto> allFood = foodService.findAllFoodDTO();
        if (allFood.iterator().hasNext())
            return new ResponseEntity<>(allFood, HttpStatus.OK);
        else
            throw new EmptyListException("Food list is empty.");
    }


    @GetMapping("{id}")
    public FoodEntity findFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

}

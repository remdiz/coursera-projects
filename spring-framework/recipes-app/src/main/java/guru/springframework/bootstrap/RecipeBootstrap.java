package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private void initData() {

        Ingredient avocado = new Ingredient();
        avocado.setDescription("ripe avocado");
        avocado.setAmount(new BigDecimal(2));
        Optional<UnitOfMeasure> pc = unitOfMeasureRepository.findByDescription("Pc(s)");
        avocado.setUom(pc.get());
        Ingredient salt = new Ingredient();
        salt.setDescription("Kosher salt");
        salt.setAmount(new BigDecimal(0.5));
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<Category> american = categoryRepository.findByDescription("American");
        Optional<Category> fastfood = categoryRepository.findByDescription("Fast Food");
        salt.setUom(teaspoon.get());
        Set<Ingredient> ingredients = new HashSet<>();
        Set<Category> categories = new HashSet<>();
        categories.add(american.get());
        categories.add(fastfood.get());
        ingredients.add(salt);
        ingredients.add(avocado);
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");

        Recipe guacamole = new Recipe();
        guacamole.setDescription("Guacamole, a dip made from avocados, is originally from Mexico.");
        guacamole.setCookTime(30);
        guacamole.setDirections("All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.");
        guacamole.setPrepTime(10);
        guacamole.setServings(3);
        guacamole.setSource("Simplyrecipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        avocado.setRecipe(guacamole);
        salt.setRecipe(guacamole);
        guacamole.setIngredients(ingredients);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamoleNotes.setRecipe(guacamole);
        guacamole.setNotes(guacamoleNotes);
        guacamole.setCategories(categories);
        recipeRepository.save(guacamole);
        //System.out.println("Length: " + recipeRepository.count());

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

}

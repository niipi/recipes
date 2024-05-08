package eu.piiroinen.recipes.repository;

import eu.piiroinen.recipes.model.Instruction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InstructionRepository extends CrudRepository<Instruction, Long> {

    List<Instruction> findInstructionsByRecipeId(Long recipeId);

    // TODO: Create, update, delete

}

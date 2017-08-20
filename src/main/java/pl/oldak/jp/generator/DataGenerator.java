package pl.oldak.jp.generator;

import pl.oldak.jp.model.Instruction;

import java.util.List;

/**
 * Interface for data generators that provide a list of instructions. Used to showcase the application
 */
public interface DataGenerator {
    /**
     *
     * @return A list of generated instructions
     */
    List<Instruction> generateInstructions();
}

package pl.oldak.jp.generator;

import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.InstructionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

/**
 * Provides a fixed list of sample data
 */
public class FixedDataGenerator implements DataGenerator {

    private final static String ENTITY_A = "Company_A";
    private final static String ENTITY_B = "Company_B";
    private final static String ENTITY_C = "Company_C";

    @Override
    public List<Instruction> generateInstructions() {
        return Arrays.asList(
                new Instruction(ENTITY_A,
                        InstructionType.BUY,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 3),
                        LocalDate.of(2017, 8, 3),
                        123,
                        new BigDecimal("523.76")
                ),
                new Instruction(ENTITY_B,
                        InstructionType.SELL,
                        new BigDecimal("1.6"),
                        Currency.getInstance("SAR"),
                        LocalDate.of(2017, 8, 4),
                        LocalDate.of(2017, 8, 4),
                        22,
                        new BigDecimal("111.2")
                ),
                new Instruction(ENTITY_C,
                        InstructionType.SELL,
                        new BigDecimal("32"),
                        Currency.getInstance("PLN"),
                        LocalDate.of(2017, 8, 3),
                        LocalDate.of(2017, 8, 4),
                        7766,
                        new BigDecimal("15")
                ),
                new Instruction(ENTITY_A,
                        InstructionType.BUY,
                        new BigDecimal("0.89"),
                        Currency.getInstance("AED"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 1),
                        888,
                        new BigDecimal("10")
                ),
                new Instruction(ENTITY_B,
                        InstructionType.BUY,
                        new BigDecimal("13.202"),
                        Currency.getInstance("CZK"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 7),
                        200,
                        new BigDecimal("66")
                ),
                new Instruction(ENTITY_C,
                        InstructionType.SELL,
                        new BigDecimal("0.5"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 4),
                        5000,
                        new BigDecimal("520.2")
                ),
                new Instruction(ENTITY_A,
                        InstructionType.BUY,
                        new BigDecimal("13"),
                        Currency.getInstance("EUR"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 4),
                        42,
                        new BigDecimal("42")
                ),
                new Instruction(ENTITY_B,
                        InstructionType.SELL,
                        new BigDecimal("16.99"),
                        Currency.getInstance("GBP"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 4),
                        765,
                        new BigDecimal("5.76")
                ),
                new Instruction(ENTITY_C,
                        InstructionType.BUY,
                        new BigDecimal("1.2"),
                        Currency.getInstance("SKK"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 3),
                        63,
                        new BigDecimal("12.56")
                ),
                new Instruction(ENTITY_A,
                        InstructionType.BUY,
                        new BigDecimal("1.001"),
                        Currency.getInstance("SAR"),
                        LocalDate.of(2017, 8, 1),
                        LocalDate.of(2017, 8, 2),
                        100,
                        new BigDecimal("98.11")
                )

        );
    }

}

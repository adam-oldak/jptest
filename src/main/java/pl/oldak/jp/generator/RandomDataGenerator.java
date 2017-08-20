package pl.oldak.jp.generator;

import pl.oldak.jp.model.Instruction;
import pl.oldak.jp.model.InstructionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generates 100 random instructions for 5 entities. Instruction date in set randomly in August 2017.
 * Settlement date is set after the instruction date, randomly from 0 to 6 days.
 *
 */
public class RandomDataGenerator implements DataGenerator {
    private final static int NUMBER_OF_RECORDS = 100;
    private final static int NUMBER_OF_ENTITIES = 5;
    private final static String[] CURRENCY_CODES = {"GBP", "EUR", "PLN", "AED", "SAR", "CAD"};

    private final Random random = new Random();

    private Instruction generateRandomInstruction() {
        LocalDate instructionDate = getRandomInstructionDate();
        return new Instruction(
                getRandomEntity(),
                getRandomInstructionType(),
                getRandomAgreedFx(),
                getRandomCurrency(),
                instructionDate,
                getRandomSettlementDate(instructionDate),
                getRandomUnits(),
                getRandomPricePerUnit()
        );
    }

    private int getRandomUnits() {
        return random.nextInt(100) + 1;
    }

    // between 0 and 100
    private BigDecimal getRandomPricePerUnit() {
        return new BigDecimal(random.nextInt(10000)).divide(new BigDecimal("100"));
    }

    // between 0.1 and 2
    private BigDecimal getRandomAgreedFx() {
        return new BigDecimal(random.nextInt(20) + 1).divide(new BigDecimal("10"));
    }

    private Currency getRandomCurrency() {
        String currencyCode = CURRENCY_CODES[random.nextInt(CURRENCY_CODES.length - 1)];
        return Currency.getInstance(currencyCode);
    }

    private LocalDate getRandomInstructionDate() {
        return LocalDate.of(2017, 8, random.nextInt(31) + 1);
    }

    private LocalDate getRandomSettlementDate(LocalDate instructionDate) {
        return instructionDate.plusDays(random.nextInt(7));
    }

    private InstructionType getRandomInstructionType() {
        if (random.nextBoolean()) {
            return InstructionType.BUY;
        } else {
            return InstructionType.SELL;
        }
    }

    private String getRandomEntity() {
        return "Entity_" + random.nextInt(NUMBER_OF_ENTITIES);
    }

    @Override
    public List<Instruction> generateInstructions() {
        return Stream.generate(this::generateRandomInstruction). limit(NUMBER_OF_RECORDS).collect(Collectors.toList());
    }
}

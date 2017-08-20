package pl.oldak.jp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

/**
 * A model for customer instruction
 */
public class Instruction {
    private final String entity;
    private final InstructionType type;
    private final BigDecimal agreedFx;
    private final Currency currency;
    private final LocalDate instructionDate;
    private final LocalDate settlementDate;
    private final Integer units;
    private final BigDecimal pricePerUnit;

    public Instruction(String entity, InstructionType type, BigDecimal agreedFx, Currency currency,
                       LocalDate instructionDate, LocalDate settlementDate,
                       Integer units, BigDecimal pricePerUnit) {
        this.entity = entity;
        this.type = type;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.settlementDate = settlementDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public String getEntity() {
        return entity;
    }

    public InstructionType getType() {
        return type;
    }

    public BigDecimal getAgreedFx() {
        return agreedFx;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public Integer getUnits() {
        return units;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "entity='" + entity + '\'' +
                ", type=" + type +
                ", agreedFx=" + agreedFx +
                ", currency=" + currency +
                ", instructionDate=" + instructionDate +
                ", settlementDate=" + settlementDate +
                ", units=" + units +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}

package pl.oldak.jp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A model for settlement. Settlement comprises of an instruction, an actual settlement day and USD trade amount
 */
public class Settlement {
    private final Instruction instruction;
    private final LocalDate actualSettlementDate;
    private final BigDecimal tradeUsdAmount;

    public Settlement(Instruction instruction, LocalDate actualSettlementDate, BigDecimal tradeUsdAmount) {
        this.instruction = instruction;
        this.actualSettlementDate = actualSettlementDate;
        this.tradeUsdAmount = tradeUsdAmount;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public LocalDate getActualSettlementDate() {
        return actualSettlementDate;
    }

    public BigDecimal getTradeUsdAmount() {
        return tradeUsdAmount;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "instruction=" + instruction +
                ", actualSettlementDate=" + actualSettlementDate +
                ", tradeUsdAmount=" + tradeUsdAmount +
                '}';
    }
}

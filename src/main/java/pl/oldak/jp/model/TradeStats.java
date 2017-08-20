package pl.oldak.jp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Trade statistics
 */
public class TradeStats {
    private final Map<LocalDate, BigDecimal> outgoingAmountByDay;
    private final Map<LocalDate, BigDecimal> incomingAmountByDay;
    private final LinkedHashMap<BigDecimal, String> outgoingEntityRanking;
    private final LinkedHashMap<BigDecimal, String> incomingEntityRanking;

    public TradeStats(Map<LocalDate, BigDecimal> outgoingAmountByDay, Map<LocalDate, BigDecimal> incomingAmountByDay,
                      LinkedHashMap<BigDecimal, String> outgoingEntityRanking, LinkedHashMap<BigDecimal, String> incomingEntityRanking) {
        this.outgoingAmountByDay = outgoingAmountByDay;
        this.incomingAmountByDay = incomingAmountByDay;
        this.outgoingEntityRanking = outgoingEntityRanking;
        this.incomingEntityRanking = incomingEntityRanking;
    }

    public Map<LocalDate, BigDecimal> getOutgoingAmountByDay() {
        return outgoingAmountByDay;
    }

    public Map<LocalDate, BigDecimal> getIncomingAmountByDay() {
        return incomingAmountByDay;
    }

    public LinkedHashMap<BigDecimal, String> getOutgoingEntityRanking() {
        return outgoingEntityRanking;
    }

    public LinkedHashMap<BigDecimal, String> getIncomingEntityRanking() {
        return incomingEntityRanking;
    }

    @Override
    public String toString() {
        return "TradeStats{" +
                "outgoingAmountByDay=" + outgoingAmountByDay +
                ", incomingAmountByDay=" + incomingAmountByDay +
                ", outgoingEntityRanking=" + outgoingEntityRanking +
                ", incomingEntityRanking=" + incomingEntityRanking +
                '}';
    }
}

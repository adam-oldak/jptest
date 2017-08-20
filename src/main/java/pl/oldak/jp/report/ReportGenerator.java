package pl.oldak.jp.report;

import pl.oldak.jp.model.TradeStats;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Generates a text report
 */
public class ReportGenerator {

    public static final String HORIZONTAL_DIVIDER = "--------------------------------------------------------\n";

    /**
     * Generates a textual report from trade statistics
     * @param stats trade statistics
     * @return Text report
     */
    public String generateReport(TradeStats stats) {
        StringBuilder report = new StringBuilder();

        report.append(HORIZONTAL_DIVIDER);
        report.append("REPORT\n");
        report.append(HORIZONTAL_DIVIDER);

        report.append(HORIZONTAL_DIVIDER);
        report.append("Settled USD outgoing amount by day\n");
        report.append(HORIZONTAL_DIVIDER);
        appendTradeAmountByDay(stats.getOutgoingAmountByDay(), report);

        report.append(HORIZONTAL_DIVIDER);
        report.append("Settled USD incoming amount by day\n");
        report.append(HORIZONTAL_DIVIDER);
        appendTradeAmountByDay(stats.getIncomingAmountByDay(), report);


        report.append(HORIZONTAL_DIVIDER);
        report.append("Entity ranking by highest outgoing instruction amount\n");
        report.append(HORIZONTAL_DIVIDER);
        appendEntityRanking(stats.getOutgoingEntityRanking(), report);

        report.append(HORIZONTAL_DIVIDER);
        report.append("Entity ranking by highest incoming instruction amount\n");
        report.append(HORIZONTAL_DIVIDER);
        appendEntityRanking(stats.getIncomingEntityRanking(), report);


        return report.toString();
    }

    private void appendTradeAmountByDay(Map<LocalDate, BigDecimal> tradeAmountByDay, StringBuilder report) {
        tradeAmountByDay
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> report.append(String.format("%s = %s USD\n", entry.getKey(), entry.getValue())));
    }


    private void appendEntityRanking(LinkedHashMap<BigDecimal, String> ranking, StringBuilder report) {
        for (Map.Entry<BigDecimal, String> entry : ranking.entrySet()) {
            report.append(String.format("Entity: %s, max amount for an instruction: %s USD\n", entry.getValue(), entry.getKey()));
        }
    }
}

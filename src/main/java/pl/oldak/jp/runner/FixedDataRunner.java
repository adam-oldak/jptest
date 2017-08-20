
package pl.oldak.jp.runner;

import pl.oldak.jp.generator.FixedDataGenerator;
import pl.oldak.jp.model.TradeStats;
import pl.oldak.jp.report.ReportGenerator;
import pl.oldak.jp.trade.TradeStatsCalculator;

/**
 * Runner class for a fixed data set.
 */
public class FixedDataRunner {

    public static void main(String[] args) {
        FixedDataGenerator generator = new FixedDataGenerator();

        TradeStatsCalculator tradeStatsCalculator = new TradeStatsCalculator();
        TradeStats tradeStats = tradeStatsCalculator.calculateTradeStats(generator.generateInstructions());

        String report = new ReportGenerator().generateReport(tradeStats);

        System.out.println(report);

    }


}

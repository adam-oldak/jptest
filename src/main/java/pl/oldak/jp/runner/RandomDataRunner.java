
package pl.oldak.jp.runner;

import pl.oldak.jp.generator.RandomDataGenerator;
import pl.oldak.jp.model.TradeStats;
import pl.oldak.jp.report.ReportGenerator;
import pl.oldak.jp.trade.TradeStatsCalculator;

/**
 * Runner class for a random data set.
 */
public class RandomDataRunner {

    public static void main(String[] args) {
        RandomDataGenerator generator = new RandomDataGenerator();

        TradeStatsCalculator tradeStatsCalculator = new TradeStatsCalculator();
        TradeStats tradeStats = tradeStatsCalculator.calculateTradeStats(generator.generateInstructions());

        String report = new ReportGenerator().generateReport(tradeStats);

        System.out.println(report);

    }


}

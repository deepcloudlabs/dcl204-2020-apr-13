import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
module com.example.lottery.app {
    requires com.example.lottery;
    requires com.example.random;
    uses LotteryService;
    uses RandomNumberService;
}
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.business.SimpleLotteryService;
import com.example.random.service.RandomNumberService;

module com.example.lottery {
    requires com.example.random;
    exports com.example.lottery.service;
    uses RandomNumberService;
    provides LotteryService with SimpleLotteryService;
}
import com.example.random.service.RandomNumberService;
import com.example.random.service.business.SecureRandomNumberService;
import com.example.random.service.business.SimpleRandomNumberService;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
module com.example.random {
    exports com.example.random.service;
    provides RandomNumberService with SimpleRandomNumberService, SecureRandomNumberService;
}
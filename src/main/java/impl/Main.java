package impl;

import configuration.ConfigDB;
import impl.DealerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Alina_Tamkevich
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        context.register(ConfigDB.class);
        context.refresh();
        DealerInfoRepository dealerInfoRepository = context.getBean(DealerInfoRepository.class);
        dealerInfoRepository.getAndSetDealersInformation();
        dealerInfoRepository.getAndSetDealerAddress();
        dealerInfoRepository.getAndSetDealerContact();
        dealerInfoRepository.getAndSetLocationAddressMap();
        dealerInfoRepository.getAndSetLocationContactMap();
        dealerInfoRepository.getAndSetContactType();
    }

}

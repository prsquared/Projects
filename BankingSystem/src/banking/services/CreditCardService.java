package banking.services;

import banking.entity.CreditCard;

import java.util.Random;

public class CreditCardService {
    public CreditCard generateCreditCard() {
        Random random = new Random(System.currentTimeMillis());
        CreditCard card =  new CreditCard();
        card.setMiiIdentifier(4);
        card.setBinNo(400000);
        card.setAccountIdentifier(random.nextInt(900000000)+100000000);
        card.setCheckSum(8);
        StringBuilder cardNumberBuilder = new StringBuilder();
        cardNumberBuilder.append(card.getBinNo())
                .append(card.getAccountIdentifier())
                .append(card.getCheckSum());
        card.setCreditCardNumber(Long.parseLong(cardNumberBuilder.toString()));
        card.setPinNumber(random.nextInt(9000)+1000);
        return card;
    }
}

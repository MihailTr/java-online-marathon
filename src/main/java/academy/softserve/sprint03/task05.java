package academy.softserve.sprint03;

/**
 * Create ClientType enum that contains NEW, SILVER, GOLD and PLATINUM constants that represent client status.
 * <p>
 * For storing count of months for each client create private "months" field of type int and initialize it using constructor with int parameter.
 * <p>
 * Set for each item of enum a value according to next table:
 * <p>
 * Client status    Count of months
 * NEW              1
 * <p>
 * SILVER           12
 * <p>
 * GOLD             30
 * <p>
 * PLATINUM         60
 * <p>
 * <p>
 * Create public method named “discount()” that return discount value as coefficient from 1.0 to 0.0 according to client status.
 * <p>
 * By default discount() method should return value 1.0 of double type.
 * <p>
 * Override discount() method for each constant and return discount value that calculated by next formula:
 * <p>
 * Client status
 * <p>
 * <p>
 * Formula
 * <p>
 * NEW
 * Default value
 * <p>
 * SILVER
 * <p>
 * <p>
 * (100 - <count of months> * 0,25) / 100
 * <p>
 * GOLD
 * <p>
 * <p>
 * (100 - <count of months> * 0,3) / 100
 * <p>
 * PLATINUM
 * <p>
 * <p>
 * (100 - <count of months> * 0,35) / 100
 */

public class task05 {
    enum ClientType {
        NEW(1){
            @Override
            public double discount() {
                return super.discount();
            }
        },
        SILVER(12){
            @Override
            public double discount() {
                return (100 - SILVER.months * 0.25) / 100;
            }
        },
        GOLD(30){
            @Override
            public double discount() {
                return (100 - GOLD.months * 0.3) / 100;
            }
        },
        PLATINUM(60){
            @Override
            public double discount() {
                return (100 - PLATINUM.months * 0.35) / 100;
            }
        };

        private int months;

        ClientType(int months) {
            this.months = months;
        }

        public double discount() {
            double discountVal = 1;
            return discountVal;
        }
    }
}

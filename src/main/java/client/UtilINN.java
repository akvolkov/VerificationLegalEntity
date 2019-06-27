package client;

public class UtilINN {
    // длина ИНН юридического лицв
    private final static int LENGTH_INN_LEGAL_ENTITY = 10;
    private final static int LENGTH_INN_INDIVIDUAL = 12;

    /**
     * Проверка ИНН на число.
     * @param inn - ИНН в виде строки.
     * @return {@code true} если ИНН состоит из цифр;
     *         {@code false} если ИНН не состоит из цифр.
     */
    public static boolean checkNumber(String inn) {
        try {
            Long.parseLong(inn);
        }
        catch (NumberFormatException e) {
            System.out.println("INN must be number!");
            return false;
        }
        return true;
    }

    /**
     * Проверка ИНН на длинну.
     * @param inn - ИНН в виде строки.
     * @return {@code true} если длина ИНН равна {@link UtilINN#LENGTH_INN_LEGAL_ENTITY};
     *         {@code false} если длина ИНН не равна {@link UtilINN#LENGTH_INN_LEGAL_ENTITY}.
     */
    public static boolean checkLength(String inn) {
        if (inn.length() == LENGTH_INN_LEGAL_ENTITY || inn.length() == LENGTH_INN_INDIVIDUAL) {
            return true;
        } else {
            System.out.println("INN must have 10(for legal entity) or 12(for individual) digits!");
            return false;
        }

    }

}

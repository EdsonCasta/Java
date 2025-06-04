public class CurrencyConverter {

    ApiQuery api = new ApiQuery();

    public void  convert(String from, String to, double amount){
        double rate = api.getExchangeRate(from, to);
        if (rate != 0) {
            double result = rate * amount;
            System.out.println("El valor de: " + amount + "\nEquivale a: " + result);
        } else {
            System.out.println("No fue posible realizar la conversión");
        }
    }
}

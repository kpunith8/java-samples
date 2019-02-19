package com.java.example.devoxx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
public interface CurrencyConverter
{
    double convert(double amout);

    interface BiFunction
    {
        Double convert(double amount, String toCurrency);

        default CurrencyConverter to(String toCurrency)
        {
            return amount -> convert(amount, toCurrency);
        }
    }

    interface TriFunction
    {
        Double convert(Double amount, String fromCurrency, String toCurrency);

        default BiFunction from(String fromCurrency)
        {
            return (amount, toCurrency) -> convert(amount, fromCurrency, toCurrency);
        }
    }

    static TriFunction of(LocalDate date)
    {
        return (amount, fromCurrency, toCurrency) -> {
            Path path = Paths.get("src/main/resources/files/currency.txt");

            try (Stream<String> lines = Files.lines(path))
            {
                Map<String, Double> converterMap = lines.skip(1L).collect(
                        Collectors.toMap(line -> line.substring(0, 3), line -> Double.parseDouble(line.substring(4))));

                return amount * (converterMap.get(toCurrency) / converterMap.get(fromCurrency));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        };
    }
}

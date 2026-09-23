package br.com.voriquetech.industria.app;

import br.com.voriquetech.industria.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    private static final Locale PT_BR = Locale.of("pt", "BR");

    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DecimalFormat FORMATO_NUMERO =
            new DecimalFormat(
                    "#,##0.00",
                    DecimalFormatSymbols.getInstance(PT_BR)
            );

    private static final BigDecimal FATOR_AUMENTO = new BigDecimal("1.10");

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
                "Catarina", LocalDate.of(1995, 10, 18),
                new BigDecimal("2050.85"), "Operador"
        ));

        funcionarios.add(new Funcionario(
                "João", LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"), "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Arthur", LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"), "Coordenador"
        ));

        funcionarios.add(new Funcionario(
                "Vitor", LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"), "Diretor"
        ));

        funcionarios.add(new Funcionario(
                "Gabriela", LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"), "Recepcionista"
        ));

        funcionarios.add(new Funcionario(
                "Hugo", LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"), "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Paulo", LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"), "Contador"
        ));

        funcionarios.add(new Funcionario(
                "Maria", LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"), "Gerente"
        ));

        funcionarios.add(new Funcionario(
                "Tereza", LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"), "Eletricista"
        ));

        funcionarios.add(new Funcionario(
                "Helena", LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"), "Gerente"
        ));

        funcionarios.removeIf(
                funcionario -> "João".equals(funcionario.getNome())
        );

        System.out.println("\n=== Funcionários após remover João ===");
        funcionarios.forEach(Principal::imprimirFuncionario);

        for (Funcionario funcionario : funcionarios) {
            BigDecimal novoSalario = funcionario.getSalario()
                    .multiply(FATOR_AUMENTO)
                    .setScale(2, RoundingMode.HALF_UP);

            funcionario.setSalario(novoSalario);
        }

        Map<String, List<Funcionario>> funcionariosPorFuncao =
                funcionarios.stream()
                        .collect(Collectors.groupingBy(
                                Funcionario::getFuncao,
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        System.out.println("\n=== Funcionarios por função após aumento ===");

        funcionariosPorFuncao.forEach((funcao, grupo) -> {
            System.out.println("Função: " + funcao);
            grupo.forEach(Principal::imprimirFuncionario);
        });

        System.out.println("Aniversariantes de outubro e dezembro ===");

        funcionarios.stream()
                .filter(funcionario -> {
                    int mes = funcionario.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(Principal::imprimirFuncionario);

        System.out.println("\n=== Funcionáro com maior idade ===");

        LocalDate hoje = LocalDate.now();

        funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(funcionario -> {
                    int idade = Period.between(
                            funcionario.getDataNascimento(), hoje
                    ).getYears();

                    System.out.printf(
                            "Nome: %s | Idade: %d anos%n",
                            funcionario.getNome(),
                            idade
                    );
                });

        System.out.println("\n=== Funcionários em ordem alfabética ===");

        Collator comparadorNomes = Collator.getInstance(PT_BR);

        funcionarios.stream()
                .sorted(Comparator.comparing(
                        Funcionario::getNome,
                        comparadorNomes
                ))
                .forEach(Principal::imprimirFuncionario);

        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n=== Total dos salários ===");
        System.out.println("R$ " + FORMATO_NUMERO.format(totalSalarios));

        System.out.println("\n=== Quantidade de salários mínimos ===");

        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidadeSalariosMinimos =
                    funcionario.getSalario().divide(
                            SALARIO_MINIMO,
                            2,
                            RoundingMode.HALF_UP
                    );

            System.out.printf(
                    "%s: %s salários mínimos%n",
                    funcionario.getNome(),
                    FORMATO_NUMERO.format(quantidadeSalariosMinimos)
            );
        }
    }

    private static void imprimirFuncionario(Funcionario funcionario) {
        System.out.printf(
                "Nome: %s | Nascimento: %s | Salário: R$ %s | Função: %s%n",
                funcionario.getNome(),
                funcionario.getDataNascimento().format(FORMATO_DATA),
                FORMATO_NUMERO.format(funcionario.getSalario()),
                funcionario.getFuncao()
        );
    }
}

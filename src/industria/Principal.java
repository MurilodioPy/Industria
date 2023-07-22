/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package industria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author murilodio
 */
// 3 – Deve conter uma classe Principal para executar as seguintes ações:
public class Principal {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();//lista de funcionarios

        // 3.1 - Inserir todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário “João” da lista
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals("João")) {
                funcionarios.remove(funcionario);
                break;
            }
        }

        // 3.3 - Imprimir todos os funcionários com todas suas informações
        System.out.println("Funcionarios: \n");
        for (Funcionario funcionario : funcionarios) {
            //print das informações do funcionario
            System.out.println(funcionario);
        }

        System.out.println("\n==============================================================================================\n");

        // 3.4 - Aumentar salário em 10%
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }

        // 3.5 - Agrupar funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        List<Funcionario> funcao;
        for (Funcionario funcionario : funcionarios) {
            funcao = funcionariosPorFuncao.getOrDefault(funcionario.getFuncao(), new ArrayList<>());
            funcao.add(funcionario);
            funcionariosPorFuncao.put(funcionario.getFuncao(), funcao);
        }

        // 3.6 - Imprimir os funcionários, agrupados por função
        System.out.println("Funcionarios agrupados por funcao: \n");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Funcao: " + entry.getKey());
            // percorre lista dentro do Map
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("\t" + funcionario);
            }
        }

        System.out.println("\n==============================================================================================\n");

        // 3.8 - Imprimir os funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("Aniversariantes dos meses 10 e 12: \n");
        int[] mesesAniversario = {10, 12};//meses de aniversario
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            for (int i = 0; i < mesesAniversario.length; i++) {
                if (mesesAniversario[i] == mesAniversario) {
                    System.out.println("Aniversariante: " + funcionario);
                }
            }
        }

        System.out.println("\n==============================================================================================\n");

        // 3.9 - Imprimir o funcionário com a maior idade
        // pega o funcionario maisVelho dentro de funcionarios com base na comparação por data
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idadeMaisVelho = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
        System.out.println("O Funcionario mais velho eh: " + maisVelho.getNome() + ", Idade: " + idadeMaisVelho);

        System.out.println("\n==============================================================================================\n");

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        //Ordenando funcionarios em ordem alfabética
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        System.out.println("Funcionarios em ordem alfabetica: \n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        System.out.println("\n==============================================================================================\n");

        // 3.11 - Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = new BigDecimal("0.00");
        for (Funcionario funcionarioSalario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionarioSalario.getSalario());
        }
        System.out.println("Total dos salarios dos funcionarios: R$" + totalSalarios.toString().replace(".", ","));

        System.out.println("\n==============================================================================================\n");

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("Salarios em relacao ao salario minimo de: " + salarioMinimo + "\n");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.CEILING);
            System.out.println(funcionario.getNome() + ": " + salariosMinimos + " salario(s) minimos");
        }
        
        System.out.println("\n==============================================================================================FIM\n");

    }
}

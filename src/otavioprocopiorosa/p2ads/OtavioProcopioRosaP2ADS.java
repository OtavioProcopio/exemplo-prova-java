package otavioprocopiorosa.p2ads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtavioProcopioRosaP2ADS {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scan = new Scanner(System.in);
        int opcao;
        List<Consulta> cst = lerDados();

        for (Consulta c : cst) {
            System.out.println(c.toString());
        }

        do {
            System.out.println("Menu\r\n"
                    + "1 – Relatorio por Convenio\r\n"
                    + "2 – Relatorio percentual convenios\r\n"
                    + "3 – Sair\r\n" + "Digite a opção desejada:");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número do convênio (1, 2 ou 3):");
                    int convenioEscolhido = scan.nextInt();

                    if (convenioEscolhido < 1 || convenioEscolhido > 3) {
                        System.out.println("Convênio não cadastrado.");
                    } else {

                        double totalRecebido = 0;
                        boolean encontrouPaciente = false;

                        PrintWriter pw = new PrintWriter(new File("relatorio_convenio_" + convenioEscolhido + ".txt"));
                        pw.println("Relatório do Convênio " + convenioEscolhido);
                        pw.println("Paciente\tValor Pago");

                        for (Consulta c : cst) {
                            if (c.getConvenio() == convenioEscolhido) {
                                double valorPago = c.valorConsultaPorConvenio(convenioEscolhido);
                                System.out.println(String.format("%s\t%.2f", c.getNome(), valorPago));
                                pw.println(String.format("%s\t%.2f", c.getNome(), valorPago));
                                totalRecebido += valorPago;
                                encontrouPaciente = true;
                            }
                        }

                        if (!encontrouPaciente) {
                            System.out.println("Nenhum paciente encontrado para este convênio.");
                            pw.println("Nenhum paciente encontrado.");
                        } else {
                            System.out.println(String.format("Total Recebido: %.2f", totalRecebido));
                            pw.println(String.format("Total Recebido: %.2f", totalRecebido)); 
                        }
                        pw.close();
                    }
                    break;

                case 2:
                    
                    int[] contagemConvenios = new int[4]; 
                    double totalConsultas = cst.size();

                    for (Consulta c : cst) {
                        int convenio = c.getConvenio();
                        if (convenio >= 1 && convenio <= 3) {
                            contagemConvenios[convenio]++;
                        }
                    }

                    PrintWriter pw = new PrintWriter(new File("percentual_convenios.txt"));
                    pw.println("Convênio\tPercentual");

                    for (int i = 1; i <= 3; i++) {
                        double percentual = (contagemConvenios[i] / totalConsultas) * 100;
                        pw.println(String.format("%d10%.2f%%", i, percentual));
                        System.out.println(String.format("Convênio %d: %.2f%%", i, percentual));
                    }

                    pw.close();

                    break;
            }
        } while (opcao != 3);
    }

    public static List<Consulta> lerDados() throws FileNotFoundException {
        File fil = new File("Dados");
        Scanner scan = new Scanner(fil);
        List<Consulta> cst = new ArrayList<>();
        while (scan.hasNext()) {
            Consulta c = new Consulta(scan.next(), scan.nextInt(), scan.nextDouble());
            cst.add(c);
        }

        return cst;
    }

}

# Prova P2 - Desenvolvimento de Sistemas

## Sobre o Projeto

Este projeto foi desenvolvido como parte da **Prova P2** do curso de Análise e Desenvolvimento de Sistemas na **Fatec Mococa-SP**. A prova avaliou conhecimentos em Java, incluindo manipulação de arquivos, criação de classes e métodos, e implementação de lógica de negócios.

## Objetivo da Prova

A proposta da prova era criar um programa que:

1. Leia os dados de pacientes de um arquivo de texto (`Dados`).
2. Calcule o valor da consulta baseado no convênio do paciente.
3. Gere relatórios detalhados com base nos dados fornecidos.
4. Permita interatividade via menu para realizar consultas e gerar relatórios.

## Funcionamento do Programa

### Estrutura do Programa

O programa é dividido em duas classes principais:

- **`Consulta`**: Representa os dados de um paciente e contém a lógica para calcular o valor da consulta com base no convênio.
- **`OtavioProcopioRosaP2ADS`**: Classe principal que implementa o fluxo do programa e a interação com o usuário.

### Funcionalidades

1. **Leitura de Dados**  
   O programa lê os dados dos pacientes de um arquivo chamado `Dados`. Cada linha do arquivo deve conter:
   - Nome do paciente (`String`)
   - Número do convênio (`int`, valores 1, 2 ou 3)
   - Valor base da consulta (`double`)

2. **Menu Interativo**  
   O menu permite que o usuário escolha entre as opções:
   - **1 – Relatório por Convênio**: 
     - Solicita o número do convênio (1, 2 ou 3).
     - Exibe os pacientes vinculados ao convênio escolhido e o valor pago por consulta.
     - Gera um arquivo `relatorio_convenio_[numero].txt` com o resumo do relatório.
   - **2 – Relatório Percentual de Convênios**:
     - Calcula e exibe a porcentagem de pacientes atendidos para cada convênio.
     - Gera um arquivo `percentual_convenios.txt` com os dados calculados.
   - **3 – Sair**: Encerra o programa.

3. **Cálculo do Valor da Consulta**  
   O valor da consulta é determinado com base no número do convênio:
   - Convênio 1: Valor base integral.
   - Convênio 2: 50% do valor base.
   - Convênio 3: 30% do valor base.

### Exemplos de Arquivos Gerados

#### `relatorio_convenio_1.txt`

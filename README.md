# Indústria — Cadastro de funcionários

Projeto Java de console que cadastra funcionários, aplica aumento salarial, agrupa por função e exibe relatórios. Os dados são definidos na classe `Principal` e processados em memória, sem entrada pelo teclado.

## Pré-requisitos

- JDK 21 instalado e disponível no terminal. A compilação e a execução foram verificadas nessa versão.
- Não há dependências externas; o projeto utiliza apenas a biblioteca padrão do Java.

Confira a instalação:

```sh
java -version
javac -version
```

Ambos devem indicar a versão 21 para seguir estas instruções com a versão validada. O JDK inclui o compilador `javac` e o comando `java`, usado para executar o programa.

## Estrutura

```text
Industria/
├── README.md
└── src/br/com/voriquetech/industria/
    ├── app/
    │   └── Principal.java
    └── model/
        ├── Pessoa.java
        └── Funcionario.java
```

- `Pessoa`: nome e data de nascimento.
- `Funcionario`: estende `Pessoa` e acrescenta salário e função.
- `Principal`: contém o método `main`, responsável por executar as operações.

## Como executar pelo terminal

Abra o terminal na pasta `Industria`, onde estão este README e a pasta `src`.

**1. Compile o projeto:**

```sh
javac -encoding UTF-8 -d out -sourcepath src src/br/com/voriquetech/industria/app/Principal.java
```

O comando compila `Principal` e as classes utilizadas por ela. A opção `-encoding UTF-8` preserva a leitura dos acentos, `-sourcepath src` indica onde estão os fontes e `-d out` grava os arquivos compilados na pasta `out`, criada automaticamente.

**2. Execute o programa:**

```sh
java -cp out br.com.voriquetech.industria.app.Principal
```

A opção `-cp out` indica onde estão as classes compiladas. O nome completo da classe inclui seu pacote e é informado sem a extensão `.java`.

Após alterar o código, repita a compilação antes de executar novamente.

## Resultado da execução

O terminal exibe:

- Funcionários após a remoção de João.
- Funcionários agrupados por função, com aumento salarial de 10%.
- Aniversariantes de outubro e dezembro.
- Nome e idade do funcionário mais velho.
- Funcionários em ordem alfabética.
- Total dos salários atualizados.
- Quantidade de salários mínimos de cada funcionário, considerando R$ 1.212,00.

As datas aparecem no formato `dd/MM/yyyy` e os valores numéricos utilizam ponto para milhar e vírgula para decimais. A idade é calculada com base na data de execução.

Os dados não são salvos em arquivo ou banco de dados: cada execução começa com os valores definidos em `Principal.java`.

## Enunciado original

TESTE PRÁTICO PROGRAMAÇÃO.

Considerando que uma indústria possui as pessoas/funcionários abaixo:

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3 – Deve conter uma classe Principal para executar as seguintes ações:
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
3.2 – Remover o funcionário “João” da lista.
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
• informação de data deve ser exibido no formato dd/mm/aaaa;
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
3.6 – Imprimir os funcionários, agrupados por função.
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
3.10 – Imprimir a lista de funcionários por ordem alfabética.
3.11 – Imprimir o total dos salários dos funcionários.
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

Orientações gerais:
• você poderá utilizar a ferramenta que tem maior domínio (exemplos: eclipse, netbeans etc);
• após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa Mão na Massa 🖐.
Basta Colar o link ainda aqui nessa etapa.
• Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.

Esperamos que você use todo seu conhecimento e criatividade nesse teste.

Caso você não souber resolver determinado requisito comente no código que aquele item você não sabe como desenvolver, e vá para o próximo. Avaliaremos o que você conseguiu desenvolver e como foi desenvolvido.

Boa sorte!

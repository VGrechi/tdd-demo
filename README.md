## Contexto

- Um sistema qualquer que gera vendas;
- A cada venda gerada, também é gerada uma nota de venda;
- É gerado um arquivo .PDF para cada nota de venda
- O arquivo .PDF é salvo em um repositório externo

## Implementação #1

- A nota de venda tem numeração sequencial (1, 2, 3, ... , n)
- O número da nota de venda precisa estar no conteúdo do arquivo .PDF gerado, portanto, precisa ser definido antes da geração da nota de venda

## Implementação #2

- O usuário pode informar o número da nota de venda que desejar
- O usuário não pode informar um número da nota de venda menor que o último gerado
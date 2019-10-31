      Julio Eiji Oliveira	        10716491
      Leonardo Rodrigues de Souza	10716380

	Relatório de projeto

Nesse projeto foram realizados os primeiros passos na criação de um editor de texto colaborativo, implementando as funcionalidades básicas de inserir e remover caracteres, assim como desfazer e refazer modificações. O projeto foi realizado completamente na IDE Netbeans.

Na classe main foi implementado o loop principal que permite ao usuário editar o texto através de linhas de comando. Para isso o usuário deve digitar o número do comando desejado seguido da tecla enter. 

No caso da inserção de caracterer ele deve, em seguida, digitar o texto que será inserido. Após cada alteração, o texto será immprimido, junto com a posição do cursor no texto. A inserção é feita a partir da posição do cursor.

No caso da remoção, ela sera feita a partir da posição imediatamente anterior ao cursor. O usuário deve especificar o número de caracteres que serão removidos.

A função de desfazer reverte a mais recente modificação do texto enquanto a de refazer reverte a mais recente função de desfazer utilizada. No momento não há limite para quantas modificações são guardadas, o que pode gerar um overflow em caso de muitas modificações. Isso será corrigido em versões futuras.

É possível mover a posição do cursor com o comando de mover cursor para editor outrasa partes do texto.

Vale notar que, como o programa tem apenas as funcionalidades básicas de um editor, ainda não existe a criação de um arquivo de saída; o texto é editado somente em RAM e é perdido quando o programa fecha, o que será mudado em versões futuras.

Adicionalmente ao programa, foram criados um diagrama UML para o projeto e a documentação em javadocs na IDE NetBeans.
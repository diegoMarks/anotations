## Pattern e Matcher
Uma expressão regular através de meta caracteres valida um texto.  
**Pattern**: É o padrão que precisa ser encontrado.  
**Matcher**: Encontra o padrão no texto.  
String regex = "ab";  
Pattern texto = "abaaaba";  
//Compila o texto e transforma-o em um padrão  
Pattern pattern = Pattern.compile(regex);  
//Busca no texto o padrão.  
Matcher matcher = Pattern.matcher(texto);  
//Loop que percorre o texto buscando o padrão  

while (matcher.find()){

    System.out.print(matcher.start() +  " ");  
    //Para buscar valores pode ser adicionado o comando:   matcher.group();
}

**Obs**: Caso o matcher encontre o padrão uma vez, este não será contado para uma próxima vez.  
Ex: Se mudar o padrão do String regex e do Pattern texto.  
String regex = "aba";  
Pattern texto = "abababa";  
Neste caso, ao buscar pelo padrão "aba" que foi adicionado 3 vezes no texto o **Matcher** só encontrará 2 vezes, a primeira e a última. Isto ocorre pelo fato do match somente ser contado uma vez em cada busca.

## Metacaracteres
**\d**: Retorna todos os digitos. Para usá-lo deve-se adicionar mais uma \ para ser o caractere de escape do java.  
**\D**: Retorna tudo que não for digito.  
**\s**: Retorna todos os espaços em branco.  
**\S**: Retorna todos os caracteres que não estão em branco.  
**\w**: Retorna todas as letras, digitos e o caracter especial **underscore _**.  
**\W**: Retorna tudo que não for incluso no **\w**.  
Estes são os principais **Metacarteres**, mas existem muitos outros. E para utilizar devem ser colocados na expressão regex.  
String regex = "\\d";

## Metacaractere de range []
**[]**: O valor que for passado dentro dos colchetes será buscado, podendo ser passado um intervalo de valores.  
Para buscar um intervalo por exemplo entre letras: a-zA-Z  
Este intervalo busca de minúsculas até maiúsculas. Pode-se usar mais de um colchete para buscar entre vários intervalos.  

## Quantificadores
São caracteres que possíbilitam pegar determinada expressão  
**?**: Representa zero ou uma ocorrência.  
**\***: Representa zero ou mais.  
**+**: Representa uma ou mais.
**{n,m}**: Retorna os caracteres de **n** até **m**.  
**(|)**: Os parênteses servem para agrupar caracteres de busca, o pipe | serve para separar dois caracteres, então em um texto o **match** buscaria uma ou outra ocorrência dos caracteres dentro dos parênteses. Ex: o(v|c)o  
Neste exemplo o **match** iria buscar entre duas letras 'o' a ocorrência ou de 'v' ou de 'c', podendo o resultado ser 'ovo' ou 'oco'.  
**$**: Representa o fim da linha.  
**.**: Retorna um intervalo entre duas expressões separadas pelo ponto.  
**^**: Se colocado no inicio da expressão ele retorna o começo da linha que bate com a expressão que foi passada. Se ele for posto dentro do **[]** ele faz a negação da expressão passada.  
**OBS**: O parênteses deve ser usado sempre para separar quantificadores.   
**Para validar um e-mail:**  
String regex = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";  
System.out.println("email@gmail.com".matches(regex));  
Se o e-mail estiver valido retorna true, senão false.  
*Um site bem interessante para expressões regulares é o* https://regexr.com

## Tokens e Delimitadores
Para capturar elementos usa-se a classe String.split que retorna um array de strings. Caso seja necessário guardar o tipo de cada objeto capturado deve-se usar a classe Scanner.  
String texto = "Levi,Eren,Mikasa,true,200";  
Scanner scanner = new Scanner(texto);  
scanner.useDelimiter(",");  

while(scanner.hasNext()){  

    if(scanner.hasNext()){
        int i = scanner.nextInt();
        System.out.println("Int " + i);
    } else if(scanner.hasNextBoolean()){
        boolean b = scanner.nextBoolean();
        System.out.println("Boolean " + b);
    }
}
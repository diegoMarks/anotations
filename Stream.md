# Stream
Processamento de dados de forma mais funcional.  
* **Stream** trabalha com dados no tempo, não está sendo guardando nada.   
### Operações com Stream
* Intermediárias: Ação que retorna um próprio **Stream**.   
    Ex: filtrar, encadear, limitar. 

Alguns dos principais métodos Intermediários:  
**sorted()**: Ordena a lista.  
**filter()**: Filtra.  
**limit(quantidade)**: Limita a quantidade de retorno.  
**map()**: O que será retornado.  

* Finais: Os métodos finais trazem os dados do tempo para o espaço. 

Principais métodos **Finais**:  
**collect()**: Entre os principais, pode retornar um **Collectors.toSet()** ou um **Collectors.toList()**.  
**forEach()**: Método que faz a iteração dos itens de uma lista. Caso só queira imprimir dados na tela, é melhor usar o método **forEach** diretamente na lista, sem **Stream()**.  
**count()**: Conta os itens de uma lista, normalmente usado após o **filter()**.  

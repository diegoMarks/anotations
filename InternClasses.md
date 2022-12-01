## Classes Anônimas
São classes que vão existir um breve perído de tempo no código e que não podem ser reutilizadas em nenhum outro lugar.  
Para instânciar uma classe anônima:

        public statuc void main(String[] args){
            Objeto objeto = new Objeto(){
                @Métodos que precisam ser sobrescritos
                public void método(){
                    System.out.println(sobrescrica do método);
                }
            }
        }

Desta forma temos uma classe com seu método sobrescrito temporáriamente. Ela só existe durante a execução do código. **Não é possível criar métodos novos em uma classe anônima**.

## Classes Aninhadas Estáticas
São classes criadas de forma estática dentro de outra classe principal, isto é feito para obter um melhor empacotamento de objetos com mesma finalidade afim de evitar pacotes desnecessários no projeto.

    public class ClassePrincial{
        private String nome = "Diego";

        //Criação da classe Aninhada
        static class ClasseAninhada{
            private String sobrenome = "Marks";
            void print(){
                System.out.prinln(new ClassePrincipal().nome + " " + sobrenome); 
            }
        }

     public static void main(String[] args){
        ClasseAninhada aninhada = new ClasseAninhada();

        aninhada.print();

        //Resultado:
        Diego Marks
     }   
    }

    
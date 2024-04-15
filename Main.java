
public class Main {

    public static String ACT1 = "ACT1";
    public static String ACT2 = "ACT2";
    public static String ACT3 = "ACT3";

    public static void main(){
        //Digite o executavel do código aqui
        Janela j = new Janela("aaa");
        j.addTexto("Teste");
        j.addTexto("segundo teste");
        j.addTexto("terceiro teste");
        j.addLogin();
        j.addBotao("botão 1", ACT3);
        j.addBotao("botão 2", ACT2);
    }    
}

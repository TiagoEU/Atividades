// Bilbliotecas importadas
import javax.swing.*; //Biblioteca do Jframe (faz a janela)
import java.awt.*; // Biblioteca para o layout da janela (desing)
import java.awt.event.*; // Biblioteca para monitorar o click nos botões
import java.io.IOException; //Biblioteca de erros de entrada e saida de dados


// Classe Janela
public class Janela extends JFrame{

    // Atributos para inicialização da classe
    private int labelCaunt; // Atributo para contar os textos
    private int buttonCaunt; // Atributos para contar os botões
    private GridBagConstraints layout; // Atributo para a classe que fara o layout da janela (desing)
    private JPanel conteinerTxt = new JPanel(new GridBagLayout()); // Cria um conteiner para os textos
    private JPanel conteinerBot = new JPanel(new GridBagLayout()); // Cria um conteiner para os botões
    private static int x = 600; // Atributo estatico responsavel por salvar a posição x inicial da janela ao exibir na tela
    private static int y = 250; // Atributo estatico responsavel por salvar a posição y inicial da janela ao exibir na tela
    
    

    //Construto da classe Janela
    public Janela(String nomeJanela){
        super(nomeJanela);
        setSize(600, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra o programa ao fechar a janela, quando em execução.
        setLocation(x, y);
        setVisible(true);
        this.layout = new GridBagConstraints();
        this.layout.insets = new Insets(10, 10, 10, 10);
        this.labelCaunt = 0;
        this.buttonCaunt = 0;
        x += 75;
        y += 75;
    }

    //Metodo para adiciona texto à janela
    public void addTexto(String texto){

        JLabel jl = new JLabel(texto);

        this.layout.gridx = 0;
        this.layout.gridy = labelCaunt;
        this.layout.insets = new Insets(3,3,3,3);
        
        conteinerTxt.add(jl, this.layout);

        add(conteinerTxt);

        pack();
        ++labelCaunt;
    }

    // metodos privados utilizados apenas na propria classe para dar função aos botões
    private void act1(){
        JOptionPane.showMessageDialog(null, "Imagina que uma ação foi executada :)");
    }
    private void act2(){
        try {
            ProcessBuilder command = new ProcessBuilder("calc");
            command.start();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void act3(){        
        try {
            ProcessBuilder command = new ProcessBuilder("cmd", "/c", "start", "\"\"", "https://www.google.com");
            command.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para adiciona botões à janela
    public void addBotao(String nomeBotao, String ACT){

        JButton jb = new JButton(nomeBotao);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (ACT) {
                    case "ACT1":
                        act1();
                        break;
                    case "ACT2":
                        act2();
                        break;
                    case "ACT3":
                        act3();                       
                        break;                
                    default:
                        JOptionPane.showMessageDialog(null, "Opção invalida :(((");
                        break;
                }      
            }            
        });
        
        this.layout.gridy = 0;
        this.layout.gridx = buttonCaunt;
        this.layout.insets = new Insets(10, 10, 10, 10);

        conteinerBot.add(jb, this.layout);
        add(conteinerBot);

        pack();
        ++buttonCaunt;
    }

    //Metodo para adicionar login à janela
    public void addLogin(){

        JLabel user = new JLabel("Usuário: "); 
        JTextField userfield = new JTextField(10);
        JLabel psswd = new JLabel("Senha: ");
        JPasswordField psswdfield =  new JPasswordField(10);
        
        JPanel conteiner = new JPanel(new GridBagLayout());
         

        this.layout.anchor = GridBagConstraints.WEST;
         
        this.layout.gridx = 0;
        this.layout.gridy = 0;     
        conteiner.add(user, this.layout);
 
        this.layout.gridx = 1;
        conteiner.add(userfield, this.layout);
         
        this.layout.gridx = 0;
        this.layout.gridy = 1;     
        conteiner.add(psswd, this.layout);
         
        this.layout.gridx = 1;
        conteiner.add(psswdfield, this.layout);

        add(conteiner);
        pack();

    }    
}

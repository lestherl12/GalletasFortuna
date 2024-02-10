import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Galletas extends JFrame {
    private galletasfortunas galletasfortunas;
    private JButton crackOpenButton;
    private JButton selectAnotherButton;
    private String[] mensajesBuenaFortuna = {
            "La suerte está de tu lado hoy. ¡Aprovecha las oportunidades!",
            "La vida te sonríe. Disfruta cada momento.",
            "Un pequeño cambio puede traer grandes bendiciones.",
            "La perseverancia es la clave del éxito.",
            "Hoy es un buen día para tomar decisiones importantes.",
            "Recuerda que cada día es una nueva oportunidad.",
            "La felicidad está en las pequeñas cosas.",
            "Confía en ti mismo y sigue adelante."
    };
    private String[] mensajesMalaFortuna = {
            "Cuidado con los obstáculos en tu camino.",
            "No te preocupes por lo que no puedes controlar.",
            "A veces, los fracasos son lecciones disfrazadas.",
            "No temas los cambios; pueden ser oportunidades disfrazadas.",
            "La paciencia es una virtud. Todo llega a su tiempo.",
            "No te desanimes por los desafíos; son parte del crecimiento.",
            "Recuerda que las tormentas también pasan.",
            "Aprende de tus errores y sigue adelante."
    };

    public Galletas() {
        // Configuración básica de la ventana
        setTitle("Galleta de la Fortuna");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Crear una instancia de galletasfortunas
        galletasfortunas = new galletasfortunas("te sonríe la vida, sé feliz");

        // Crear componentes de la interfaz
        crackOpenButton = new JButton("Abrir Galleta");
        selectAnotherButton = new JButton("Seleccionar otra galleta");
        JLabel fortuneLabel = new JLabel("Mensaje de la Fortuna: ");
        fortuneLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Ajustar el tamaño de la fuente

        // Configurar el manejo de eventos para el botón "Abrir Galleta"
        crackOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fortune;
                if (new Random().nextBoolean()) {
                    fortune = mensajesBuenaFortuna[new Random().nextInt(mensajesBuenaFortuna.length)];
                } else {
                    fortune = mensajesMalaFortuna[new Random().nextInt(mensajesMalaFortuna.length)];
                }
                fortuneLabel.setText("Mensaje de la Fortuna: " + fortune);
                crackOpenButton.setEnabled(false);
                selectAnotherButton.setEnabled(true);
            }
        });

        // Configurar el manejo de eventos para el botón "Seleccionar otra galleta"
        selectAnotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fortuneLabel.setText("Mensaje de la Fortuna: ");
                crackOpenButton.setEnabled(true);
                selectAnotherButton.setEnabled(false);
            }
        });

        // Agregar componentes a la ventana
        setLayout(new FlowLayout());
        add(crackOpenButton);
        add(selectAnotherButton);
        add(fortuneLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Galletas().setVisible(true);
        });
    }
}

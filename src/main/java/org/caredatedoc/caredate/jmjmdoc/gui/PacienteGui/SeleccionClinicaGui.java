package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class SeleccionClinicaGui extends JFrame {

    public String seleccionarClinica() {
        List<String> clinicas = Arrays.asList(
                "1. Av. Instituto Politécnico Nacional 123, Lindavista, Gustavo A. Madero",
                "2. Calzada de los Gallos 55, San Álvaro, Azcapotzalco",
                "3. Av. Universidad 460, Copilco, Coyoacán",
                "4. Av. Presidente Masaryk 112, Polanco, Miguel Hidalgo",
                "5. Av. Revolución 899, San Ángel, Álvaro Obregón",
                "6. Av. Insurgentes Sur 1432, Del Valle, Benito Juárez",
                "7. Prolongación División del Norte 307, Santa Cruz Acalpixca, Xochimilco",
                "8. Av. Montevideo 300, La Villa, Gustavo A. Madero",
                "9. Calle Clavería 100, Clavería, Azcapotzalco",
                "10. Calle Felipe Carrillo 140, Villa Coyoacán, Coyoacán",
                "11. Bahía de San Hipólito 250, Anzures, Miguel Hidalgo",
                "12. Calle 10 541, Olivar del Conde, Álvaro Obregón",
                "13. Av. Cuauhtémoc 500, Narvarte, Benito Juárez",
                "14. Calle Pino 150, San Mateo Xalpa, Xochimilco",
                "15. Calzada Ticomán 601, San Pedro Zacatenco, Gustavo A. Madero",
                "16. Calle Fresno 33, San Miguel Amantla, Azcapotzalco",
                "17. Calle Cerro del Agua 90, Pedregal de Santo Domingo, Coyoacán",
                "18. Av. Marina Nacional 212, Tacuba, Miguel Hidalgo",
                "19. Calle Goya 119, Colinas del Sur, Álvaro Obregón",
                "20. Av. Patriotismo 655, Nápoles, Benito Juárez"
        );

        UIManager.put("OptionPane.background", Color.decode("#2E2E2C"));
        UIManager.put("Panel.background", Color.decode("#2E2E2C"));
        UIManager.put("OptionPane.messageForeground", Color.decode("#f3f1e4"));
        UIManager.put("OptionPane.messageFont", new Font("Aharoni", Font.PLAIN, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Aptos Mono", Font.PLAIN, 14));

        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona una clínica:",
                "Clínicas Disponibles",
                JOptionPane.PLAIN_MESSAGE,
                null,
                clinicas.toArray(),
                clinicas.get(0)
        );

        if (seleccion != null) {
            UIManager.put("OptionPane.messageFont", new Font("Aptos Mono", Font.PLAIN, 14));
            JOptionPane.showMessageDialog(null, "Clínica seleccionada: " + seleccion);

            SwingUtilities.invokeLater(() -> {
                ModuloCitasGui moduloCitas = new ModuloCitasGui(seleccion);
                moduloCitas.setVisible(true);
            });
        }

        return seleccion;
    }
}
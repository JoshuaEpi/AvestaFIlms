package Grafos;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import Grafos.Control;
import Grafos.Location;
import Grafos.Main;
import Grafos.Route;

public class Window extends JFrame {
    private final Color PANELS_COLOR = new Color(255, 234, 224);
    private final Color BUTTONS_COLOR = new Color(250, 184, 153);

    private Control control = new Control();

    /** Componentes de la ventana */
    private JPanel panelOptions = new JPanel();
    private JPanel panelBtn = new JPanel();
    private JPanel panelInformationText = new JPanel();

    private JButton btnGenerate = new JButton("Generar ruta");

    String[] arrayCities = {"Comas", "Los olivos", "Callao", "Ventanilla", "Independencia", "La victoria", "Ate", "Santa anita", "Chorrillos", "Surco"};
    private JComboBox<String> comboCityOrigin = new JComboBox<>(arrayCities);
    private JComboBox<String> comboCityDestiny = new JComboBox<>(arrayCities);

    private JTextArea areaInformation = new JTextArea(8, 27);
    private JScrollPane scrollInformation = new JScrollPane(areaInformation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public Window() {
        super("Cines");
        setSize(350, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(PANELS_COLOR);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        launchPanels();
    }

    public void launchPanels() {
        optionsMenu();
        watchInformation();
    }

    private void optionsMenu() {
        configPanel(panelOptions, new FlowLayout());
        panelOptions.add(comboCityOrigin);
        panelOptions.add(comboCityDestiny);
        panelOptions.add(btnGenerate);

        configPanel(panelBtn, new GridLayout(1, 1));

        addButtonToPanel(btnGenerate, panelBtn, e -> {
            areaInformation.setText(control.showRoute(
                    comboCityOrigin.getSelectedIndex(),
                    comboCityDestiny.getSelectedIndex()
            ));
        });

        this.add(panelBtn, BorderLayout.SOUTH);
        this.add(panelOptions, BorderLayout.NORTH);
    }

    private void watchInformation() {
        configPanel(panelInformationText, new FlowLayout());
        areaInformation.setText("");
        areaInformation.setLineWrap(true);
        areaInformation.setEditable(false);
        panelInformationText.add(scrollInformation);
        this.add(panelInformationText, BorderLayout.CENTER);
    }

    private void configPanel(JPanel panel, LayoutManager layout) {
        panel.setLayout(layout);
        panel.setBackground(PANELS_COLOR);
    }

    private void configButtons(JButton button) {
        button.setBackground(BUTTONS_COLOR);
        button.setForeground(Color.white);
    }

    private void addButtonToPanel(JButton button, JPanel panel, ActionListener listener) {
        configButtons(button);
        button.addActionListener(listener);
        panel.add(button);
    }
}

import javax.swing.*;

public class ProxyExample extends JFrame {

    public ProxyExample() {
        setTitle("Proxy Example");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxPanel boxPanel = new BoxPanel();
        add(boxPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProxyExample::new);
    }
}

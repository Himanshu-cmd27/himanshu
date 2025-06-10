import ui.StudentForm;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(StudentForm::new);
    }
}
import ui.StudentForm;

public class Main {
    public static void main(String[] args) {
        // Run UI in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> new StudentForm());
    }
}

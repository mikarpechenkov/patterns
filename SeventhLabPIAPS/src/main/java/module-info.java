module tictactoe.seventhlabpiaps {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens tictactoe to javafx.fxml;
    exports tictactoe;
}
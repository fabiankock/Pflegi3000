package comfabiankockpflegi3000.github.pflegi3000.controller.main_activity_controller;

public class ControllerMainActivity {

    private MainActivityButtonListener btnListener;

    public ControllerMainActivity(){

        this.btnListener = new MainActivityButtonListener();
    }

    public MainActivityButtonListener getButtonListener() {

        return btnListener;
    }
}

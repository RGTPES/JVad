package ss8.ex3;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Da gan " + command + " cho nut " + button);
    }

    public void pressButton(int button) {
        Command command = buttons.get(button);
        if (command == null) {
            System.out.println("Nut " + button + " chua duoc gan lenh.");
            return;
        }

        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (history.isEmpty()) {
            System.out.println("Khong co lenh nao de undo.");
            return;
        }

        Command lastCommand = history.pop();
        lastCommand.undo();
    }

    public void showAssignedButtons() {
        if (buttons.isEmpty()) {
            System.out.println("Chua co nut nao duoc gan lenh.");
            return;
        }

        System.out.println("Danh sach nut da gan:");
        for (Map.Entry<Integer, Command> entry : buttons.entrySet()) {
            System.out.println("Nut " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

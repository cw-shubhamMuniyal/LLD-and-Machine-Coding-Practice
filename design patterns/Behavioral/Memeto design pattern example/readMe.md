## Requirements: 

- Manage Chess Moves states.
- Also handle history of chess moves.

## Definition of Memento design pattern:

It's a behavioral design pattern that captures and restores an object’s state without exposing its internal details. 
It is useful for implementing undo/rollback functionality.

## when to use Memento design pattern:

✅ Need to implement undo or rollback functionality. </br>
✅ Want to store object state without exposing internal details. </br>
✅ Need to maintain history for state restoration. </br>
✅ Dealing with long-lived objects that change frequently. </br>

## example from head first design pattern book:

Here is the full Java code implementing Text Editor with Undo functionality:

``` java
import java.util.Stack;

// Memento: Stores the state of the TextEditor
class Memento {
private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator: The Text Editor that creates and restores mementos
class TextEditor {
private String text;

    public void write(String newText) {
        text = newText;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = memento.getState();
    }
}

// Caretaker: Manages memento history
class UndoManager {
private Stack<Memento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }
}

// Main Class to Test Memento Pattern
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        UndoManager undoManager = new UndoManager();

        editor.write("Hello, World!");
        undoManager.save(editor);

        editor.write("Hello, OpenAI!");
        undoManager.save(editor);

        editor.write("Hello, Java!");
        System.out.println("Current Text: " + editor.getText());

        undoManager.undo(editor);
        System.out.println("After Undo: " + editor.getText());

        undoManager.undo(editor);
        System.out.println("After Another Undo: " + editor.getText());
    }
}
```

output from above code:

```
Current Text: Hello, Java!
After Undo: Hello, OpenAI!
After Another Undo: Hello, World!
```


## Benefits of Memento design pattern:

✅ Encapsulation of State – The Memento stores an object’s state without exposing its internal details. </br>
✅ Supports Undo/Redo Functionality – Enables easy restoration of previous states, making it ideal for text editors, games, and database transactions. </br>
✅ Separation of Concerns – The Originator handles business logic, and the Caretaker manages state history without modifying the object itself. </br>
✅ Preserves Object Integrity – Prevents accidental modifications by storing past states securely. </br>
✅ Easy to Implement History Tracking – Useful in version control, workflow systems, and AI model checkpoints. </br>
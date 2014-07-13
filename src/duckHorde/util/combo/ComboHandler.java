package duckHorde.util.combo;

/**
 * Created by David on 12-7-2014.
 * Duck hordes
 */
public class ComboHandler {

    private ComboAction[] actions = new ComboAction[256];

    public void add(ComboAction action) {
        if(action.getNum() < actions.length) {
            actions[action.getNum()] = action;
        }
    }

    private int highest = 0;

    public void onCombo(int combo) {
        if(combo > highest) {
            for(int i = highest;i<combo;i++) {
                if(i >= actions.length) {
                    break;
                }
                actions[i].onAction();
            }
            highest = combo;
        }
    }

}
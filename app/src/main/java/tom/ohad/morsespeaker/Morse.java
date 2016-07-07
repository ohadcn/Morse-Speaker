package tom.ohad.morsespeaker;

import android.view.KeyEvent;

/**
 * Created by ohad on 06/07/16.
 */
public class Morse {
    public static enum MorseValues {
        DOT, LINE, SPACE
    }

    public static final String morseCode =
            "~\netianmsurwdkgohvf!l@pjbxcyzq+=54#3$%^2()[]{}\\16?\":,.',7<>/8-90";

    private static final int[] MorseToKeys = {0,
            KeyEvent.KEYCODE_SPACE, KeyEvent.KEYCODE_E,KeyEvent.KEYCODE_T,
            KeyEvent.KEYCODE_I, KeyEvent.KEYCODE_A, KeyEvent.KEYCODE_N,
            KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_U,
            KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_W, KeyEvent.KEYCODE_D,
            KeyEvent.KEYCODE_K, KeyEvent.KEYCODE_G, KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_H,
            KeyEvent.KEYCODE_V, KeyEvent.KEYCODE_F, KeyEvent.KEYCODE_PERIOD,
            KeyEvent.KEYCODE_L, KeyEvent.KEYCODE_DEL, KeyEvent.KEYCODE_P,
            KeyEvent.KEYCODE_J, KeyEvent.KEYCODE_B, KeyEvent.KEYCODE_X,
            KeyEvent.KEYCODE_C, KeyEvent.KEYCODE_Y, KeyEvent.KEYCODE_Z,
            KeyEvent.KEYCODE_Q, KeyEvent.KEYCODE_PLUS, KeyEvent.KEYCODE_MINUS,
            KeyEvent.KEYCODE_5, KeyEvent.KEYCODE_4, KeyEvent.KEYCODE_ENTER,
            KeyEvent.KEYCODE_3, KeyEvent.KEYCODE_AT, KeyEvent.KEYCODE_EQUALS,
            KeyEvent.KEYCODE_POUND, KeyEvent.KEYCODE_2, KeyEvent.KEYCODE_LEFT_BRACKET,
            KeyEvent.KEYCODE_RIGHT_BRACKET, KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_DPAD_DOWN,
            KeyEvent.KEYCODE_DPAD_UP, KeyEvent.KEYCODE_DPAD_RIGHT, KeyEvent.KEYCODE_BACKSLASH,
            KeyEvent.KEYCODE_1, KeyEvent.KEYCODE_6, KeyEvent.KEYCODE_NUMPAD_LEFT_PAREN,
            KeyEvent.KEYCODE_NUMPAD_RIGHT_PAREN, KeyEvent.KEYCODE_GRAVE, KeyEvent.KEYCODE_MOVE_END,
            KeyEvent.KEYCODE_MOVE_HOME, KeyEvent.KEYCODE_STAR, KeyEvent.KEYCODE_COMMA,
            KeyEvent.KEYCODE_7, KeyEvent.KEYCODE_INSERT, KeyEvent.KEYCODE_SLASH,
            KeyEvent.KEYCODE_VOLUME_MUTE, KeyEvent.KEYCODE_8, KeyEvent.KEYCODE_LANGUAGE_SWITCH,
            KeyEvent.KEYCODE_9, KeyEvent.KEYCODE_0
    };
    private int n = 1;

    public boolean add(MorseValues val) {
        if(val == MorseValues.SPACE)
            return true;
        n = (n<<1) + (val == MorseValues.LINE?1:0);
        return false;
    }

    public int toKeyCode() {
        try {
            return MorseToKeys[n];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return KeyEvent.KEYCODE_LANGUAGE_SWITCH;
        }

    }
    @Override
    public String toString() {
        return String.valueOf(morseCode.charAt(n));
    }
}

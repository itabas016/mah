/**
 * MIT License
 *
 * Copyright (c) 2017 zgqq
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mah.ui.key;

import mah.event.EventHandler;

/**
 * Created by zgq on 2017-01-09 10:28
 */
public class KeyReleasedHandler implements EventHandler<KeyEvent> {

    private void setCtrlPressed() {
        KeystateManager.getInstance().setCtrl(false);
    }

    private void setAltPressed() {
        KeystateManager.getInstance().setAlt(false);
    }

    private void setMetaPressed() {
        KeystateManager.getInstance().setMeta(false);
    }

    @Override
    public void handle(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == java.awt.event.KeyEvent.VK_CONTROL) {
            setCtrlPressed();
        } else if (keyCode == java.awt.event.KeyEvent.VK_ALT) {
            setAltPressed();
        } else if (keyCode == java.awt.event.KeyEvent.VK_META) {
            setMetaPressed();
        } else if (keyCode == java.awt.event.KeyEvent.VK_SHIFT) {
            KeystateManager.getInstance().setShift(false);
        }
    }
}

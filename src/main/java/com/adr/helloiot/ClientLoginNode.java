//    This file is part of HelloIot.
//
//    HelloIot is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    HelloIot is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with HelloIot.  If not, see <http://www.gnu.org/licenses/>.

package com.adr.helloiot;

import com.adr.fonticon.FontAwesome;
import com.adr.fonticon.IconBuilder;
import com.adr.hellocommon.utils.AbstractController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author adrian
 */
public class ClientLoginNode extends BorderPane implements AbstractController {

    @FXML
    private HBox headerbox;
    @FXML
    private Label headertitle;
    @FXML
    private Button nextbutton;

    @FXML
    private TextField url;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private TextField timeout;
    @FXML
    private TextField keepalive;
    @FXML
    private RadioButton qos0;
    @FXML
    private RadioButton qos1;
    @FXML
    private RadioButton qos2;

    ClientLoginNode() {
        load("/com/adr/helloiot/fxml/clientlogin.fxml", "com/adr/helloiot/fxml/clientlogin");
    }

    @FXML
    public void initialize() {
        nextbutton.setGraphic(IconBuilder.create(FontAwesome.FA_PLAY, 18.0).build());
        Platform.runLater(url::requestFocus);
    }

    public void setOnNextAction(EventHandler<ActionEvent> exitevent) {
        nextbutton.setOnAction(exitevent);
    }

    public String getURL() {
        return url.getText();
    }

    public void setURL(String value) {
        url.setText(value);
    }

    public String getUserName() {
        return username.getText();
    }

    public void setUserName(String value) {
        username.setText(value);
    }

    public String getPassword() {
        return password.getText();
    }

    public int getConnectionTimeout() {
        return Integer.parseInt(timeout.getText());
    }

    public void setConnectionTimeout(int value) {
        timeout.setText(Integer.toString(value));
    }

    public int getKeepAliveInterval() {
        return Integer.parseInt(keepalive.getText());
    }

    public void setKeepAliveInterval(int value) {
        keepalive.setText(Integer.toString(value));
    }

    public int getDefaultQoS() {
        if (qos1.isSelected()) {
            return 1;
        } else if (qos2.isSelected()) {
            return 2;
        } else {
            return 0;
        }
    }

    public void setDefaultQoS(int value) {
        switch (value) {
            case 1:
                qos1.setSelected(true);
                break;
            case 2:
                qos2.setSelected(true);
                break;
            default:
                qos0.setSelected(true);
                break;
        }
    }
}

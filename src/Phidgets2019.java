import com.phidget22.*;
import java.awt.event.WindowAdapter;
import java.util.Timer;
import javax.swing.JFrame;


public class Phidgets2019 extends javax.swing.JFrame {
    
    //Sensor Variables
    LCD lcd=null;
    VoltageRatioInput vr1=null;
    VoltageRatioInput vr2=null;     
    VoltageInput vi=null;               //for non-ratiometric sensors just read voltage
    
    RCServo servo1=null;
    RCServo servo2=null;
    RFID rfid = null;
    
    double num;
    
    public Phidgets2019() {
        initComponents();
        setLocationRelativeTo(null);
        //this next bit sets up the frame to call a method when it is closed
        //the method will close all phidget connections
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                 closeAllPhidgetsConnections();
            }
        });
    }

    public void closeAllPhidgetsConnections() {
        System.out.println("Closing Phidgets connections...");
        try {
            if (lcd!=null)
            lcd.close();
            if (vr1!=null)
                vr1.close();
            if (servo1!=null)
                servo1.close();
            if (servo2!=null)
                servo2.close();
            if (rfid!=null)
                rfid.close();
            if (vr2!=null)
                vr2.close();
            if (vi!=null)
                vi.close();
        }catch(Exception e) {
            System.out.println("Problem closing connections");
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonServoTest = new javax.swing.JButton();
        sliderMotor = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        buttonSensorReading = new javax.swing.JButton();
        textValue = new javax.swing.JTextField();
        buttonConnectToSensors = new javax.swing.JButton();
        buttonConnectLCD = new javax.swing.JButton();
        textType = new javax.swing.JTextField();
        buttonUpdateLCD = new javax.swing.JButton();
        buttonConnectRFID = new javax.swing.JButton();
        textTagGain = new javax.swing.JTextField();
        textTagLoss = new javax.swing.JTextField();
        textTemp = new javax.swing.JTextField();
        buttonTempSensor = new javax.swing.JButton();
        textField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonServoTest.setText("Connect and Test Servos");
        buttonServoTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServoTestActionPerformed(evt);
            }
        });

        sliderMotor.setMajorTickSpacing(10);
        sliderMotor.setMaximum(180);
        sliderMotor.setMinimum(30);
        sliderMotor.setMinorTickSpacing(10);
        sliderMotor.setPaintLabels(true);
        sliderMotor.setPaintTicks(true);
        sliderMotor.setToolTipText("");
        sliderMotor.setValue(30);
        sliderMotor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMotorStateChanged(evt);
            }
        });

        jLabel1.setText("Servo1 Target Position Setter.  Slide around to control servo.");

        buttonSensorReading.setText("What is sensor port 0 reading?");
        buttonSensorReading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSensorReadingActionPerformed(evt);
            }
        });

        buttonConnectToSensors.setText("Connect to Sensor/s");
        buttonConnectToSensors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectToSensorsActionPerformed(evt);
            }
        });

        buttonConnectLCD.setText("Connect LCD");
        buttonConnectLCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectLCDActionPerformed(evt);
            }
        });

        textType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textType.setText("write in here");
        textType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTypeKeyTyped(evt);
            }
        });

        buttonUpdateLCD.setText("Update LCD");
        buttonUpdateLCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateLCDActionPerformed(evt);
            }
        });

        buttonConnectRFID.setText("Connect RFID");
        buttonConnectRFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectRFIDActionPerformed(evt);
            }
        });

        textTagGain.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTagGain.setText("tag gain will appear here");
        textTagGain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTagGainActionPerformed(evt);
            }
        });

        textTagLoss.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textTagLoss.setText("tag loss will appear here");

        buttonTempSensor.setText("What is temp sensor port 1 reading?");
        buttonTempSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTempSensorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sliderMotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(buttonServoTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(buttonUpdateLCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(textType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(buttonConnectLCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonConnectRFID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textTagGain, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textTagLoss)
                        .addComponent(buttonConnectToSensors, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonSensorReading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonTempSensor, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textTemp, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(textValue))))
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonServoTest)
                .addGap(18, 18, 18)
                .addComponent(sliderMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonConnectToSensors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSensorReading))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTempSensor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonConnectLCD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateLCD))
                .addGap(38, 38, 38)
                .addComponent(buttonConnectRFID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTagGain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTagLoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonServoTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServoTestActionPerformed
       connectServos();
    }//GEN-LAST:event_buttonServoTestActionPerformed

    private void sliderMotorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMotorStateChanged
        int degrees=sliderMotor.getValue();
        System.out.println("Motor slider changing to " + degrees + " degrees");
        try {
            if (servo1!=null) {
              servo1.setTargetPosition(degrees);
              servo1.setEngaged(true);
            }
        }catch(Exception e) {
            System.out.println("Problem controlling motor with slider");
        }
        
    }//GEN-LAST:event_sliderMotorStateChanged

    private void buttonSensorReadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSensorReadingActionPerformed
        try {
            if (vr1!=null) {
                double val=vr1.getSensorValue();
                double val2=vr1.getVoltageRatio();
                textValue.setText(""+val);
            }
        }catch(Exception e) {
            System.out.println("Problem reading sensor value");
        }
    }//GEN-LAST:event_buttonSensorReadingActionPerformed

    private void buttonConnectToSensorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectToSensorsActionPerformed
        sensorConnect();
    }//GEN-LAST:event_buttonConnectToSensorsActionPerformed

    private void buttonConnectLCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectLCDActionPerformed
        lcdConnect();
    }//GEN-LAST:event_buttonConnectLCDActionPerformed

    private void textTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTypeKeyTyped

    }//GEN-LAST:event_textTypeKeyTyped

    private void buttonUpdateLCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateLCDActionPerformed
        System.out.println("Updating LCD");
        String someText=textType.getText();
        try {
            if (lcd!=null) {
                lcd.clear();
                lcd.writeText(LCDFont.DIMENSIONS_5X8,0, 0, someText);
                lcd.flush();
            }
        }catch(Exception e) {
            System.out.println("Problem with LCD writing");
        }
    }//GEN-LAST:event_buttonUpdateLCDActionPerformed

    private void textTagGainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTagGainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTagGainActionPerformed

    private void buttonConnectRFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectRFIDActionPerformed
       connectRFID();
    }//GEN-LAST:event_buttonConnectRFIDActionPerformed

    private void buttonTempSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTempSensorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTempSensorActionPerformed

    public void connectRFID() {
        if (rfid!=null)
            return;
     
         try {
                rfid = new RFID();  
                System.out.println("trying to open rfid");
                rfid.open(5000);
                
                rfid.addTagListener(new RFIDTagListener() {
                    public void onTag(RFIDTagEvent e) {
                            System.out.println("Tag read: " + e.getTag());
                            handleRead(e.getTag() );
                    }
                });

                rfid.addTagLostListener(new RFIDTagLostListener() {
                    public void onTagLost(RFIDTagLostEvent e) {
                            System.out.println("Tag lost: " + e.getTag());
                            handleLoss(e.getTag() );
                    }
                });
            
        }catch(Exception e) {
                System.out.println("Couldn't connect to RFID");
        }
        
    }
    
    
    public void handleRead(String id){
       System.out.println("handleRead: " + id);    
       textTagGain.setText(id);
   } 

   
    public void handleLoss(String id){
       System.out.println("handleLoss: " + id );
       textTagLoss.setText(id);
   } 
    
    
    public void lcdConnect() {
       if (lcd!=null)
           return;
       
       try {
           lcd = new LCD();

           lcd.addAttachListener(new AttachListener() {
                 public void onAttach(AttachEvent ae) {
                     LCD phid = (LCD) ae.getSource();
                     try {
                        if(phid.getDeviceClass() != DeviceClass.VINT){
                                System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " attached");
                        }
                        else{
                                System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " attached");
                        }
                        if(ae.getSource().getDeviceID() == DeviceID.PN_1204){
                                System.out.println("Setting arbitrary screen size");
                                phid.setScreenSize(LCDScreenSize.DIMENSIONS_1X8);
                        }
                     } catch (PhidgetException ex) {
                             System.out.println(ex.getDescription());
                     }
                 }
             });
            
          lcd.setDeviceSerialNumber(35663);
          lcd.setChannel(0);
          lcd.open(3000);

          lcd.setContrast(.50);
          lcd.setBacklight(1.0);
          lcd.writeText(LCDFont.DIMENSIONS_5X8, 0, 0, "Janetka!");
          lcd.flush();
       }catch(Exception e) {
           System.out.println(e);
       }

    }
    
    public void sensorConnect() {
         
        //this works for light sensor (ratiometric)
        if (vr1!=null)
            return;
        
        try {
                vr1=new VoltageRatioInput();
                vr1.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
                    public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
                        //System.out.println("VoltageRatioInput changed to " +  e.getVoltageRatio());
                        
                        num = (e.getVoltageRatio()*444.4) - 61.111;
                        textField.setText(""+num);
                    }
                });
                
                
                System.out.println("Opening and waiting 3 seconds for sensor attatchment...");
                vr1.setDeviceSerialNumber(402559);
                vr1.setChannel(2);
                //vr1.open(3000);
                System.out.println("vr1 value is : " + vr1.getSensorValue() );
        } catch(Exception e) {
            System.out.println(e);
            
        }
        
        
        
        //Works with rotation sensor, setting sensor type to adjust data
        try {
            vr2=new VoltageRatioInput();
                //this is the default listener for analog ports when type isn't set
                vr2.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
                    public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
                        double value=1000*e.getVoltageRatio();
                        double temp=value*(value-400)/4;
                        System.out.println("VR Sensor changed to " +  value + " -> " + temp);
                        
                    }
                });
            
                //this listener is used if the sensor has its type set just after opening
                vr2.addSensorChangeListener(new VoltageRatioInputSensorChangeListener() {
               @Override
                   public void onSensorChange(VoltageRatioInputSensorChangeEvent ev){
                       System.out.println("Sensor change event: " + ev.getSensorValue() );
                   } 
                });   
                

            vr2.setDeviceSerialNumber(35663);
            vr2.setChannel(1);  
            //vr2.open(3000);
            //vr2.setSensorType(VoltageRatioSensorType.PN_1112);   //testing with slider
            vr2.setSensorType(VoltageRatioSensorType.PN_1109);  //testing with rotation sensor
        }catch(Exception e) {
            System.out.println(e);
        }
        
        
        
       

        try {
            vi=new VoltageInput();
                //this is the default listener for analog ports when type isn't set
                vi.addVoltageChangeListener(new VoltageInputVoltageChangeListener() {
                    public void onVoltageChange(VoltageInputVoltageChangeEvent e) {
                        double value=e.getVoltage();
                        double temp=value*70.31-81;
                        System.out.println("Temp sensor changed to " +  value + " -> " + temp);
                    }
                });
         
            vi.setDeviceSerialNumber(402559);
            vi.setChannel(2);  
            vi.open(3000);
            
        }catch(Exception e) {
            System.out.println(e);
        }        
        
        
        
    }
    
    public void connectServos()  {
        if (servo1!=null || servo2!=null)
           return;
        
        try {
            servo1 = new RCServo();
            servo2 = new RCServo();

            System.out.println("Opening and waiting 2 seconds for attachment...");
            servo1.setDeviceSerialNumber(20530);        
            servo1.setChannel(0);
            servo1.open(3000);
            servo2.setDeviceSerialNumber(20530);        
            servo2.setChannel(3);
            servo2.open(3000);

            System.out.println("Testing servo1");
            servo1.setTargetPosition(30.0);
            servo1.setEngaged(true);
            for(int k=30; k<=150; k+=30){
                System.out.println("Moving servo1 to " + k + " degrees");
                servo1.setTargetPosition(k);
                Thread.sleep(1000);
            }
            System.out.println("Testing servo2");
            servo2.setTargetPosition(30.0);
            servo2.setEngaged(true);
            for(int k=30; k<=150; k+=30){
                System.out.println("Moving servo2 to " + k + " degrees");
                servo2.setTargetPosition(k);
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Phidgets2019.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phidgets2019.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phidgets2019.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phidgets2019.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Phidgets2019().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnectLCD;
    private javax.swing.JButton buttonConnectRFID;
    private javax.swing.JButton buttonConnectToSensors;
    private javax.swing.JButton buttonSensorReading;
    private javax.swing.JButton buttonServoTest;
    private javax.swing.JButton buttonTempSensor;
    private javax.swing.JButton buttonUpdateLCD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider sliderMotor;
    private javax.swing.JTextField textField;
    private javax.swing.JTextField textTagGain;
    private javax.swing.JTextField textTagLoss;
    private javax.swing.JTextField textTemp;
    private javax.swing.JTextField textType;
    private javax.swing.JTextField textValue;
    // End of variables declaration//GEN-END:variables
}

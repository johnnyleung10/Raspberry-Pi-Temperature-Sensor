import com.phidget22.*;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class SensorGraph extends javax.swing.JFrame {
    //Serial Variables FOR CHANGING
    int serialNum = 35663;
    int channelNum = 0;
    
    //Sensor Variables
    LCD lcd=null;
    VoltageRatioInput vr1=null;
    VoltageRatioInput vr2=null;     
    VoltageInput vi=null;               //for non-ratiometric sensors just read voltage
    
    RCServo servo1=null;
    RCServo servo2=null;
    RFID rfid = null;
    
    //Temperature Graph Variables
    double[] values=new double[20];
    double seconds=0;
    double iterations=0;
    boolean isReading=true;
    
    double temperatureNum;
    double topTemp=-150;
    double lowTemp=150;
    
    
    Timer timer1;
    long interval1=1000;
    
    
    public SensorGraph() {
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
    
    public double[] update(double[] old, double newValue){
        double[] updated=new double[old.length];
        for (int i = 0; i < old.length-1; i++) {
            updated[i+1]=old[i];
        } 
        updated[0]=newValue;
        return updated;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonConnectSensor = new javax.swing.JButton();
        buttonStartTempGraph = new javax.swing.JButton();
        panelTempGraph = new javax.swing.JPanel();
        textSensorReading = new javax.swing.JTextField();
        labelSensorReading = new javax.swing.JLabel();
        labelTopTemp = new javax.swing.JLabel();
        labelLowTemp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);

        buttonConnectSensor.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        buttonConnectSensor.setText("Connect to Sensor");
        buttonConnectSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectSensorActionPerformed(evt);
            }
        });

        buttonStartTempGraph.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        buttonStartTempGraph.setText("Graph");
        buttonStartTempGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartTempGraphActionPerformed(evt);
            }
        });

        panelTempGraph.setBackground(new java.awt.Color(204, 204, 255));
        panelTempGraph.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelTempGraph.setLayout(new java.awt.BorderLayout());

        textSensorReading.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        textSensorReading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSensorReadingActionPerformed(evt);
            }
        });

        labelSensorReading.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        labelSensorReading.setText("Sensor Reading:");

        labelTopTemp.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        labelTopTemp.setText("Highest Temperature:");

        labelLowTemp.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        labelLowTemp.setText("Lowest Temperature:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConnectSensor, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelSensorReading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSensorReading))
                    .addComponent(buttonStartTempGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTopTemp)
                            .addComponent(labelLowTemp))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTempGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonConnectSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSensorReading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSensorReading))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStartTempGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTopTemp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLowTemp)
                        .addContainerGap(540, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTempGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartTempGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartTempGraphActionPerformed
        isReading=true;
        startTimer1();
    }//GEN-LAST:event_buttonStartTempGraphActionPerformed

    private void textSensorReadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSensorReadingActionPerformed
        
    }//GEN-LAST:event_textSensorReadingActionPerformed

    private void buttonConnectSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectSensorActionPerformed
        sensorConnect();
    }//GEN-LAST:event_buttonConnectSensorActionPerformed
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
       //textTagGain.setText(id);
   } 

   
    public void handleLoss(String id){
       System.out.println("handleLoss: " + id );
       //textTagLoss.setText(id);
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
            
          lcd.setDeviceSerialNumber(serialNum);
          lcd.setChannel(channelNum);
          lcd.open(3000);

          lcd.setContrast(.50);
          lcd.setBacklight(1.0);
          lcd.writeText(LCDFont.DIMENSIONS_5X8, 0, 0, "Hello World");
          lcd.flush();
       }catch(Exception e) {
           System.out.println(e);
       }

    }
    
    public void sensorConnect() {
        if (vr1!=null)
            return;
        
        try {
                vr1=new VoltageRatioInput();
                vr1.addVoltageRatioChangeListener(new VoltageRatioInputVoltageRatioChangeListener() {
                    public void onVoltageRatioChange(VoltageRatioInputVoltageRatioChangeEvent e) {
                        System.out.println("VoltageRatioInput changed to " +  e.getVoltageRatio());
                    }
                });
                
        } catch(Exception e) {
            System.out.println(e);
        }
        
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
                                       
                        temperatureNum = temp;
                        String formatDec = String.format("%.2f", temp);
                        textSensorReading.setText(formatDec +" °C");
                        
                        if (temp>topTemp){
                            topTemp=temp;
                            labelTopTemp.setText("Highest Temperature: "+formatDec +" °C");
                        }
                        
                        if (temp<lowTemp){
                            lowTemp=temp;
                            labelLowTemp.setText("Lowest Temperature: "+formatDec +" °C");
                        }
                        
                    }
                });
         
            vi.setDeviceSerialNumber(402559);
            vi.setChannel(2);  
            vi.open(30000);
            
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
            java.util.logging.Logger.getLogger(SensorGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SensorGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SensorGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SensorGraph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SensorGraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnectSensor;
    private javax.swing.JButton buttonStartTempGraph;
    private javax.swing.JLabel labelLowTemp;
    private javax.swing.JLabel labelSensorReading;
    private javax.swing.JLabel labelTopTemp;
    private javax.swing.JPanel panelTempGraph;
    private javax.swing.JTextField textSensorReading;
    // End of variables declaration//GEN-END:variables
    
    public void startTimer1() {
            if (timer1!=null)
                return;
            timer1=new Timer();
            timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                if(isReading==true)
                    drawGraph();  
            }
        }, 1000, interval1);
    }
     
     public void drawGraph(){
         iterations++;
         seconds=iterations;

        values=update(values,temperatureNum);
        DefaultCategoryDataset barchartData=new DefaultCategoryDataset();
        for (int i = 0; i <values.length; i++) {
            String k=""+(seconds);
            barchartData.setValue(values[i],"Degrees Celsius",k);
            seconds--;
        }

        JFreeChart lineChart=ChartFactory.createLineChart("TEMPERATURE READINGS", "Seconds from Startup", "Temperature", barchartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot plot=lineChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setOutlineVisible(false);

        
        ChartPanel barPanel =new ChartPanel(lineChart);
        panelTempGraph.removeAll();
        panelTempGraph.add(barPanel,BorderLayout.CENTER);
        panelTempGraph.validate();
     }
}


